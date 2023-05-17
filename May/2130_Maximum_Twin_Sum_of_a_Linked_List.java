class Solution {
    
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        
        while(curr!=null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public int pairSum(ListNode head) {
       
        ListNode mid = findMiddle(head);
        
        ListNode r = mid.next;
        mid.next = null;
        
        ListNode l = head;
        r = reverse(r);
        
        int answer = Integer.MIN_VALUE;
        
        while(l!=null && r!=null){
            int temp = l.val + r.val;
            answer = Math.max(answer,temp);
            l = l.next;
            r = r.next;
        }
       return answer; 
    } 
}