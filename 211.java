// https://leetcode.com/problems/design-add-and-search-words-data-structure/

class TrieNode {
    
    boolean isEndOfWord;
    TrieNode children[];
    
    TrieNode() {
        this.isEndOfWord = false;
        
        this.children = new TrieNode[26];
        
        for(int i=0; i<26; i++) {
            this.children[i] = null;
        }
    }
}


class WordDictionary {
    
    private TrieNode root;

    public WordDictionary() {
        
        this.root = new TrieNode();
        
    }
    
    public void addWord(String word) {
        
        TrieNode crawler = root;
        
        for(int i=0; i<word.length(); i++) {
            
            char ch = word.charAt(i);
            int idx = ch - 'a';
            
            if(crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            
            crawler = crawler.children[idx];
        }
        
        crawler.isEndOfWord = true;
    }
    
    private boolean searchUtil(String word, int pos, TrieNode crawler) {
        
        if(pos == word.length()) {
            return crawler.isEndOfWord;
        }
        
        char ch = word.charAt(pos);
        
        if(ch == '.') {
            
            for(int i=0; i<26; i++) {
                if(crawler.children[i] != null && searchUtil(word, pos+1, crawler.children[i])) {
                    return true;
                }
            }
        }
        
        else {
            
            int idx = ch - 'a';
            
            if(crawler.children[idx] != null && searchUtil(word, pos+1, crawler.children[idx])) {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean search(String word) {
        return searchUtil(word, 0, root);
    }
}
