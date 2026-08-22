class Solution {
    public List<Integer> countSmaller(int[] a) {
        List<Integer> ans=new ArrayList<>();
        int mx=20001;
        ST obj=new ST(20001);
        for(int i=a.length-1;i>=0;i--){
            int x=a[i];
            x+=10000;
            int smallerthanX=obj.rangeQuery(0,x-1);
            ans.add(smallerthanX);
            obj.incFreq(x);
        }
        Collections.reverse(ans);
        return ans;
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