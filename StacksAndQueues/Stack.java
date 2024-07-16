package StacksAndQueues;

public class Stack {
    private Node top;
    private int height = 0;
    class Node{
        private int value;
        private Node next;
        Node(int value){
            this.value = value;
        }
    }
    Stack(int value){
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack(){
        Node temp = top;
        while (temp != null){
            System.out.println(temp.value +" ");
            temp = temp.next;
        }
    }
    public boolean push(int value){
        Node newNode = new Node(value);
        if(height == 0){
            top = newNode;
            return true;
        }
        else {
            newNode.next = top;
            top = newNode;
        }
        height++;
        return true;
    }
    public Node pop(){
        if (height == 0){
            return null;
        }
        Node temp = top;
        top= top.next;
        temp.next = null;
        height --;
        return temp;
    }
    public static void main(String[] args) {
        Stack s = new Stack(1);
//        s.printStack();
        s.push(2);
        s.pop();
        s.printStack();
    }
}
