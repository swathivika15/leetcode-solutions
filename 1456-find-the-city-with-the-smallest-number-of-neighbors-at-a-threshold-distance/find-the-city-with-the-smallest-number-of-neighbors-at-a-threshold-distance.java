class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int inf=Integer.MAX_VALUE;
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(dist[i],inf);
        for(int[] e:edges){
            int u=e[0],v=e[1],wt=e[2];
            dist[u][v]=dist[v][u]=wt;
        }
        for(int m=0;m<n;m++){            
            for(int s=0;s<n;s++){            
                for(int e=0;e<n;e++){
                    if(dist[s][m]==inf||dist[m][e]==inf)
                        continue;
                    dist[s][e]=Math.min(dist[s][e],dist[s][m]+dist[m][e]);
                }
            }
        }
        int c=0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int ans=0;
            for(int j=0;j<n;j++){
                if(i!=j&& dist[i][j]<=distanceThreshold)
                    ans++;
            }
                if(ans<=min){
                    min=ans;
                    c=i;
                }
        }
        return c;
    }
}