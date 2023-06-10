// 1802 https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/

// NlogN TLE O(1)
class Solution {
    
    public boolean isPossible(int n,int target, int maxSum, int index) {
        long le = index;
        long re = n-(index+1);
        
        long ls=0; long rs=0;
        long lt=target-1; long rt=target-1;
        long cl=0; long cr=0;
        
        while(le-- > 0) {
            cl++;
            ls+= lt;
            if(lt > 1)
                --lt;
        }
        while(re-- > 0) {
            cr++;
            rs+= rt;
            if(rt > 1)
                --rt;
        }
        
        //if(cl+cr+1 != n) return false;
        
        //System.out.println(ls + " " + target + " " + rs);
        
        return ls+target+rs <= (long)maxSum;
        
    }
    
    public int maxValue(int n, int index, int maxSum) {
        
        if(n == 1) return maxSum;
        
        int left=1; int right=maxSum;
        int mid = left + (right-left)/2;
        int ans = -1;
        while(left < right) {
            mid = left + (right-left)/2;
            if(isPossible(n,mid,maxSum,index)) {
                ans = mid;
                left = mid+1;
            }
            else {
                right = mid;
            }
        }
        return ans;
    }
}

//Log N O(1)

class Solution {
    
    public long getSum(long eleCount, long x) {
        return (eleCount*x) - (eleCount*(eleCount+1))/2;
    }

    
    public int maxValue(int n, int index, int maxSum) {
        
        if(n == 1) return maxSum;
        
        long left=1; long right=maxSum;
        long mid = left + (right-left)/2;
        long ans = -1;
        while(left <= right) {
            mid = left + (right-left)/2;
            
            long leftCount = Math.min((long)index,(mid-1));
            long leftSum = getSum(leftCount,mid);
            leftSum += Math.max((long)0,index-(mid-1));
            
            long rightCount = Math.min((long)(n-(index+1)),(mid-1));
            long rightSum = getSum(rightCount,mid);
            rightSum += Math.max((long)0,n-index-1-(mid-1));
            
            long totalSum = leftSum + mid + rightSum;
            if(totalSum <= (long) maxSum) {
                ans = Math.max(ans, mid);
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }
        return (int)ans;
    }
}