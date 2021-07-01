class Trie {
    
    TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!curr.isInChildren(c)) curr.insertChild(c);
            curr = curr.getChild(c);
        }
        curr.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!curr.isInChildren(c)) return false;
            curr = curr.getChild(c);
        }
        return curr.getIsWord();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       TrieNode curr = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!curr.isInChildren(c)) return false;
            curr = curr.getChild(c);
        }
        return true;
    }
    
    class TrieNode {
        
        TrieNode[] children;
        boolean isWord;
        char c;
        
        TrieNode(char c){
            this.c = c;
            children = new TrieNode[26];
        }
        
        public void insertChild(char c){
            children[c - 'a'] = new TrieNode(c);
        }
       
        public boolean isInChildren(char c){
            return children[c - 'a'] != null;
        }
        
        public TrieNode getChild(char c){
            return children[c - 'a'];
        }
        
        public boolean getIsWord(){
            return isWord;
        }
        
        public void setIsWord(boolean bool){
            isWord = bool;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
