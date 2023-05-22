// max heap
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> mp.get(b)-mp.get(a));
        
        for(int key : mp.keySet()){
            pq.add(key);
        }
        
        int[] res = new int[k];
        for(int i=0; i<k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }
}


// min heap
class Pair{

    int first;
    int second;
    public Pair(int first,int second){
        
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num : nums) {
            mp.put(num, mp.getOrDefault(num,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y) -> x.first - y.first);
        
        for(var entry : mp.entrySet()) {
            int value = entry.getKey();
            int freq = entry.getValue();
            
            pq.offer(new Pair(freq,value));
            
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        int[] result = new int[k];
        for(int i=0; i<k; i++){
            result[i] = pq.poll().second;
        }
        return result;
    }
} 

// Bucket sort solution
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : nums){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] bucket = new ArrayList[n + 1];
        
        for(int value : mp.keySet()){
            int freq = mp.get(value);
            if(bucket[freq] == null){
                bucket[freq] = new ArrayList();
            }
            bucket[freq].add(value);
        }
        
        int res[] = new int[k];
        int index = 0;
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(int v : bucket[i]){
                    res[index++] = v;
                    if(index == k) return res;
                }
            }
        }
        return res;
    }
}