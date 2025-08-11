class Solution {
    class Pair{
        int first, second;
        Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
    class Tuple{
        int stop, node, cost;
        Tuple(int stop, int node, int cost){
            this.stop = stop;
            this.node = node;
            this.cost = cost;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i = 0;i < n;i++) adj.add(new ArrayList<>());

        for(int i = 0;i < flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }

        Queue<Tuple> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        q.add(new Tuple(0,src,0));
        while(!q.isEmpty()){
            Tuple it = q.poll();
            int stop = it.stop;
            int node = it.node;
            int cost = it.cost;
            if(stop > k) continue;
            for(Pair iter : adj.get(node)){
                int nextNode = iter.first;
                int edW = iter.second;

                if(cost + edW < dist[nextNode]){
                    dist[nextNode] = cost + edW;
                    q.add(new Tuple(stop+1,nextNode, cost+edW));
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) return -1;
        else return dist[dst];
    }
}