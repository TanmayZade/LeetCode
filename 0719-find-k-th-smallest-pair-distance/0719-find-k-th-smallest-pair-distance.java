class Solution {
    public int smallestDistancePair(int[] nums, int k) {
//         int n = nums.length;
//         int totPairs = n*(n-1)/2;
//         int diff[] = new int[totPairs];
//         int idx = 0;
//         for(int i = 0; i < nums.length; i++){
//             for(int j =i+1; j < nums.length;j++){
//                 diff[idx] = Math.abs(nums[i] - nums[j]);
//                 idx++;
//             }
//         }

//         Arrays.sort(diff);
//         return diff[k-1];
        
        
        
        
         Arrays.sort(nums);
        int low = 0, high = nums[nums.length - 1] - nums[0];
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(nums, mid) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
    
    private int countPairs(int[] nums, int mid) {
        int count = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            while (nums[right] - nums[left] > mid) {
                left++;
            }
            count += right - left;
        }
        return count;
    }
}