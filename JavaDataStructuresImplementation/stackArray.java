import java.io.*;
import java.util.*;



public class stackArray{

    private static int arr[];
    private static int top;
    private static int size;

    stack(int size){
        arr =new int[size];
        this.size=size;
        top=-1;
    }

    public static boolean isFull(){
        return top==size-1;
    }

    public static boolean isEmpty(){
        if(top==-1)return true;
        return false;
    }

    public static void push(int data){
        if(isFull()){
            System.out.println("Stack is Full");
            return;
        }
        arr[++top]=data;
    }

    public static int pop(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top--];
    }

    public static int peek(){
        if(isEmpty()){
            System.out.println("Stack is Empty");
            return -1;
        }
        return arr[top];
    }

    public static int getSize(){
        return top+1;
    }

    public static void main(String[] args) {
        stack s1=new stack(5);
        s1.push(5);
        s1.push(4);
        s1.push(3);
        s1.push(2);
        s1.push(1); 

        //s1.pop();

        System.out.println(isEmpty());

        for(int i=top; i>=0; i--){
            System.out.print(arr[i]+" ");
        }

    }
}
