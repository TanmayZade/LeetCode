class Solution {
    public int nthUglyNumber(int n) {
                // Array to store ugly numbers
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        
        // Pointers for 2, 3, and 5
        int i2 = 0, i3 = 0, i5 = 0;
        
        // Initial multiples of 2, 3, and 5
        int nextMultipleOf2 = 2;
        int nextMultipleOf3 = 3;
        int nextMultipleOf5 = 5;
        
        for (int i = 1; i < n; i++) {
            // Choose the minimum value from the next multiples
            int nextUgly = Math.min(nextMultipleOf2, Math.min(nextMultipleOf3, nextMultipleOf5));
            uglyNumbers[i] = nextUgly;
            
            // Update the pointer and the next multiple if the chosen multiple was used
            if (nextUgly == nextMultipleOf2) {
                i2++;
                nextMultipleOf2 = uglyNumbers[i2] * 2;
            }
            if (nextUgly == nextMultipleOf3) {
                i3++;
                nextMultipleOf3 = uglyNumbers[i3] * 3;
            }
            if (nextUgly == nextMultipleOf5) {
                i5++;
                nextMultipleOf5 = uglyNumbers[i5] * 5;
            }
        }
        
        // The nth ugly number
        return uglyNumbers[n - 1];
    }
}