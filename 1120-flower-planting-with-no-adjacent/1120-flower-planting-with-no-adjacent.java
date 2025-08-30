class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i < paths.length;i++){
            adj.get(paths[i][0]-1).add(paths[i][1]-1);
            adj.get(paths[i][1]-1).add(paths[i][0]-1);
        }
        int ans[] = new int[n];
        for(int i = 0; i < n;i++){
            boolean[] used = new boolean[5];
            for(int nei : adj.get(i)){
                if(ans[nei] != 0)
                    used[ans[nei]] = true;
            }

            for(int c = 1; c <= 4;c++){
                if(!used[c]){
                    ans[i] = c;
                    break;
                }
            }
        }
        return ans;
    }
}
