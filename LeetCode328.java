
public class LeetCode328 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private static ListNode oddEvenList(ListNode head) {
        // I think I need two node and one node is one ahead of another node
        // I change the next node each of two nodes while each node jumps two nodes

        if (head == null || head.next == null) {
            return head;
        }

        ListNode secondHead = head.next;

        ListNode first = head;
        ListNode second = head.next;

        // 1 2 3 4 5
        // 1 3 5 2 4

        while (second != null && second.next != null) {
            ListNode firstNext = first.next.next;
            ListNode secondNext = second.next.next;

            first.next = first.next.next;
            second.next = second.next.next;

            first = firstNext;
            second = secondNext;
        }

        first.next = secondHead;

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));;
        head = oddEvenList(head);

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}


