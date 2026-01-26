class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        Set<Character> st = new HashSet<>();
        int maxLen = 0;
        while(right < s.length()){
            Character ch = s.charAt(right);

            if(!st.contains(ch)){
                st.add(ch);
                maxLen = Math.max(maxLen, right++ - left + 1);
            }else{
                st.remove(s.charAt(left++));
            }
        }
        return maxLen;
    }
}