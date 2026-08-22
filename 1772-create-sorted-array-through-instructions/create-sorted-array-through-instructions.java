class Solution{
    public int createSortedArray(int[] a){
        long ans=0;
        int mx=100000;
        ST obj=new ST(mx);
        int MOD=1000000007;
        for(int x:a){
            long left=obj.rangeQuery(0,x-1);
            long right=obj.rangeQuery(x+1,mx);
            ans=(ans+Math.min(left,right))%MOD;
            obj.incFreq(x);
        }
        return (int)ans;
    }
}
class ST{
    long[] st;
    int max;
    public ST(int max){
        st=new long[4*(max+1)];
        this.max=max;
    }
    long rangeQuery(int l,int r){
        if(l>r)
            return 0;
        return range(0,0,max,l,r);
    }
    long range(int idx,int ss,int se,int qs,int qe){
        if(qe<ss||qs>se)
            return 0;
        if(ss>=qs&&se<=qe)
            return st[idx];
        int mid=(ss+se)/2;
        long lans=range(2*idx+1,ss,mid,qs,qe);
        long rans=range(2*idx+2,mid+1,se,qs,qe);
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