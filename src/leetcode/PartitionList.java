package leetcode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * <p>
 * Example:
 * <p>
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
 */
public class PartitionList {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if(head.next == null || k == 0){
            return head;
        }

        ListNode iterator = head;
        int length = 0;

        while (iterator != null) {
            length++;
            iterator = iterator.next;
        }

        int steps = k % length;
        int last = length - steps;

        if(steps == 0){
            return head;
        }

        ListNode current = head;

        for (int i = 1; i < last; i++) {
            current = current.next;
        }
        ListNode result = current.next;
        current.next = null;

        iterator = result;
        while(iterator.next != null){
            iterator = iterator.next;
        }
        iterator.next = head;

        return result;
    }
}
