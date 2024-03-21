package LinkedList;

//You are given the heads of two sorted linked lists list1 and list2.
//        Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//        Input: list1 = [1,2,4], list2 = [1,3,4]
//        Output: [1,1,2,3,4,4]
public class MergeTwoSortedLists {
     static class ListNode {
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
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode(-1);
        ListNode result = current;
        while(list1!=null && list2!=null) {
            if (list1.val < list2.val){
                current.next = list1;
                list1 = list1.next;
            }
            else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        if (list1 != null){
            current.next = list1;
        }
        if(list2 != null){
            current.next = list2;
        }
        return result.next;
    }
    static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.println(current.val);
            current = current.next;
        }
    }
    public static void main(String[] args){
         ListNode head1 = new ListNode(1);
         head1.next = new ListNode(2);
         head1.next.next = new ListNode(4);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        printList(head1);
        printList(head2);
        printList(mergeTwoLists(head1,head2));
    }
}
