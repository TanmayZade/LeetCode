class Solution {
    class Node{
        int to;
        double succProb;
        Node(int to,double succProb){
            this.to = to;
            this.succProb = succProb;
        }
    }
    class Edge{
        int to;
        double wt;
        Edge(int to, double wt){
            this.to = to;
            this.wt = wt;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();

        for(int i = 0;i < n;i++) adj.add(new ArrayList<>());

        for(int i = 0;i < edges.length;i++){

            adj.get(edges[i][0]).add(new Edge(edges[i][1], succProb[i]));
            adj.get(edges[i][1]).add(new Edge(edges[i][0], succProb[i]));

        }


        double[] prob = new double[n];
        prob[start_node] = 1.0;


        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> Double.compare(b.succProb, a.succProb));

        pq.add(new Node(start_node,1.0));

        while(!pq.isEmpty()){
            int currNode = pq.peek().to;
            double succProb1 = pq.poll().succProb;

        for(Edge edge : adj.get(currNode)){
            int nextNode = edge.to;
            double nextProb = edge.wt;
            double newProb = succProb1 * nextProb;

            if(newProb > prob[nextNode]){
                prob[nextNode] = newProb;
                pq.add(new Node(nextNode, newProb));
            }
        }


        }
        return prob[end_node];
    }
}