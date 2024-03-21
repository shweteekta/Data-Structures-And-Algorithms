package Stacks;

import java.util.Stack;
public class QueueUsingStacks {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> revStack = new Stack<>();

    public QueueUsingStacks() {

    }

    public  void push(int x) {
        while(!stack.isEmpty()){
            revStack.push(stack.pop());
        }
        stack.push(x);
        while(!revStack.isEmpty()){
            stack.push(revStack.pop());
        }
    }

    public  int pop() {
        return stack.pop();
    }

    public  int peek() {
        return stack.peek();
    }

    public  boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args){
        QueueUsingStacks queue = new QueueUsingStacks();
    }
}
