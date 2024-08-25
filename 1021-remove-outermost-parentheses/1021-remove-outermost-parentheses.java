import java.util.*;

class Solution {
    public String removeOuterParentheses(String str) {
        if(str.length() == 0)
            return str;
        
        int count = 0;
        
        Stack<Character> s = new Stack<>();
        int idx = 0;

        StringBuilder sb = new StringBuilder("");
        while(idx < str.length()){
            char top = str.charAt(idx);
            if(top == '('){
                if(!s.isEmpty()){
                    sb.append('(');
                }
                s.push(top);
            }
            else{
                s.pop();
                if(!s.isEmpty())
                    sb.append(top);
            }
            idx++;
        }
        return sb.toString();
    }
}