class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        boolean[] flip = new boolean[n];
        int flipped = 0; // Number of ongoing flips
        int result = 0; // Minimum number of flips needed

        for (int i = 0; i < n; i++) {
            // Adjust the flip count at the start of the window
            if (i >= k && flip[i - k]) {
                flipped--;
            }

            // Determine if we need to flip the current window
            if ((nums[i] == 0 && flipped % 2 == 0) || (nums[i] == 1 && flipped % 2 != 0)) {
                if (i + k > n) {
                    return -1; // Not enough elements to flip a full k-bit subarray
                }
                flip[i] = true;
                flipped++;
                result++;
            }
        }

        return result;
    }
}
