// 705 https://leetcode.com/problems/design-hashset/

//O(N) space and time complexity O(1)
class MyHashSet {
    private boolean[] st;
    
    public MyHashSet() {
        this.st = new boolean[1000001];
    }
    
    public void add(int key) {
        st[key] = true;
    }
    
    public void remove(int key) {
        st[key] = false;
    }
    
    public boolean contains(int key) {
        return st[key];
    }
}