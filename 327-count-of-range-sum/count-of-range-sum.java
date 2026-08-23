class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n=nums.length;
        long[] pre=new long[n+1];
        for(int i=0;i<n;i++)
            pre[i+1]=pre[i]+nums[i];
        long[] vals=new long[n+1];
        for(int i=0;i<=n;i++)
            vals[i]=pre[i];
        Arrays.sort(vals);
        ST obj=new ST(n+1);
        long ans=0;
        for(int i=0;i<=n;i++){
            long left=pre[i]-upper;
            long right=pre[i]-lower;
            int l=lowerBound(vals,left);
            int r=upperBound(vals,right)-1;
            if(l<=r)
                ans+=obj.rangeQuery(l,r);
            int pos=lowerBound(vals,pre[i]);
            obj.incFreq(pos);
        }
        return (int)ans;
    }
    int lowerBound(long[] a,long x){
        int l=0,r=a.length;
        while(l<r){
            int m=(l+r)/2;
            if(a[m]>=x)
                r=m;
            else
                l=m+1;
        }
        return l;
    }
    int upperBound(long[] a,long x){
        int l=0,r=a.length;
        while(l<r){
            int m=(l+r)/2;
            if(a[m]>x)
                r=m;
            else
                l=m+1;
        }
        return l;
    }
}
class ST{
    int[] st;
    int max;
    public ST(int max){
        st=new int[4*(max+1)];
        this.max=max;
    }
    int rangeQuery(int l,int r){
        if(l>r)
            return 0;
        return range(0,0,max,l,r);
    }
    int range(int idx,int ss,int se,int qs,int qe){
        if(qe<ss||qs>se)
            return 0;
        if(ss>=qs&&se<=qe)
            return st[idx];
        int mid=(ss+se)/2;
        int lans=range(2*idx+1,ss,mid,qs,qe);
        int rans=range(2*idx+2,mid+1,se,qs,qe);
        return lans+rans;
    }
    void incFreq(int x){
        int idx=0,ss=0,se=max;
        while(ss<se){
            int mid=(ss+se)/2;
            if(x<=mid){
                idx=2*idx+1;
                se=mid;
            }
            else{
                idx=2*idx+2;
                ss=mid+1;
            }
        }
        st[idx]++;
        while(idx>0){
            idx=(idx-1)/2;
            st[idx]=st[2*idx+1]+st[2*idx+2];
        }
    }
}
