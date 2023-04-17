// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int n = candies.length;
        int maxi = Integer.MIN_VALUE; // or 0 as per constraint
        for(int candy : candies) {
            maxi = Math.max(maxi, candy);
        }
        
        List<Boolean> res = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            res.add(candies[i]+extraCandies >= maxi);
        }
        
        return res;      
    }
}