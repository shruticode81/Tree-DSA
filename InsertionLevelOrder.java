// Tree code to insert an element levelwise using queue ie iterative way
import java.util.Queue; //in java Queue collection is an interface
import java.util.LinkedList; //and linkedlist class implements interface queue
public class InsertionLevelOrder {
    static class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data = data;
            left=right=null;
        }
    }
    static Node root;
    static Node temp = root;
    static void inorder(Node temp){
        if(temp == null){
            return;
        }
        inorder(temp.left);
        System.out.print(temp.data+" ");
        inorder(temp.right);
    }

    static void insert(Node temp,int key){
        if(temp == null){
            root=new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(temp);
        while(!q.isEmpty()){
            temp = q.peek();
            q.remove();
            if(temp.left == null){
                temp.left = new Node(key);
                break;
            }else{
                q.add(temp.left);
            }
            if(temp.right == null){
                temp.right = new Node(key);
                break;
            }else{
                q.add(temp.right);
            }
        }
    }

    public static void main(String[] args){
        root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);
        System.out.println("Before Insertion print:");
        inorder(root);
        insert(root,12);
        System.out.println();
        System.out.println("After insertion of an element:");

        inorder(root);
    }
}
