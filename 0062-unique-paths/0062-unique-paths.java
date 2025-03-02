class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n]; // Memoization table
        return countPaths(0,0,m,n,dp);
    }

    public static int countPaths(int i,int j,int m,int n,int[][] dp){
        if(i >= m || j >= n)
            return 0;

        if(i == m-1 && j == n-1)
            return 1;

        if(dp[i][j] != 0) return dp[i][j];

        int rightMove = countPaths(i,j+1,m,n,dp);
        int downMove = countPaths(i+1,j,m,n,dp);

        dp[i][j] = rightMove + downMove;
        return dp[i][j];
    }
}