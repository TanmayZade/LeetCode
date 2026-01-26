class Solution {
    public int strStr(String haystack, String needle) {

        int left = 0,idx = -1;
        while(left < haystack.length()){
            int tempLeft = left;
            if(haystack.charAt(tempLeft) == needle.charAt(0)){
                int right = 1;
                idx = tempLeft;
                tempLeft++;
                while(tempLeft < haystack.length() && right < needle.length()){
                    if(haystack.charAt(tempLeft) == needle.charAt(right)){
                        tempLeft++;
                        right++;
                    }else break;
                }
                if(right == needle.length()) return idx;
                else idx = -1;
            }            
            left++;
        }

        return idx;
    }
}