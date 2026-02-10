/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null)return null;
        int idx=1;
        ListNode temp = head;
        ListNode even = new ListNode(-1);
        ListNode e = even;
        ListNode odd = new ListNode(-1);
        ListNode o = odd;
        while(temp!=null){
            if(idx%2==0){
                even.next = temp;
                even = even.next;
            }
            else {
                odd.next = temp;
                odd = odd.next;
            }
            temp=temp.next;
            idx++;
        }
        even.next = null;
        odd.next = e.next;
        return o.next;
    }
}