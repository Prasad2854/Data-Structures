package SinglyLinkedList;
class SinglyLinkedList{
    private Node head;
    private Node tail;
    int length = 0;
    class Node{
        private Node next;
        int value;
        Node(int value){
            this.value = value;
        }
    }
    SinglyLinkedList(int value){
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    void printLinkedList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.value);
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
            tail = newNode;
        }
        length++;
    }

    void prepend(int value){
        Node newNode = new Node(value);
        if(length == 0){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeLast(){
        if(length == 0){
            return null;
        }
        Node temp = head;
        Node pre = head;
        while(temp.next != null){
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length --;
        if(length == 0){
            head = null;
            tail = null;
        }
        return temp;
    }

    Node removeFirst(){
        if(length== 0){
            return null;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        length --;
        if(length == 0){
            tail = null;
        }
        return temp;
    }

    public Node get(int index){
        if(index < 0 || index >= length){
            return null;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        return temp;
    }

    public boolean set(int index, int value){
        Node temp = get(index);
        while (temp != null){
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value){
        if(index == 0){
            prepend(value);
            return true;
        }
        if(index == length){
            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index){
        if(index < 0 || index >= length) {
            return null;
        }
        if(index == 0){
           return removeFirst();
        }
        if(index == length -1 ){
            return removeLast();
        }
        Node prev = get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;
        length --;
        return temp;
    }

    public void reverse(){
        Node temp = head;
        head = tail;
        tail = temp;
        Node after = temp.next;
        Node before = null;
        for(int i = 0; i < length; i++){
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList s = new SinglyLinkedList(6);
        s.append(3);
        s.prepend(8);
        //        s.removeLast();
//        s.removeFirst();
        s.printLinkedList();
        System.out.println("the node is : "+s.get(2).value);
        System.out.println("the node is : "+s.set(2, 9));
        s.printLinkedList();
        System.out.println("the node is : "+s.insert(2,5 ));
        s.printLinkedList();
        System.out.println("the node is : "+s.remove(2).value);
        s.printLinkedList();
        System.out.println("REVERSE LINKED LIST");
        s.reverse();
        s.printLinkedList();
    }
}










