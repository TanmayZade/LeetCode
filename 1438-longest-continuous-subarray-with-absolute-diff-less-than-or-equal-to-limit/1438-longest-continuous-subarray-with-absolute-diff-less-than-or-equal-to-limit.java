import java.util.*;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();
        int left = 0, SizeLongestSubarray = 0;

        for (int right = 0; right < nums.length; right++) {
            // Maintain maxDeque for the maximum values
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(right);

            // Maintain minDeque for the minimum values
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(right);

            // If the difference between the current max and min exceeds limit, adjust the left pointer
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                left++;
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }

            // Update the length of the longest subarray
            SizeLongestSubarray = Math.max(SizeLongestSubarray, right - left + 1);
        }

        return SizeLongestSubarray;
    }
}
