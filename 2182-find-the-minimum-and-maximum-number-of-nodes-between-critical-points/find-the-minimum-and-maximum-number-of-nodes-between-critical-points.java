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
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        int idx = 1;
        int firstIdx = -1;
        int lastIdx = -1;
        int minDist = Integer.MAX_VALUE;

        ListNode a = head;
        ListNode b = a.next;
        ListNode c = b.next;

        while (c != null) {

            if ((b.val > a.val && b.val > c.val) ||
                (b.val < a.val && b.val < c.val)) {

                if (firstIdx == -1) {
                    firstIdx = idx;
                }

                if (lastIdx != -1) {
                    int dist = idx - lastIdx;
                    minDist = Math.min(minDist, dist);
                }

                lastIdx = idx;
            }

            idx++;
            a = a.next;
            b = b.next;
            c = c.next;
        }

        if (firstIdx != -1 && firstIdx != lastIdx) {
            ans[0] = minDist;
            ans[1] = lastIdx - firstIdx;
        }

        return ans;
    }
}