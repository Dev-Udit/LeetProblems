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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1==null && list2==null)return null;
        if(list1==null)return list2;
        if(list2==null)return list1;

        ListNode root = new ListNode(-1);
        ListNode temp = root;
        while(list1 != null && list2 != null){
            if(list1.val  <= list2.val){
                temp.next = list1;
                list1 = list1.next;
            }
            else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp =temp.next;
        }

        temp.next = list1 == null ? list2:list1;
        return root.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if(n==0)return null;
        ListNode list1 = lists[0];
        for(int i=1;i<n;i++){
            list1 = mergeTwoLists(list1 , lists[i]);
        }

        return list1;
        
    }
}