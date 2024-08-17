class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[n];
        
        // Initialize dp array with the first row
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }
        
        // Iterate over each row starting from the second row
        for (int i = 1; i < m; i++) {
            long[] left = new long[n];
            long[] right = new long[n];
            
            // Fill the left max array
            left[0] = dp[0];
            for (int j = 1; j < n; j++) {
                left[j] = Math.max(left[j - 1], dp[j] + j);
            }
            
            // Fill the right max array
            right[n - 1] = dp[n - 1] - (n - 1);
            for (int j = n - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[j] - j);
            }
            
            // Update dp array for current row
            for (int j = 0; j < n; j++) {
                dp[j] = points[i][j] + Math.max(left[j] - j, right[j] + j);
            }
        }
        
        // Find the maximum value in the last dp array
        long maxScore = 0;
        for (int j = 0; j < n; j++) {
            maxScore = Math.max(maxScore, dp[j]);
        }
        
        return maxScore;
    }
}
