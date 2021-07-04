import java.util.Scanner;
public class TreeTraversal {
    //preOrder(Root,left,right)
    public static void preOrder(BinaryTreeNode<Integer> root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
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
    public static BinaryTreeNode<Integer> takeInput(boolean isRoot,int parentData,boolean isLeft){
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
        BinaryTreeNode<Integer> leftTree = takeInput(false,rootData,true);
        BinaryTreeNode<Integer> rightTree = takeInput(false,rootData,false);
        root.left = leftTree;
        root.right = rightTree;
        return root;

    
    }
    public static void main(String[] args){
        BinaryTreeNode<Integer> root = takeInput(true, 0, false);
        preOrder(root);
    }
}
