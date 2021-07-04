import java.util.Scanner;

public class BinaryTreeUse {
    
    // Code for finding number of nodes
    public static int NumNode(BinaryTreeNode<Integer> root){
        if(root == null){
            return 0;
        }
        int leftNode = NumNode(root.left);
        int rightNode = NumNode(root.right);
        return 1+leftNode+rightNode;
    }
  
    public static BinaryTreeNode<Integer> takeInputBetter(boolean isRoot,int parentData,boolean isLeft){
        if(isRoot){
            System.out.println("Enter root data:");
        }else{
            if(isLeft){
                System.out.println("Enter left child data of "+parentData );
            }else{
                System.out.println("Enter right child data of "+ parentData);
            }
               
           
        }
        Scanner s = new Scanner(System.in);
      
        int rootData = s.nextInt();
        if(rootData==-1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
        BinaryTreeNode<Integer> leftTree = takeInputBetter(false,rootData,true);
        BinaryTreeNode<Integer> rightTree = takeInputBetter(false,rootData,false);
        root.left = leftTree;
        root.right = rightTree;
        return root;

    }

    // public static BinaryTreeNode<Integer> takeInput(){
    //     Scanner s = new Scanner(System.in);
    //     System.out.println("Enter root data:");
    //     int rootData = s.nextInt();
    //     if(rootData==-1){
    //         return null;
    //     }
    //     BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
    //     BinaryTreeNode<Integer> leftTree = takeInput();
    //     BinaryTreeNode<Integer> rightTree = takeInput();
    //     root.left = leftTree;
    //     root.right = rightTree;
    //     return root;

    // }
    public static void printTree(BinaryTreeNode<Integer> root){
        //print tree structure root,leftsubtree,right subtree
        if(root==null){
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }
    public static void printTreeDetailed(BinaryTreeNode<Integer> root){
        //base case
        if(root == null){
            return;
        }
        String tobeprinted = root.data+": ";
        if(root.left!=null){
            tobeprinted+="L"+root.left.data+",";
        }
        if(root.right!=null){
            tobeprinted+="R"+root.right.data;      
        }
        System.out.println(tobeprinted);
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }
    public static void main(String[] args){
        //build tree structure
        // BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        // BinaryTreeNode<Integer> left1 = new BinaryTreeNode<>(2);
        // BinaryTreeNode<Integer> right1 = new BinaryTreeNode<>(3);
        // root.left = left1;
        // root.right = right1;
        // BinaryTreeNode<Integer> right2= new BinaryTreeNode<>(4);
        // BinaryTreeNode<Integer> left2 = new BinaryTreeNode<>(5);
        // left1.right = right2;
        // right1.left = left2;
        // printTree(root);
        BinaryTreeNode<Integer> root =  takeInputBetter(true,0,false);
        printTreeDetailed(root);
        System.out.println("No. of node in tree with root "+root.data+" "+NumNode(root));
    }
}
