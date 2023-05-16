class Solution {
    
    private ListNode solve(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode temp = head.next;
        head.next = solve(head.next.next);
        temp.next = head;
        
        return temp;
        
    }
    
    public ListNode swapPairs(ListNode head) {
        return solve(head);
    }
}