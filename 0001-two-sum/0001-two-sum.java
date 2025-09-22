class Solution {
    public int[] twoSum(int[] num, int t) {
        for(int i = 1; i < num.length; i++){
            for(int j = i; j < num.length; j++) {
                if(num[j] + num[j - i] == t) {
                return new int[]{j, j - i};
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for(int i = 0;i < nums.length;i++){
            for(int j = i+1; j < nums.length;j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return new int[]{};
        return result;
    }
}
