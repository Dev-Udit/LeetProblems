class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        ListNode temp = head;
        int n = 1;                      // start from 1 (count head)

        while (temp.next != null) {
            temp = temp.next;
            n++;
        }

        // Make circular
        temp.next = head;

        k = k % n;
        int steps = n - k;              // right rotation logic

        temp = head;
        while (steps > 1) {
            temp = temp.next;
            steps--;
        }

        ListNode newHead = temp.next;
        temp.next = null;               // break the cycle

        return newHead;
    }
}
