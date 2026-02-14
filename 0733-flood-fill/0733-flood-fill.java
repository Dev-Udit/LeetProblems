class Solution {
    class Pair{
        int row,col;
        Pair(int r,int c){
            row =r;
            col =c;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;

        int startColor = image[sr][sc];
        if(startColor == color) return image;

        Queue<Pair>qu = new LinkedList<>();
        qu.add(new Pair(sr,sc));

        boolean vis[][] = new boolean[n][m];
        vis[sr][sc] = true;

        while(!qu.isEmpty()){
            Pair curr = qu.poll();
            int i = curr.row;
            int j =curr.col;

            image[i][j] = color;

            //add just for 4 nbrs
            if(i-1 >=0 && image[i-1][j]==startColor && !vis[i-1][j]){
                qu.add(new Pair(i-1,j));
                vis[i-1][j] = true;
            }
            if(j+1 < m && image[i][j+1]==startColor && !vis[i][j+1]){
                qu.add(new Pair(i,j+1));
                vis[i][j+1] = true;
            }
            if(i+1 <n && image[i+1][j]==startColor && !vis[i+1][j]){
                qu.add(new Pair(i+1,j));
                vis[i+1][j] = true;
            }
            if(j-1 >=0 && image[i][j-1]==startColor && !vis[i][j-1]){
                qu.add(new Pair(i,j-1));
                vis[i][j-1] = true;
            }

        }
        return image;

    }
}