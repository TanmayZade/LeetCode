class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length*grid.length + 1;
        int count[] = new int[n];
        int result[] = new int[2];

        for(int i = 0;i < grid.length;i++){
            for(int j = 0; j < grid.length;j++){
                count[grid[i][j]]++;
            }
        }

        for(int i = 1;i < n;i++){
            if(count[i] == 2)
                result[0] = i;
            if(count[i] == 0)
                result[1] = i;
            if(result[0] != 0 && result[1] != 0)
                break;
        }

        return result;
    }
}