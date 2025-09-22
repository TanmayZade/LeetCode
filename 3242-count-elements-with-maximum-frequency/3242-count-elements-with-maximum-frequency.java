class Solution {
    public int maxFrequencyElements(int[] nums) {
        int count[] = new int[101];

        for(int i = 0;i < nums.length;i++){
            count[nums[i]]++;
        }

        int maxFreq = Integer.MIN_VALUE, totalFreq = 0;

        for(int i = 1;i <= 100;i++ ){
            if(count[i] > maxFreq){
                maxFreq = count[i];
                totalFreq = count[i];
            }else if(count[i] == maxFreq){
                totalFreq += count[i];
            }
        }

        return totalFreq;
    }
}