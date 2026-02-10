class Solution {
    public ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;

        // find middle
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        // split
        ListNode half = slow.next;
        slow.next = null;

        // reverse second half
        ListNode temp2 = reverse(half);
        ListNode temp1 = head;

        // merge
        while(temp1 != null && temp2 != null){
            ListNode n1 = temp1.next;
            ListNode n2 = temp2.next;

            temp1.next = temp2;
            temp2.next = n1;

            temp1 = n1;
            temp2 = n2;
        }
    }
}
