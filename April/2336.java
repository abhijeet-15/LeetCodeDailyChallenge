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


// approach 2 --> using set and a priority queue

class SmallestInfiniteSet {
    
    private int currSmallest;
    private PriorityQueue<Integer> pq;
    private Set<Integer> st;

    public SmallestInfiniteSet() {
        
        this.currSmallest = 1;
        this.pq = new PriorityQueue<Integer>((a,b)->(a-b));
        this.st = new HashSet<>();
    }
    
    public int popSmallest() {
        
        int res;
        
        if(!pq.isEmpty()) {
            res = pq.peek();
            pq.poll();
            
            st.remove(res);
        }
        
        else {
            res = currSmallest;
            currSmallest++;
        }
        
        return res;
    }
    
    public void addBack(int num) {
        
        if(num >= currSmallest || st.contains(num)) {
            return;
        }
        
        st.add(num);
        pq.offer(num);
    }
}


// approach 3 : Using a ordered set . SortedSet --> TreeSet

class SmallestInfiniteSet {
    
    private SortedSet<Integer> st;
    private int currSmallest;

    public SmallestInfiniteSet() {
        this.st = new TreeSet<>();
        currSmallest = 1;
    }
    
    public int popSmallest() {
        
        int res;
        
        if(!st.isEmpty()) {
            res = st.first();
            st.remove(res);
        }
        
        else {
            res = currSmallest;
            currSmallest++;
        }
        
        return res;
    }
    
    public void addBack(int num) {
        
        if(currSmallest <= num || st.contains(num)) {
            return;
        }
        
        st.add(num);
    }
}