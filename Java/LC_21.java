/* Problem: given two sorted linked lists, merge the two lists in order.
 *
 * Time Complexity: O(n + m) where n is the length of l1, and m is the length of
 * l2.
 *
 * Space Complexity: O(n + m) as we are creating a new linked list of the size
 * of n + m.
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode head;
        ListNode current;

        if (l1.val < l2.val) {
            current = l1;
            head = current;
            l1 = l1.next;
        } else {
            current = l2;
            head = current;
            l2 = l2.next;
        }

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                current.next = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                current.next = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        return head;
    }
}
