class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int V = numCourses;
        for(int i = 0;i < V;i++) adj.add(new ArrayList<Integer>());
        int n = prerequisites.length;

        for(int i = 0;i < n;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int inDegree[] = new int[V];
        for(int i = 0;i < V;i++){
            for(int it : adj.get(i))
                inDegree[it]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0;i < V;i++)
            if(inDegree[i] == 0) q.add(i);

        ArrayList<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);

            for(int it : adj.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0)
                    q.add(it);
            }
        }

        if(topo.size() == V) return true;
        return false;
    }
}