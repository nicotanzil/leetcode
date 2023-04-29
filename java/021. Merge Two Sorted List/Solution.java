
public class Solution {

    // This solution is similar to the solution of java/023. Merge k Sorted
    // Lists/Solution.java.
    // Time: O(nlogk)
    // Space: O(1)

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1, p2 = list2;
        ListNode res = new ListNode();
        ListNode head = res;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                res.next = p1;
                p1 = p1.next;
            } else {
                res.next = p2;
                p2 = p2.next;
            }
            res = res.next;
        }

        if (p1 != null) {
            res.next = p1;
        }
        if (p2 != null) {
            res.next = p2;
        }

        return head.next;
    }
}
