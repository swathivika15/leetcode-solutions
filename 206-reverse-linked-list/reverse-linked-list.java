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
    public ListNode reverseList(ListNode head) {
        ListNode pr=null,cu=head;
        while(cu!=null){
            ListNode temp=cu.next;
            cu.next=pr;
            pr=cu;
            cu=temp;
        }
        return pr;
    }
}