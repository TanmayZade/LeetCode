class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> al = new ArrayList<>();
        char[] pFreq = new char[26];
        char[] sFreq = new char[26];

        for(int i = 0;i < p.length();i++)
            pFreq[p.charAt(i) - 'a']++;
        int windowSize = p.length();

        for(int i = 0;i < s.length();i++){
            sFreq[s.charAt(i) - 'a']++;

            if(i >= windowSize)
                sFreq[(s.charAt(i - windowSize)) - 'a']--;
            
            if(Arrays.equals(pFreq,sFreq))
                al.add(i - windowSize + 1);
        }

        return al;
    }
}