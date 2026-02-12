class Solution {
    public long ans=0;
    public long dfs(int start, ArrayList<ArrayList<Integer>>adj,boolean[]visited,int seats){    
        visited[start] = true;
        long cnt = 1;
        for(int nbr: adj.get(start)){
            if(!visited[nbr]){
                cnt += dfs(nbr,adj,visited,seats);
            }
        }

        if(start !=0){
            long car = cnt/seats;
            if(cnt % seats !=0)car++;
            ans+=car;
        }
        return cnt;
    }
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();

        int n = roads.length;

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            int u = roads[i][0];
            int v = roads[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int start = 0;
        ans=0;
        boolean[] visited = new boolean[n+1];
         dfs(start,adj,visited,seats);
        return ans;
    }
}