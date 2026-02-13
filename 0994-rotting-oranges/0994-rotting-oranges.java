class Solution {
    class Pair{
        int row,col,time;
        Pair(int i,int j,int t){
            row = i;
            col = j;
            time = t;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair>qu = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i, j, 0));
                    vis[i][j]= true;
                }
            }
        }

        int ans = 0;
        //BFS
        while(!qu.isEmpty()){
            Pair p = qu.poll();
            int i = p.row;
            int j = p.col;
            int time = p.time;
            ans = Math.max(ans, time);

            //now call for 4 nbrs of 
            //top
            if(i-1 >=0 && !vis[i-1][j] && grid[i-1][j]==1){
                qu.add(new Pair(i-1,j,time+1));
                vis[i-1][j] = true;
            }
            //right
            if(j+1 < m && !vis[i][j+1] && grid[i][j+1]==1){
                qu.add(new Pair(i,j+1,time+1));
                vis[i][j+1] = true;
            }
            //bottom
            if(i+1 < n && !vis[i+1][j] && grid[i+1][j]==1){
                qu.add(new Pair(i+1,j,time+1));
                vis[i+1][j] = true;
            }
            //left
            if(j-1 >=0 && !vis[i][j-1] && grid[i][j-1]==1){
                qu.add(new Pair(i,j-1,time+1));
                vis[i][j-1] = true;
            }

        }
         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    return -1;
                }
            }
        }
        return ans;
    }
}