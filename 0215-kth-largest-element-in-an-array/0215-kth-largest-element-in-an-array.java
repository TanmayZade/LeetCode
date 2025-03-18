class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num:nums){
            pq.add(num);
        }

        for(int i = 0;i < k-1;i++){
            pq.remove();
        }

        return pq.peek();
    }
}