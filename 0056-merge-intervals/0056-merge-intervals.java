class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if(n == 1) return intervals;
        if(n == 0) return new int[0][0];

        int[][] temp = new int[n][2];
                Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        int idx = 0;
        temp[0] = intervals[0];
        for(int i = 1;i < n;i++){
            if(temp[idx][1] >= intervals[i][0]){
                temp[idx][1] = Math.max(temp[idx][1], intervals[i][1]);
            }else{
                temp[++idx] = intervals[i];
            }
        }

        return Arrays.copyOf(temp, ++idx);

    }
}