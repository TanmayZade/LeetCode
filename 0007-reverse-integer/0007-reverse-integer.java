class Solution {
    public int reverse(int x) {
        long reverse = 0;
        int n = 0;

        while( x != 0){
            n = x % 10;
            x /= 10;

            reverse = (reverse * 10) + n;
        }

        if(reverse < Integer.MIN_VALUE || reverse > Integer.MAX_VALUE) return 0;

        return (int) reverse;
    }
}