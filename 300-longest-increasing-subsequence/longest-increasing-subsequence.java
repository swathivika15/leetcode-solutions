class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        /*int[] cl=new int[n];
        for(int i=0;i<n;i++)
            cl[i]=nums[i];
        Arrays.sort(cl);*/
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
        int[][] dp=new int[a.length+1][b.length+1];
        for(int i=a.length-1;i>=0;i--){
            for(int j=b.length-1;j>=0;j--){
                if(a[i]==b[j])
                    dp[i][j]=1+dp[i+1][j+1];
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
            }
        }
        return dp[0][0];
    }
}