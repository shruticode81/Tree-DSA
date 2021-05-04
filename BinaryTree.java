public class Node<T>{
    T data;
    Node<T> left , right;
    public Node(T data){
        this.data = data;
        left = right = null;
    }
}
public class BinaryTree {
    Node<T> root;
    BinaryTree(T data){
        root = new Node<>(data);
    }
    BinaryTree(){
        root = null;
    }
    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();
        tree.root=new Node<T>(10);
    }
}
