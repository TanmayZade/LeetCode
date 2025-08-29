class Solution {
    public int findJudge(int n, int[][] trust) {
        if(trust.length == 0)
            if(n == 1) return n;
            else return -1;
        int judge = -1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n+1;i++) adj.add(new ArrayList<>());

        for(int i = 0;i < trust.length;i++){
            adj.get(trust[i][0]).add(trust[i][1]);
        }

        for(int i = 1;i < n+1;i++)
            if(adj.get(i).size() == 0) judge = i;
        
        for(int i = 1;i < n+1;i++){
            int size = adj.get(i).size();
            boolean trustJ = false;
            if(size == 0) continue;
            for(int j = 0;j < size;j++){
                if(adj.get(i).get(j) == judge){
                    trustJ = true;
                }
            }
            if(!trustJ) return -1;
        }
        
        return judge;
    }
}