class Solution {

    public void dfs(int[][] image, int i, int j, int orgcolor, int newcolor,int n,int m){
        
        if(i<0 || j<0 ||i>=n || j>=m ||image[i][j] != orgcolor)return;
        image[i][j] = newcolor;

        dfs(image,i-1,j,orgcolor,newcolor,n,m);
        dfs(image,i,j+1,orgcolor,newcolor,n,m);
        dfs(image,i+1,j,orgcolor,newcolor,n,m);
        dfs(image,i,j-1,orgcolor,newcolor,n,m);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m =image[0].length;

        int orgcolor = image[sr][sc];
        if(orgcolor == color)return image;

        dfs(image,sr,sc,orgcolor,color,n,m);
        return image;
        
    }
}