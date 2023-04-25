// https://leetcode.com/problems/smallest-number-in-infinite-set/

//approach 1 - brute force using an array
class SmallestInfiniteSet {
    
    private boolean nums[];
    int idx;

    public SmallestInfiniteSet() {
        
        this.nums = new boolean[1001];
        Arrays.fill(nums, true);
        this.idx = 1;
        
    }
    
    public int popSmallest() {
        
        int res = idx;
        nums[idx] = false;
        
        // simple idx++ ni kar skte, q ki maybe false ho agla wala already
        for(int i=idx+1; i<1001; i++) {
            if(nums[i] == true) {
                idx = i;
                break;
            }
        }
        
        return res;
    }
    
    public void addBack(int num) {
        
        nums[num] = true;
        
        if(num < idx) {
            idx = num;
        }
    }
}
