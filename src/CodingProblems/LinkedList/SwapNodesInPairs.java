package LinkedList;

public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode curr = new ListNode(0);
        curr.next = head;
        ListNode prev = curr;
        while (prev.next != null && prev.next.next != null){
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swap nodes
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move to the next pair
            prev = first;
        }
        return curr.next;
    }
    static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        printList(swapPairs(head1));
    }
}
