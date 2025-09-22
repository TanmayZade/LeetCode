// class Solution {
//     public boolean isHappy(int n) {
//         int temp = n;
//         Set<Integer> st = new HashSet<>();

//         while(true){
//         int sum = 0;
//         while(temp > 0){
//             int digit = temp % 10;
//             sum += digit * digit;
//             temp /= 10;
//         }   
//             if(sum == 1) return true;
//             if(st.contains(sum)) return false;
//             else st.add(sum);
//             temp = sum;
//         }
//         // return false;
//     }
// }

class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
}