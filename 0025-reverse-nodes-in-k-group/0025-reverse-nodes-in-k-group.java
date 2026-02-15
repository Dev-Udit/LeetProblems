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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null)return head;

        //check if k nodes are exists or not
        ListNode curr = head;
        for(int i=0;i<k;i++){
            if(curr == null)return head;
            curr = curr.next;
        }

        //reverse first k group
        int cnt = 0;
        curr = head;
        ListNode prev = null;
        while(cnt < k){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            cnt++;
        }

        //after reverse our head becomes tail so just
        head.next = reverseKGroup(curr, k);
        return prev;
    }
}