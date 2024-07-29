class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        if(n < 3) return 0;


        int counter = 0;
        for(int i = 0; i < rating.length;i++){
            for(int j =i+1;j < rating.length;j++){
                for(int k = j+1 ; k < n;k++){
                    if((rating[i] < rating[j] && rating[j] < rating[k] )  || (rating[i] > rating[j] && rating[j] > rating[k]))
                        counter++;
                }
            }
        }
        return counter;
    }
}