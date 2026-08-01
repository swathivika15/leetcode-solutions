class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        if(n==0 || m==0)
            return -1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2)
                    dfs(grid,n,m,i,j,2);
            }
        }
        int ans=2;
        for(int[] r:grid){
            for(int c:r){
                if(c==1)
                    return -1;
                    ans=Math.max(ans,c);
            }
        }
        return ans-2;
    }
    void dfs(int[][] grid,int n,int m,int i,int j,int a){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0 ||(1<grid[i][j] && grid[i][j]<a))
            return;
        else{
            grid[i][j]=a;
            dfs(grid,n,m,i-1,j,a+1);
            dfs(grid,n,m,i+1,j,a+1);
            dfs(grid,n,m,i,j-1,a+1);
            dfs(grid,n,m,i,j+1,a+1);
        }
    }
}