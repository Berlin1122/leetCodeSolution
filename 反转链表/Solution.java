class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        reverse(null, head);
        return this.head;
    }

    private ListNode head;

    /**
     * 功能是将给定的next节点指向pre节点
     *
     * @param pre 前一个节点
     * @param next 前一个节点的下一个节点
     */
    private void reverse(ListNode pre, ListNode next) {
        if (next == null) {
            head = pre;
            return;
        }
        reverse(next, next.next);
        next.next = pre;
    }
}