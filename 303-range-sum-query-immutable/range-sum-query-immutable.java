class NumArray {
    SegmentTree tree;
    public NumArray(int[] nums) {
        tree=new SegmentTree(nums);
    }
    
    public int sumRange(int left, int right) {
        return tree.rangeSum(0,0,tree.n-1,left,right);
    }
}
class SegmentTree{
    int[] a;
    int[] st;     
    int n;
    public SegmentTree(int[] arr){
        this.n=arr.length;
        this.a=new int[n];
        st=new int[4*n];
        for(int i=0;i<arr.length;i++)
            a[i]=arr[i];
        build_st(0,0,n-1);
    }
    void build_st(int idx,int ss,int se){
        if(ss>se)
            return;
        if(ss==se){
            st[idx]=a[ss];
            return;
        }
        int m=(ss+se)/2;
        build_st(2*idx+1,ss,m);
        build_st(2*idx+2,m+1,se);
        st[idx]=st[2*idx+1]+st[2*idx+2];
    }
    int rangeSum(int idx,int ss,int se,int qs,int qe){
        if(qe<ss || se<qs)
            return 0;
        if(qs<=ss && se<=qe)
            return st[idx];
        int m=(ss+se)/2;
        int lans=rangeSum(2*idx+1,ss,m,qs,qe);
        int rans=rangeSum(2*idx+2,m+1,se,qs,qe);
        return lans+rans;
    }
    public int sum(int idx,int qs,int qe){
        return rangeSum(idx,0,n-1,qs,qe);
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */