class Solution {
    public int[] twoSum(int[] num, int t) {
        for(int i = 1; i < num.length; i++){
            for(int j = i; j < num.length; j++) {
                if(num[j] + num[j - i] == t) {
                return new int[]{j, j - i};
                }
            }
        }
        return new int[]{};
    }
}