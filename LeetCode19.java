
public class LeetCode19 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode solve(ListNode head, int n) {
        // I will use fast and slow pointer strategy
        // fast pointer is <n> faster than slow pointer
        // when fast pointer reaches end, the slow pointer position is the being removed node position.

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }

        ListNode prev = null;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev == null) {
            if (n == 1) {
                return null;
            } else {
                return slow.next;
            }
        }
        
        prev.next = slow.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2));
        int n = 1;
        
        System.out.println(solve(head, n).val);
    }
}


