class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();

        int n = graph.length;

        for(int i = 0;i < n;i++) adjRev.add(new ArrayList<Integer>());

        int[] inDegree = new int[n];
        for(int i = 0;i < n;i++){
            for(int j : graph[i]){
                adjRev.get(j).add(i);
                inDegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        ArrayList<Integer> safeNodes = new ArrayList<>();

        for(int i = 0;i < n;i++)
            if(inDegree[i] == 0) q.add(i);

        while(!q.isEmpty()){
            int node = q.poll();

            safeNodes.add(node);

            for(int it:adjRev.get(node)){
                inDegree[it]--;
                if(inDegree[it] == 0)
                    q.add(it);
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }
}