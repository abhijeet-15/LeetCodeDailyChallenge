/*
 * https://leetcode.com/problems/new-21-game/
 * 837
 */

 // Brute force TLE
 class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n+1];
        //P[i] --> probability of getting score = i
        P[0]=1; // she already has this score
        for(int i=1; i<n+1; i++) {
            for(int j=1; j<=maxPts; j++){
                //probability of score j = 1/maxPts
                //remanining score = i-j == P[i-j]
                if(i-j>=0 && (i-j)<k)
                    P[i] += P[i-j]/maxPts;
            }
        }
        double result = 0.0;
        for(int i=k; i<n+1; i++){
            result += P[i];
        }
        return result;
    }
}


// Optimal
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] P = new double[n+1];
        P[0]=1;
        double currProbSum = k==0? 0:1;
        for(int i=1; i<n+1; i++){
            P[i] = currProbSum/maxPts;
            
            if(i<k)
                currProbSum += P[i];
                
            if(i-maxPts >=0 && i-maxPts<k)
                currProbSum -= P[i-maxPts];
            
        }
        double result = 0.0;
        for(int i=k; i<n+1; i++){
            result += P[i];
        }
        return result;
    }
}
