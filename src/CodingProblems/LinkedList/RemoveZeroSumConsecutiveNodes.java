package LinkedList;

import java.util.HashMap;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodes {
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
    // Copy the prefixSum into Map which will update for the repeated sum

    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode current = new ListNode(0);
        current.next = head;
        int prefixSum = 0;
        map.put(0, current);
        for (ListNode node = current; node != null; node = node.next) {
            prefixSum += node.val;
            map.put(prefixSum, node);
        }
        prefixSum = 0;
        for (ListNode node = current; node != null; node = node.next) {
            prefixSum += node.val;
            node.next = map.get(prefixSum).next;
        }
        return current.next;
    }
}
