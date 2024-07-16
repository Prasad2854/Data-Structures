package BST;

public class BinarySearchTree {
    Node root ;
    class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
        }
    }
public boolean insertNode(int value){
        Node newNode = new Node(value);
        if (root == null){
            root = newNode;
            return true;
        }
        Node temp = root;
        while (true){
            if(newNode.value == temp.value){
                return false;
            }
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }
            else {
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
}
public boolean containsNode(int value){
        if(root == null) return false;
        Node temp = root;
        while (temp != null){
            if(value < temp.value){
            temp = temp.left;
        } else if (value > temp.value) {
                temp = temp.right;
            }
            else {
                return true;
            }
        }
    return false;
}
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insertNode(2);
        b.insertNode(1);
        b.insertNode(5);
        b.insertNode(6);
        System.out.println(b.root.right.right.value +" ");
        System.out.println(b.containsNode(5));

    }
}
