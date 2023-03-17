// https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode{
    
	char data;
	TrieNode[] childre n;
	boolean isTerminal;
	
	TrieNode(char ch) {
        
		this.data=ch;
        this.children = new TrieNode[26];
        
		for(int i=0;i<26;i++) {
			children[i]=null;
		}
		isTerminal=false;
	}
}

class Trie {
    
    TrieNode root;
    
    public Trie() {
        
        root=new TrieNode('\u0000');
    }
    
    private void insertUtil(TrieNode root,String word) {
		
		if(word.length()==0) {
			root.isTerminal=true;
			return;
		}
        
		int index=word.charAt(0)-'a';
        
		TrieNode child=new TrieNode('\u0000');
		// present
		if(root.children[index]!=null) {
			child=root.children[index];
		}
        else {
			child=new TrieNode(word.charAt(0));
			root.children[index]=child;
		}
		// recursion
		insertUtil(child,word.substring(1));		
	}
    
    public void insert(String word) {
        insertUtil(root,word);
    }
    
    private boolean serachUtil(TrieNode root,String word) {
        
		if(word.length()==0)
			return root.isTerminal;
        
		TrieNode child=new TrieNode('\u0000');
		int index=word.charAt(0)-'a';
		if(root.children[index]!=null) {
			child=root.children[index];
		}
        else {
			return false;
		}
        
		return serachUtil(child,word.substring(1));
	}
    
    public boolean search(String word) {
        return serachUtil(root,word);
    }
    
     private boolean startsWithUtil(TrieNode root,String word) {
        
		if(word.length()==0)
			return true;
        
		TrieNode child=new TrieNode('\u0000');
		int index=word.charAt(0)-'a';
		if(root.children[index]!=null) {
			child=root.children[index];
		}
        else {
			return false;
		}
        
		return startsWithUtil(child,word.substring(1));
	}
    
    
    public boolean startsWith(String prefix) {
        return startsWithUtil(root,prefix);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */