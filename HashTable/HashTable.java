package HashTable;

import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {
    Node[] datamap;
    int size = 7;
    class Node{
        String key;
        int value;
        Node next;

        Node( String key ,int value){
            this.value = value;
            this.key = key;
        }
    }
    public HashTable(){
        datamap = new  Node[size];
    }
    public void printHashTable(){
        for(int i = 0; i < datamap.length; i++){
            System.out.println(i+" ");
            Node temp = datamap[i];
            while (temp!= null){
                System.out.println("{ "+ temp.key+" " +"="+" "+temp.value+" }");
                temp = temp.next;
            }
        }
    }

    private int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();
        for(int i = 0; i < keyChars.length; i++){
            int asciiValue = keyChars[i];
            hash = (hash + asciiValue * 23) % datamap.length;
        }
        return hash;
    }

    public void setNode(String key, int value){
        int index = hash(key);
        Node newNode = new Node(key, value);
        if(datamap[index] == null){
            datamap[index] = newNode;
        }
        else{
            Node temp = datamap[index];
            while (temp.next!= null){
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public int getValue(String key){
        int index = hash(key);
        Node temp = datamap[index];
        while (temp!= null){
            if(temp.key == key){
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys(){
        ArrayList<String> allKeys = new ArrayList<>();
        for (int i = 0; i < datamap.length; i++){
            Node temp = datamap[i];
            while (temp != null){
                allKeys.add(temp.key);
                temp = temp.next;

            }

        }
        return allKeys;
    }
    public static void main(String[] args) {
        HashTable h = new HashTable();
        h.setNode("prasad", 13);
        h.setNode("Sumit", 11);
        h.printHashTable();
        System.out.println(h.getValue("Sumit")+" ");
        System.out.println(h.keys());
    }
}
