class Solution {
    public boolean isHappy(int n) {
        int temp = n;
        Set<Integer> st = new HashSet<>();

        while(true){
        int sum = 0;
        while(temp > 0){
            int digit = temp % 10;
            sum += digit * digit;
            temp /= 10;
        }   
            if(sum == 1) return true;
            if(st.contains(sum)) return false;
            else st.add(sum);
            temp = sum;
        }
        // return false;
    }
}