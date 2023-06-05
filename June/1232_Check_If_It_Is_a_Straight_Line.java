// 1232 https://leetcode.com/problems/check-if-it-is-a-straight-line/

class Solution {
    
    private int getXDiff(int x1, int x2) {
        return x2-x1;
    }
    private int getYDiff(int y2, int y1) {
        return y2-y1;
    }

    public boolean checkStraightLine(int[][] c) {
        
        int deltaX = getXDiff(c[0][0],c[1][0]);
        int deltaY = getYDiff(c[0][1],c[1][1]);
        
        for(int i=2; i<c.length; i++) {
            if(deltaX * getYDiff(c[0][1],c[i][1]) != deltaY * getXDiff(c[0][0],c[i][0])) {
                return false;
            }
        }
        return true;
    }
}