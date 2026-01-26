class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums){
            freq.put(i, freq.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> freq.get(a)-freq.get(b));

        for(int key : freq.keySet()){
            pq.offer(key);
            if(pq.size() > k){
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for(int i = k-1;i >= 0;i--){
            ans[i] = pq.poll();
        }
        return ans;
    }
}