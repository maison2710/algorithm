package leetcode;

public class AddTwoNumbers {
    /**
     * Definition for singly-linked list.
     */
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


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int buffer = 0;
        String total = "";

        while (l1 != null && l2 != null) {
            int tmp = l1.val + l2.val + buffer;
            total = tmp % 10 + total;

            if (tmp >= 10) {
                buffer = 1;
            } else {
                buffer = 0;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int tmp = l1.val + buffer;
            total = tmp % 10 + total;

            if (tmp >= 10) {
                buffer = 1;
            } else {
                buffer = 0;
            }

            l1 = l1.next;
        }

        while (l2 != null) {
            int tmp = l2.val + buffer;
            total = tmp % 10 + total;

            if (tmp >= 10) {
                buffer = 1;
            } else {
                buffer = 0;
            }

            l2 = l2.next;
        }

        if (buffer == 1) {
            total = "1" + total;
        }

        System.out.println(total);

        ListNode res = new ListNode(total.charAt(0) - '0');
        for (int i = 1; i < total.length(); i++) {
            res = new ListNode(total.charAt(i) - '0', res);
        }

        return res;
    }
}
