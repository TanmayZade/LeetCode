class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) return false;
        HashMap<Character, Integer> m = new HashMap<>();

        for(int i = 0;i < magazine.length();i++){
            Character ch = magazine.charAt(i);
            if(m.containsKey(magazine.charAt(i))){
                m.put(ch, m.get(ch) + 1);
            }else
                m.put(ch, 1);
        }

        for(int i = 0;i < ransomNote.length();i++){
            Character ch = ransomNote.charAt(i);
            if(m.containsKey(ch))
            {   if(m.get(ch) == 1) m.remove(ch);
                else{m.put(ch, m.get(ch) - 1);}
                }
            else
                return false;
        }
        return true;
    }
}