import java.util.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
    }
}


 class BST {
    TreeNode root;

    BST(){
        Scanner sc = new Scanner(System.in);
        root = new TreeNode(sc.nextInt());
        while(true){
            int data = sc.nextInt();
            if(data!=-1)
                insertIntoBST(data);
            else break;
        }
    }

    public void insertIntoBST(int data) {
        TreeNode cur = root;
        while(true) {
            if(cur.data <= data) {
                if(cur.right != null) cur = cur.right;
                else {
                    cur.right = new TreeNode(data);
                    break;
                }
            } else {
                if(cur.left != null) cur = cur.left;
                else {
                    cur.left = new TreeNode(data);
                    break;
                }
            }
        }
    }

    public void inOrder(TreeNode root){
        if(root==null) return;

        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
}



public class FindSmallerCount {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        // bst.inOrder(bst.root);

        int key = sc.nextInt();
        int count = countSmallerElementBST(bst.root, 5);
        System.out.println();
        System.out.println(count);

    }

    static int countSmallerElementBST(TreeNode root, int key)
    {
        int count = 0;

        if (root == null) {
            return 0;
        }
        else if (root.data < key) {
            count++;
            count += countSmallerElementBST(root.left, key);
            count += countSmallerElementBST(root.right, key);
        }
        else {
            count += countSmallerElementBST(root.left, key);
        }

        return count;
    }
}