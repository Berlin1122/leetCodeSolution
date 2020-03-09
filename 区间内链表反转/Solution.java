class Solution {

    private ListNode left;
    private boolean finished = false;

    public ListNode reverseBetween(ListNode head, int m, int n) {
        left = head;
        reverse(head,m,n);
        return head;
    }

    private void reverse(ListNode p,int m,int n) {
        if(n == 1){
            return;
        }
        if(m > 1){
            this.left = this.left.next;
        }
        p = p.next;
        reverse(p,m-1,n-1);
        if(left == p || p.next == left){
            finished = true;
            return;
        }
        if(!finished){
            int v = left.val;
            left.val = p.val;
            p.val = v;
            left = left.next;
        }
    }

}