class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int nr = ransomNote.length();
        int nm = magazine.length();
        int[] r = new int[26];
        int[] m = new int[26];

        for(int i = 0;i < nr;i++) r[ransomNote.charAt(i) - 'a']++;
        for(int i = 0;i < nm;i++) m[magazine.charAt(i) - 'a']++;

        for(int i = 0;i < 26;i++){
            if(r[i] > m[i]) return false;
        }

        return true;
    }
}