class KthLargest {
    
    private int k;
    private PriorityQueue<Integer> pq;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.pq = new PriorityQueue<>();
        
        //add elements to the heap
        for(int num : nums) {
            pq.offer(num);
        }
        
        //remove the extra elements till kth element is on top
        while(pq.size() > k) {
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        
        while(pq.size() > k) {
            pq.poll();
        }
        
        return pq.peek();
    }
}