
public class LeetCode2130 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {

        // To get twin easily, I first use slow and fast pointers for getting middle node
        // I reverse the node list until middle node
        // Now, I have two node list and traverse each simultaneously and sum it and compare max
        ListNode head = new ListNode(5, new ListNode(4));

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = slow.next;

        ListNode prev = null;
        ListNode curr = head;
        while (curr != second) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        int maxSum = 0;
        ListNode first = prev;
        while (first != null) {
            maxSum = Math.max(maxSum, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        System.out.println(maxSum);
    }
}


