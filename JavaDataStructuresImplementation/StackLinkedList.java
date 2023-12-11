class Stack {
    private class Node {
        private int data;
        private Node next;

        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;

    Stack() {
        this.top = null;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (top == null) {
            top = newNode;
            return;
        }
        newNode.next = top;
        top = newNode;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return;
        }
        top = top.next;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1; 
        }
        return top.data;
    }
}

public class StackLinkedList{
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(5);
        stack.push(7);
        stack.push(8);

        //stack.pop();

        while(!stack.isEmpty()){
        	System.out.println(stack.peek());
        	stack.pop();
        }

    }
}
