package Heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/
//        Input: lists = [[1,4,5],[1,3,4],[2,6]]
//        Output: [1,1,2,3,4,4,5,6]
//        Explanation: The linked-lists are:
//        [
//        1->4->5,
//        1->3->4,
//        2->6
//        ]
//        merging them into one sorted list:
//        1->1->2->3->4->4->5->6
public class MergeKSortedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode mergeKLists(ListNode[] lists) {
//        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
//            @Override
//            public int compare(ListNode o1,ListNode o2){
//                if (o1.val<o2.val)
//                    return -1;
//                else if (o1.val==o2.val)
//                    return 0;
//                else
//                    return 1;
//            }
//        });
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt((ListNode a) -> a.val));
        for (ListNode node: lists){
            if (node!=null){
                queue.offer(node);
            }
        }
        ListNode root = new ListNode(0);
        var current = root;
        while(!queue.isEmpty()){
            current.next = queue.poll();
            current = current.next;
            if (current.next != null){
                queue.offer(current.next);
            }
        }
        return root.next;
    }
    // Using Recursion
    public static ListNode mergeKLists2(ListNode[] lists){
        return partion(lists,0,lists.length-1);
    }

    public static ListNode partion(ListNode[] lists,int s,int e){
        if(s==e)  return lists[s];
        if(s<e){
            int q=(s+e)/2;
            ListNode l1=partion(lists,s,q);
            ListNode l2=partion(lists,q+1,e);
            return merge(l1,l2);
        }else
            return null;
    }

    //This function is from Merge Two Sorted Lists.
    public static ListNode merge(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1.next=merge(l1.next,l2);
            return l1;
        }else{
            l2.next=merge(l1,l2.next);
            return l2;
        }
    }
}
