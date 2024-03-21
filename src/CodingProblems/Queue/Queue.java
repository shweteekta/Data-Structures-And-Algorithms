package Queue;

public class Queue {
    private int maxSize;
    private int[] queueArray;
    private int front;
    private int rear;
    private int nItems;
    public Queue(int s){
        maxSize = s;
        queueArray = new int[s];
        front = 0;
        rear = -1;
        nItems = 0;

    }
    public int peekFront(){
        return queueArray[front];
    }
    public int peekRear(){
        return queueArray[rear];
    }
    public boolean checkEmpty(){
        return nItems == 0;
    }
    public boolean checkFull(){
        return nItems == maxSize;
    }
    public void Enqueue(int item){
        if (checkFull()){
            System.out.println("Queue.Queue is Full");
        }
        else{
            queueArray[++rear] = item;
            nItems++;
        }
    }
    public void Dequeue(){
        if (checkEmpty()){
            System.out.println("Queue.Queue is Empty");
        }
        else{
            front++;
            nItems--;
        }

    }
    public static void main(String[] args) {
        Queue queue = new Queue(4);
        queue.Enqueue(2);
        System.out.println(queue.peekFront());
        queue.peekRear();
    }
}
