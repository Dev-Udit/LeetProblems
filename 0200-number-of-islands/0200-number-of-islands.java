class Solution {

    public void dfs(int i,int j,char[][] grid,boolean [][] vis, int n, int m){
        if(i<0 || j<0 || i>=n || j>=m || vis[i][j]==true || grid[i][j] != '1'){
            return;
        }

        vis[i][j] =true;
        dfs(i-1,j,grid,vis,n,m); //top
        dfs(i,j+1,grid,vis,n,m); //right
        dfs(i+1,j,grid,vis,n,m); //bottom
        dfs(i,j-1,grid,vis,n,m); //left

    }



    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m =grid[0].length;
        boolean [][] vis = new boolean[n][m];
        int islands = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==false){
                    dfs(i,j,grid,vis,n,m);
                    islands++;
                }
            }
        }
        return islands;
        
    }
}