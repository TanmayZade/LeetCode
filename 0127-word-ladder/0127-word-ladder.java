class Solution {
    class Pair{
        String first;
        int second;
        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();

        Set<String> st = new HashSet<>();

        for(int i = 0;i < wordList.size();i++){
            st.add(wordList.get(i));
        }

        q.add(new Pair(beginWord, 1));
        st.remove(beginWord);

        while(!q.isEmpty()){
            String word = q.peek().first;
            int steps = q.peek().second;
            q.poll();

            if(word.equals(endWord)) return steps;

            for(int i = 0;i < word.length();i++){
                for(char ch = 'a';ch <= 'z'; ch++){
                    char[] replacedWordArray = word.toCharArray();
                    replacedWordArray[i] = ch;
                    String replacedWord = new String(replacedWordArray);

                    if(st.contains(replacedWord)){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps+1));
                    }
                }
            }

        }

        return 0;
    }
}
