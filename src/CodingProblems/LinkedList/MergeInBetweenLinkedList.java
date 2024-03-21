package LinkedList;

public class MergeInBetweenLinkedList {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode slow = list1;
        ListNode fast = list1;
        for (int i =0; i <= b-a; i++){
            fast = fast.next;
        }
        for (int i= 0; i < a -1; i++){
            slow = slow.next;
            if (fast != null){
                fast = fast.next;
            }
        }
        while (list2 != null){
            slow.next = list2;
            list2 = list2.next;
            slow = slow.next;
        }
        slow.next = fast.next;
        return list1;
    }
}
