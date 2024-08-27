class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums.length == 0)
            return nums;
        int nextGreater[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 2*nums.length - 1 ; i >= 0;--i){
            int currIdx = i % nums.length;
            while(!s.isEmpty() && nums[s.peek()] <= nums[currIdx])
                s.pop();

            if(s.isEmpty())
                nextGreater[currIdx] = -1;
            else
                nextGreater[currIdx] = nums[s.peek()];

            s.push(currIdx);

        }
        return nextGreater;
    }
}