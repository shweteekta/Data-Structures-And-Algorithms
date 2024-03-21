package Stacks;

public class Stack<T> {
    static int top = -1;
    static int size = 4;
    static Object stack[] = new Object[size];
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(10);
        stack.push(15);
        stack.push(20);
        stack.pop();
        stack.peek();


    }

    public void push(T element){
        if(top == size-1){
            System.out.println("Stacks.Stack is full");
        }
        else{
            stack[++top] = element;
        }
    }
    public T pop(){
        if(top==-1){
            System.out.println("Stacks.Stack is Empty");
        }
        else{
            System.out.println("Element popped"+stack[top]);
            top--;
        }
        return null;
    }
    public T peek(){
        System.out.println(stack[top]);
        return null;
    }
}
