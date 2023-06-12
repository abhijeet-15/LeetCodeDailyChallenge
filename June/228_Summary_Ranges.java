// 228 https://leetcode.com/problems/summary-ranges/

// TC O(n) Space O(1)

//approach 1
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if(n == 0) return res;
        int lb = nums[0];
        int ub = nums[0];
        String temp;
        
        for(int i=1; i<n; i++) {
            
            if(nums[i] != nums[i-1]+1) {
                ub = nums[i-1];
                if(lb == ub) {     
                    temp = String.valueOf(lb);
                }
                else {
                    temp = String.valueOf(lb) + "->" + String.valueOf(ub); 
                }
                res.add(temp);
                lb = nums[i];
            }
            ub = nums[i];
        }
        
        if(lb == ub){
            temp = String.valueOf(lb);
        }
        else {
            temp = String.valueOf(lb) + "->" + String.valueOf(ub);
        }
        
        res.add(temp);
        
        return res;
    }
}

//cleaner 
class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        for(int i=0; i<n; i++) {
            int start = nums[i];
            while(i+1<n && nums[i] + 1 == nums[i+1]) {
                i++;
            }
            if(start != nums[i]) {
                res.add(String.valueOf(start)+"->"+String.valueOf(nums[i]));
            }
            else {
                res.add(String.valueOf(start));
            }
        }
        return res;
    }
}