package LinkedList;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = getMiddleNode(head);
        ListNode aMid = mid.next;
        mid.next = null;
        ListNode firstHalf = sortList(head);
        ListNode secondHalf = sortList(aMid);
        return merge(firstHalf, secondHalf);
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        ListNode prevSlowPtr = null;
        while (fastPtr != null && fastPtr.next != null) {
            prevSlowPtr = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return prevSlowPtr;
    }


    private ListNode merge(ListNode firstHalf, ListNode secondHalf) {
        ListNode curr = new ListNode(0);
        ListNode mergedNode = curr;
        while (firstHalf != null && secondHalf != null) {
            if (firstHalf.val < secondHalf.val) {
                curr.next = new ListNode(firstHalf.val);
                firstHalf = firstHalf.next;
            } else {
                curr.next = new ListNode(secondHalf.val);
                secondHalf = secondHalf.next;
            }
            curr = curr.next;
        }
        if (firstHalf != null) {
            curr.next = firstHalf;
        }
        if (secondHalf != null) {
            curr.next = secondHalf;
        }
        return mergedNode.next;
    }
}
