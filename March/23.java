// https://leetcode.com/problems/merge-k-sorted-lists/

class Solution {
    
    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
        
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        
        if(l1.val <= l2.val) {
            l1.next = mergeTwoSortedList(l1.next, l2);
            return l1;
        }
        
        else if(l1.val > l2.val) {
            l2.next = mergeTwoSortedList(l1,l2.next);
            return l2;
        }
        return null;
    }
    
    private ListNode paritionAndMerge(int s, int e, ListNode[] lists) {
        
        if(s > e) {
            return null;
        }
        
        if(s == e) {
            return lists[s];
        }
        
        int mid = s +(e-s)/2;
        
        ListNode L1 = paritionAndMerge(s,mid,lists);
        ListNode L2 = paritionAndMerge(mid+1,e,lists);
        
        return mergeTwoSortedList(L1,L2);
            
    }
    
    public ListNode mergeKLists(ListNode[] lists) {
        
        int k = lists.length;
        
        if(k == 0) {
            return null;
        }
        
        return paritionAndMerge(0,k-1,lists);
    }
}
