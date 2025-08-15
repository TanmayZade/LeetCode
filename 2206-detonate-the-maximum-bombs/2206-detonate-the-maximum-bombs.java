// class Solution {

//     class DisjointSet{
//         ArrayList<Integer> parent = new ArrayList<>();
//         ArrayList<Integer> size = new ArrayList<>();
//         DisjointSet(int n){
//             for(int i = 0;i < n;i++){
//                 size.add(1);
//                 parent.add(i);
//             }
//         }

//         public int findUParent(int node){
//             if(node == parent.get(node)) return node;

//             int currPar = findUParent(parent.get(node));
//             parent.set(node, currPar);
//             return currPar;
//         }

//         public void union(int u, int v){
//             int ultP_u = findUParent(u);
//             int ultP_v = findUParent(v);

//             if(ultP_u == ultP_v) return; //it is already part of component;
//             if(size.get(ultP_u) < size.get(ultP_v)){
//                 size.set(ultP_v, size.get(ultP_u) + size.get(ultP_v));
//                 parent.set(ultP_u, ultP_v);
//             }else{
//                 size.set(ultP_u, size.get(ultP_u) + size.get(ultP_v));
//                 parent.set(ultP_v, ultP_u);
//             }
//         }
//     }
//     public int maximumDetonation(int[][] bombs) {
//         //to check if two circles are in each other range we just need to find distance between there centers and compare it with sum of radius,if it's less then there intersecting
//         int n = bombs.length;
//         DisjointSet dj = new DisjointSet(n);
//         for(int i = 0;i < n;i++){
//             for(int j = 0;j < n;j++){
//                 if(i == j) continue;
//                 int x1 = bombs[i][0];
//                 int x2 = bombs[j][0];
//                 int y1 = bombs[i][1];
//                 int y2 = bombs[j][1];
//                 int r1 = bombs[i][2];
//                 int r2 = bombs[j][2];
//                 //find distance between two bombs d = Math.sqrt((x1-x2)2 + (y1 - y2)2)
//                 int diffX = x1 - x2;
//                 int diffY = y1 - y2;

//                 int sumOfSquares = diffX * diffX + diffY * diffY;

//                 float d = (float)Math.sqrt(sumOfSquares);

//                 if(d <= r1 )
//                     dj.union(i,j);
//             }
//         }

//         int maxBombs = 0;
//         for(int i = 0;i < n;i++)
//             maxBombs = Math.max(maxBombs, dj.size.get(i));

//         return maxBombs;
//     }
// }

class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++) adj.add(new ArrayList<>());
        for(int i = 0;i < n;i++){
            for(int j = 0;j < n;j++){
                if(i == j) continue;
               long diffX = bombs[i][0] - bombs[j][0];
               long diffY =  bombs[i][1] - bombs[j][1];
               long distSq = diffX * diffX + diffY * diffY;
                long r1Sq = (long)bombs[i][2] * bombs[i][2];
                if(distSq <= r1Sq)
                    adj.get(i).add(j);
            }
        }
        int maxBombs = 0;
        for(int i = 0;i < n;i++)
            maxBombs = Math.max(maxBombs, bfsCount(i, adj));
        return maxBombs;

    }

    public int bfsCount(int start, ArrayList<ArrayList<Integer>> adj){
        int n = adj.size();
        boolean vis[] = new boolean[n];
        vis[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        int cnt = 1;
        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : adj.get(node)){
                if(!vis[it]){
                    q.add(it);
                    vis[it] = true;
                    cnt++;
                }
            }
        }

        return cnt;
    }
}