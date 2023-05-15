// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/

class Solution {
    
    private int getLength(ListNode head) {
        int n = 0;
        while(head != null) {
            n++;
            head = head.next;
        }
        return n;
    }
    
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode temp = head;
        int n = getLength(temp);
        
        temp = head;
        ListNode left = head;
        ListNode right =  head;
        boolean first = false;
        boolean second = false;
        
        for(int i=1; i<n+1; i++) {
            
            if(i == k) {
                left = temp;
                first = true;
            }
            
            if(i == n-k+1) {
                right = temp;
                second = true;
            }
            
            if(first && second) {
                break;
            }
            
            temp = temp.next;
        }
        
        int t = left.val;
        left.val = right.val;
        right.val = t;
        
        return head;
        
    }
}

// approach 2 without calculating length
class Solution {
    
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = null;
        ListNode right = null;
        ListNode temp = head;
        
        while(temp != null) {
            
            if(right != null) {
                right = right.next;
            }
            
            k--;
            
            if(k == 0){
                left = temp;
                right = head; // activate
            }
            
            temp = temp.next;
        }
        
        int t = left.val;
        left.val = right.val;
        right.val = t;
        
        return head;
        
    }
}