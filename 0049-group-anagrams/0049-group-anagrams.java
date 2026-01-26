class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            char[] sArr = s.toCharArray();
            Arrays.sort(sArr);
            String st = new String(sArr);

            map.computeIfAbsent(st,k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}