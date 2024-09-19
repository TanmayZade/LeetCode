class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");

        int minLength = Integer.MAX_VALUE;
        for(int i = 0;i < strs.length;i++)
            minLength = Math.min(minLength,strs[i].length());
        
        boolean flag =true;

        for(int i = 0;i < minLength;i++){
            for(int j = 0; j < strs.length-1;j++){
                if(strs[j].charAt(i) != strs[j+1].charAt(i)){
                    flag = false;
                    break;
                }
            }
            if(flag == true)
                sb.append(strs[0].charAt(i));
            else
                break;
        }

        return sb.toString();
    }
}