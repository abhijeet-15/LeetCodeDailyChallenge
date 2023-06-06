//1502 https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

// sorting O(nlogn)
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for(int i=2; i<arr.length; i++){
            if(arr[i]-arr[i-1] !=  d) return false;
        }
        return true;
    }
}

//using a set TC O(n) and space O(n)
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Set<Integer> st = new HashSet<>();
        //find the max and the min element
        int min = arr[0];
        int max = arr[0];
        int n = arr.length;
        
        for(int i=1; i<n; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        
        if(max-min == 0) return true;
        if((max-min)%(n-1) != 0) return false;
        
        int d = (max-min)/(n-1);
        
        //fill arr elements in the set
        for(int i=0; i<n; i++) {
            st.add(arr[i]);
        }
        
        for(int i=0; i<n; i++) {
            int k = (i*d)+min;
            
            if(!st.contains(k)) {
                return false;
            }
            else {
                st.remove(k);
            }
        }
        
        return st.size() == 0;
        
    }
}