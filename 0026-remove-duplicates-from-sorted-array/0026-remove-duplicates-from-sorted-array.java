class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> st = new HashSet<>();

        for(int i = 0;i < nums.length;i++)
            st.add(nums[i]);
        int res = st.size(), j = 0;
        for(int i = 0;i < nums.length;i++){
            if(!st.isEmpty()){
                if(st.contains(nums[i])){
                    nums[j++] = nums[i];
                    st.remove(nums[i]);
                }else continue;
            }else break;
        }
        return res;
    }
}