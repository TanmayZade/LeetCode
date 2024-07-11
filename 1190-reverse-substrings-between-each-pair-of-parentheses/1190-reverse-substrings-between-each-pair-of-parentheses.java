class Solution {
    public String reverseParentheses(String s) {
        char ar[] = s.toCharArray();
        return helperfunc(ar);
    }
    int i = 0;
    public String helperfunc(char[] s){
        StringBuilder sb = new StringBuilder();

        while(i < s.length){
            if(s[i] == ')'){
                i++;
                return sb.reverse().toString();
            }
            else if(s[i] == '('){
                i++;
                String st = helperfunc(s);
                sb.append(st);
            }
            else{
                sb.append(s[i]);
                i++;
            }
        }
        return sb.toString();
    }
}