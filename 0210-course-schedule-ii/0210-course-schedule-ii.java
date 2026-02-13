class Solution {
    public void topo(int src, ArrayList<ArrayList<Integer>>adj, boolean vis[] ,Stack<Integer>st){
        vis[src] = true;

         for(int v:adj.get(src)){
            if(!vis[v]){
                topo(v,adj,vis,st);
            }
        }
        st.push(src);
    }

    public boolean isCycle(int src, ArrayList<ArrayList<Integer>>adj, boolean vis[] ,  boolean recPath[]){
        vis[src] = true;
        recPath[src] = true;

        for(int v:adj.get(src)){
            if(!vis[v]){
                if(isCycle(v,adj,vis,recPath))return true;
            }
            else if(recPath[v]) return true;
        }
        recPath[src] = false;
        return false;
    }



    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++)adj.add(new ArrayList<>());

        for(int e[] : prerequisites){
            adj.get(e[1]).add(e[0]);         //bcz b is necessary to take a (b should come first)
        }

        boolean vis[] = new boolean[numCourses];
        boolean recPath[] = new boolean[numCourses];
        
        //check for isCycle present in graph or not
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(isCycle(i,adj,vis,recPath))return new int[]{};      //if detected return empty array
            }
        }



        //if cycle not there go topological order
        int ans[] = new int[numCourses];
        Stack<Integer>st = new Stack<>();
        Arrays.fill(vis,false);
        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                topo(i,adj,vis,st);
            }
        }

        int i=0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }

        return ans;
    
    }
}