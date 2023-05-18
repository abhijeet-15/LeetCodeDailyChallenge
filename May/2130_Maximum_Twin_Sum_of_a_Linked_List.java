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

// Using ArrayList
class Solution {
    
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();
        
        ListNode temp = head;
        while(temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        
        int res = 0;
        
        int i=0; 
        int j=list.size()-1;
        
        while(i < j) {
            res = Math.max(res, (list.get(i) + list.get(j)));
            i++;
            j--;
        }
        
        return res;
    }
}

//Stack based
class Solution {
    
    public int pairSum(ListNode head) {
       Stack<Integer> st = new Stack<>();
        
        ListNode temp = head;
        while(temp != null) {
            st.push(temp.val);
            temp = temp.next;
        }
        
        int N = st.size();
        temp = head;
        int i=0;
        int result = 0;
        
        while(i <= N/2) {
            result = Math.max(result, st.pop()+temp.val);
            temp = temp.next;
            i++;
        }
        
        return result;
    }
}