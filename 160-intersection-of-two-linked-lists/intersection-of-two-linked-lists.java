/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode h1, ListNode h2) {

        int l1 = 0;
        int l2 = 0;

        ListNode t1 = h1;
        ListNode t2 = h2;

        while (t1 != null) {
            l1++;
            t1 = t1.next;
        }

        while (t2 != null) {
            l2++;
            t2 = t2.next;
        }

        if (l1 > l2) {
            int diff = l1 - l2;

            while (diff-- > 0) {
                h1 = h1.next;
            }
        } else {
            int diff = l2 - l1;

            while (diff-- > 0) {
                h2 = h2.next;
            }
        }

        while (h1 != h2) {
            h1 = h1.next;
            h2 = h2.next;
        }

        return h1;
    }
}