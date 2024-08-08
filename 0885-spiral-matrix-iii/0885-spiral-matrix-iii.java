class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int[][] result = new int[rows * cols][2];
        int idx = 0;
        int direction = 0; // Initialize direction to move right

        // Initial position
        result[idx++] = new int[]{rStart, cStart};

        // Initial step size is 1
        int steps = 1;

        while (idx < rows * cols) {
            // Two iterations for the two turns in each step increment
            for (int i = 0; i < 2; ++i) {
                // Move in the current direction 'steps' times
                for (int j = 0; j < steps; ++j) {
                    rStart += directions[direction][0];
                    cStart += directions[direction][1];
                    
                    if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                        result[idx++] = new int[]{rStart, cStart};
                    }
                }
                // Change direction
                direction = (direction + 1) % 4;
            }
            // Increase step size after completing two directions
            steps++;
        }
        return result;
    }
}
