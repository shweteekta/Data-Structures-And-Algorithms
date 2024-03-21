package LinkedList;

public class RemoveNthNodeFromENd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int count = countLength(head);
        if (count == 1 && n == 1){
            return null;
        }
        int node = count - n;
        if (node == 0) {
            return head.next;
        }
        for (int i = 0; i < node -1 ; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public int countLength(ListNode head){
        ListNode curr = head;
        int count = 0;
        while (curr != null){
            count ++;
            curr = curr.next;
        }
        return count;
    }

    //Optimised approach
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode start = new ListNode(0);
        start.next = head;
        ListNode slow = start;
        ListNode fast = start;
        for (int i = 1; i <= n; i++){
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return start.next;

    }
}
