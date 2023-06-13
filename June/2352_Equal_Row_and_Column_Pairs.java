/*
 * 2352 
 */

 // using hashmap TC O(n^2) SC O(n^2)
 class Solution {
    public int equalPairs(int[][] grid) {
        Map<String,Integer> mp = new HashMap<>();
        
        //fill the map with row frequency O(n^2)
        for(int[] g : grid) {
            String temp = "";
            for(int r : g) {
                temp += "+" + r;
            }
            mp.put(temp,mp.getOrDefault(temp,0)+1);
        }
        
        int res = 0;
        //O(n^2)
        for(int i=0; i<grid.length; i++) {
            String temp = "";
            for(int j=0; j<grid[0].length; j++) {
               temp += "+" + grid[j][i];
            }
            res += mp.getOrDefault(temp,0);
        }
        return res;
    }
}

//brute force
class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;   
        int count = 0;
      
        for(int r = 0; r<n; r++) {    
            for(int c = 0; c < n; c++) {         
                int is_equal = 1;
                
                for(int i = 0; i < n; i++) {   
                    if(grid[r][i] != grid[i][c]) {
                        is_equal = 0;
                        break;
                    }        
                }        
                count += is_equal;          
            }        
        }      
        return count;
    }
}