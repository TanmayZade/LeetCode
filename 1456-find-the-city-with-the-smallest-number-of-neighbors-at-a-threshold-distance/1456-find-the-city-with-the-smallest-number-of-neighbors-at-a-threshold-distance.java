class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int cost[][] = new int[n][n];
        final int INF = 1_000_000_00;
for (int i = 0; i < n; i++) {
    Arrays.fill(cost[i], INF);
}        for(int[] edge : edges){
            cost[edge[0]][edge[1]] = edge[2];
            cost[edge[1]][edge[0]] = edge[2];
        }
        for(int i = 0;i < n;i++){
            cost[i][i] = 0;
        }

        for(int via = 0;via < n;via++){
    
            for(int i = 0;i < n;i++){
                if(cost[i][via] == INF) continue;
                for(int j = 0;j < n;j++){
                    if(cost[via][j] == INF)continue;                    
                    long sum = (long) cost[i][via] + cost[via][j];
                        if(sum < cost[i][j]) cost[i][j] = (int)sum;                       
                }
            }
        }
        int minTh = n+1;
        int node = -1;
        for(int i = 0;i < n;i++){
            int LessThanT = 0;
            for(int j = 0;j < n;j++){
                if(i == j) continue;
                if(cost[i][j] <= distanceThreshold) LessThanT++;
            }
            if(LessThanT <= minTh){
                node = i;
                minTh = LessThanT;
            }
        }
        return node;
    }
}