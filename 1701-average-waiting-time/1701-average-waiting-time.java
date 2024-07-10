class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        double WT = 0;
        int CT[] = new int[n];

        CT[0] = customers[0][0] + customers[0][1];
        WT += CT[0] - customers[0][0];
        for(int i = 1;i < n;i++){
            if(customers[i][0] > CT[i - 1])
                CT[i] = customers[i][0] + customers[i][1];

            else
                CT[i] = CT[i-1] + customers[i][1];

            WT += CT[i] - customers[i][0];

        }
        return WT/n;
    }
}