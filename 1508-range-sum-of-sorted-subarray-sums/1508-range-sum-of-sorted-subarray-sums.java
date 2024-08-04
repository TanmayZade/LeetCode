class Solution {
        public static final int MOD = 1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        int ArrSum[] = new int[(n*(n+1)/2)];
        int Idx = 0;
        for(int i = 0;i < nums.length;i++){
            for(int j = i; j < nums.length;j++){
                int sum = 0;
                for(int k = i ;k <= j;k++){
                    sum += nums[k];
                }
                ArrSum[Idx] = sum;
                Idx++; 
            }
        }
        Arrays.sort(ArrSum);

        long FinalSum = 0;
        for(int m = left-1 ; m <= right-1;m++){
            FinalSum =(FinalSum + ArrSum[m]) % MOD;
        }
        return (int)FinalSum ;
    }
}