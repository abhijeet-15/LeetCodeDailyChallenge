// 1146 https://leetcode.com/problems/snapshot-array/

class SnapshotArray {
    int snapId = 0;
    TreeMap<Integer, Integer>[] historyRecords;
    
    public SnapshotArray(int length) {
        historyRecords = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            historyRecords[i] = new TreeMap<Integer, Integer>();
            historyRecords[i].put(0, 0);
        }
    }

    public void set(int index, int val) {
        historyRecords[index].put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        return historyRecords[index].floorEntry(snapId).getValue();
    }
}

// Using ArrayList
class SnapshotArray {
    
    private int snapId;
    private List<List<Pair<Integer,Integer>>> list;
    
    public SnapshotArray(int length) {
        
        this.snapId = 0;
        this.list = new ArrayList<>(length);
        for(int i=0; i<length; i++) {
            List<Pair<Integer,Integer>> temp = new ArrayList<>();
            temp.add(new Pair(0,0));
            list.add(i,temp);
        }
    }
    
    public void set(int index, int val) {
        list.get(index).add(new Pair(snapId, val));
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        int start=0; int end = list.get(index).size()-1;
        int ans = 0;
        
        while(start <= end) {
            int mid = start + (end-start)/2;
            System.out.println(list.get(index).get(mid).getKey());
            if((list.get(index).get(mid).getKey()) <= snap_id) {
                ans = list.get(index).get(mid).getValue();
                start = mid+1;
            } 
            else {
                end = mid-1;
            }
        }
        return ans;
    }
}