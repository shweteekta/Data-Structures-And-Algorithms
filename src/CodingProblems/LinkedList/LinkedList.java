package LinkedList;

public class LinkedList {
     static class Node<T> {
        T data;
        Node next;
        Node(T data){
            this.data = data;
            this.next= null;
        }
    }

    Node head;
    LinkedList(){
        this.head = null;
    }

    static void printList(Node head){
        Node current = head;
        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    static void deleteNode(Node head, int position){
        Node current = head;
        if (position == 0) {
            head = current.next;
        } else {
            while (position-1 != 0 && current != null){
                current = current.next;
                position--;
            }
            System.out.println(current.data);
            Node newNode = current.next.next ;
            current.next = newNode;
        }
    }

    public static void main(String[] args){
        Node head = new Node(1);
        Node next1 = head.next = new Node(2);
        next1.next = new Node(3);
        next1.next.next = null;
        printList(head);
        deleteNode(head, 1);
        printList(head);
    }
}

