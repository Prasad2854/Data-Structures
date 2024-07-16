package DoublyLinkedList;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    int length = 0;
    class Node{
        private Node next;
        private Node prev;
        int value;
        Node(int value){
            this.value = value;
        }
    }
    DoublyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value +" ");
            temp = temp.next;
        }

    }

    void append(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            newNode.prev = tail;
//            tail = tail.next;
            tail = newNode;
        }
        length++;

    }
    void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }
        else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }
    public Node removeLast(){
        Node temp = tail;
        if (length == 0)
        {
            head = null;
            tail = null;
        }
        else{
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }
        length --;
        return temp;
    }

    Node removeFirst(){
        Node temp   = head;
        if(length == 0){
            head = null;
            tail = null;
        }
        else{
            head = head.next;
            head.prev = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    //Get method checks for the efficient way, from were we can get most efficient way either from left or right
    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        if(index == length/2){

            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
        }

        else {
             temp = tail;
            for(int i = length - 1; i > index; i--){
                temp = temp.prev;
            }
        }
        return temp;
    }


    public boolean set(int index, int value){
        Node temp = get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        Node newNode = new Node(value);

        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node pre = get(index - 1);
        Node temp = pre.next;
        pre.next = newNode;
        newNode.next = temp;
        newNode.prev = pre;
        temp.prev = newNode;
        length++;
        return true;

    }

    public Node remove(int index){
        if(index == 0){
           return removeFirst();
        }
        if(index == length){
           return removeLast();
        }
       Node temp = get(index);
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.next = null;
        temp.prev = null;
        length--;
        return temp;

    }
    public static void main(String[] args) {
        DoublyLinkedList d = new DoublyLinkedList(4);
        d.append(5);
        d.prepend(3);
//        d.removeLast();
//        d.removeFirst();
        d.printList();
        System.out.println("Get method "+d.get(1).value+" ");
        d.set(1, 0);
        d.printList();
        System.out.println("Insertion : ");
        d.insert(1, 10);
        d.printList();
        System.out.println("Remove : ");
        d.remove(0);
        d.printList();

    }
}
