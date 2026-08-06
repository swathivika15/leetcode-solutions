class Solution {
    public boolean isHappy(int n) {
        int s=n,f=n;
        do{
            s=sumOfSquares(s);
            f=sumOfSquares(sumOfSquares(f));
        }while(s!=f);
        return s==1;
    }
    int sumOfSquares(int n){
        int sqsum=0;
        while(n>0){
            int r=n%10;
            sqsum+=r*r;
            n/=10;
        }
        return sqsum;
    }
}