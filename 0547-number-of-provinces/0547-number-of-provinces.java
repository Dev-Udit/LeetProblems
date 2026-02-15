class Solution {

    public void dfs(int src,int[][] isConnected, boolean vis[]){
        vis[src] = true;

        for(int i=0;i<isConnected.length;i++){
            if(i != src)continue;
            for(int j=0;j<isConnected[0].length;j++){
                if(isConnected[i][j] == 1 && !vis[j]){
                    dfs(j, isConnected, vis);
                }
            }
        }

        
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int m = isConnected[0].length;
        
        boolean vis[]= new boolean[n];
        int province = 0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,isConnected,vis);
                province++;
            }
            
        }
        return province;
    }
}