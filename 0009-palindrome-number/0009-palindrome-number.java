class Solution {
    public boolean isPalindrome(int x) {
        if(x == 0) return true;
        int n = (int)Math.log10(x) + 1;
        int rev = 0, k = 0,y = x;
        if(x < 0) return false;

        while(x > 0){
            k = x % 10;
            rev = (rev * 10) + k;
            x /= 10;
        }
        if(rev ==y )return true;
        else return false;
    }
}