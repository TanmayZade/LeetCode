class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        for(int i= 0;i < s.length/2;i++){
            //swap
            char temp = s[i];
            s[i] = s[n-1-i];
            s[n-1-i] = temp;
        }
    }
}