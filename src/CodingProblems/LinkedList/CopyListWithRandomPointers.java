package LinkedList;

import java.util.*;

public class CopyListWithRandomPointers {
    public ListNode copyRandomList(ListNode head) {
        if (head == null) return null;
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode current = head;
        while (current != null){
            map.put(current, new ListNode(current.val));
            current = current.next;
        }
        current = head;
        while (current != null){
            map.get(current).next = map.get(current.next);
            map.get(current).random = map.get(current.random);
            current = current.next;
        }
        return map.get(head);
    }
}
