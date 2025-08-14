class Solution {

            static class DisjointSet{
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        DisjointSet(int n){
            for(int i = 0;i <= n;i++){
                size.add(1);
                parent.add(i);
            }
        }

        public int findParent(int node){
            if(node == parent.get(node)) return node;

            int ult_parent = findParent(parent.get(node));
            parent.set(node, ult_parent);
            return ult_parent;
        }

        public void unionBySize(int u,int v){
            int ultP_u = findParent(u);
            int ultP_v = findParent(v);
            if(ultP_v == ultP_u) return;

            if(size.get(ultP_u) < size.get(ultP_v)){
                parent.set(ultP_u, ultP_v);
                size.set(ultP_v, size.get(ultP_u) + size.get(ultP_v));
            }else{
                parent.set(ultP_v, ultP_u);               
            size.set(ultP_u, size.get(ultP_u) + size.get(ultP_v));
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n = stones.length;

        int maxRow = 0, maxCol = 0;

        for(int i = 0;i < n;i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }
        DisjointSet dj = new DisjointSet(maxRow + maxCol + 1);
        HashMap<Integer, Integer> stoneNodes = new HashMap<>();

        for(int i = 0;i < n;i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;

            dj.unionBySize(nodeRow, nodeCol);

            stoneNodes.put(nodeRow, 1);
            stoneNodes.put(nodeCol, 1);
        }

        int cnt = 0;
        for(Map.Entry<Integer, Integer> it : stoneNodes.entrySet()){
            if(dj.findParent(it.getKey()) == it.getKey()) cnt++;
        }

        return n - cnt;

    }
}