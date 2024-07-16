package StacksAndQueues;
public class Queue{
    Node first;
    Node last;
    int length;
    class Node {
        int value;
        Node next;
        Node(int value){
            this.value = value;
        }

    }
    Queue(int value){
        Node newNode = new Node(value);
        newNode = first;
        newNode = last;
        length = 1;
    }

    public void printQueue(){
        Node temp = first;
        if(temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void enqueue(int value){
        Node newNode = new Node(value);

        if(length == 0){
            first = newNode;
            last =  newNode;
        }
        else {
            last.next = newNode;
            last = newNode;
        }
        length ++;
    }

    public Node dequeue(){
        Node temp = first;
        if(length == 1){
            first = null;
            last = null;
        }
        else {
            first = first.next;
            temp.next = null;
        }
        length --;
        return temp;
    }
    public static void main(String[] args) {
        Queue q = new Queue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.printQueue();


    }
}
