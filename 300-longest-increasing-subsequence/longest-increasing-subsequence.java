class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        Set<Integer> s=new TreeSet<>();
        for(int i=0;i<n;i++)
            s.add(nums[i]);
        int[] nums2=new int[s.size()];
        int i=0;
        for(int x:s){
            nums2[i]=x;
            i++;
        }
        return lcs(nums,nums2);
    }
    int lcs(int[] a,int[] b){
        int n1=a.length,n2=b.length;
        int[][] dp=new int[n1+1][n2+1];
        for(int i=n1-1;i>=0;i--){
            for(int j=n2-1;j>=0;j--){
                if(a[i]==b[j])
                    dp[i][j]=1+dp[i+1][j+1];
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}