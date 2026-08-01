class Pair{
    int i,j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int ans=0,n=grid.length,m=grid[0].length;
        int[] dx={0,0,1,-1},dy={1,-1,0,0};
        int[][] days=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i,j));
                    days[i][j]=0;
                }
            }
        }
        while(!q.isEmpty()){
            Pair c=q.poll();
            int x=c.i,y=c.j;
            for(int i=0;i<4;i++){
                int nx=x+dx[i],ny=y+dy[i];
                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==1){
                    q.add(new Pair(nx,ny));
                    grid[nx][ny]=2;
                    days[nx][ny]=days[x][y]+1;
                    ans=Math.max(ans,days[nx][ny]);
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1)
                    return -1;
            }
        }
        return ans;
    }
}