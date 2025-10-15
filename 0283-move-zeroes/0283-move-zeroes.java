class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> al = new ArrayList<>();

        for(int num : nums)
            if(num != 0) al.add(num);
        
        for(int i = 0;i < al.size();i++)
            nums[i] = al.get(i);

        for(int i = al.size();i < nums.length;i++)
            nums[i] = 0;
    }
}