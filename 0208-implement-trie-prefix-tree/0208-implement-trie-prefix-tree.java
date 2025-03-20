class Trie {
    static class Node{
        Node children[] = new Node[26];
        boolean eow = false;

        Node(){
            for(int i = 0;i < 26;i++)
                children[i] = null;
        }
    }

    public static Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(int level =0;level < word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null)
                curr.children[idx] = new Node();
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    
    public boolean search(String word) {
                Node curr = root;
        for(int level =0;level < word.length();level++){
            int idx = word.charAt(level) - 'a';
            if(curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return curr.eow == true;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(int level = 0;level < prefix.length();level++){
            int idx = prefix.charAt(level) - 'a';
            if(curr.children[idx] == null)
                return false;
            curr = curr.children[idx];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */