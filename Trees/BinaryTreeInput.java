// Taking input as Level Order (Array Style)
// -1 represents no child

import java.util.*;

class Treenode{
    int val;
    Treenode left;
    Treenode right;
    public Treenode(int val){
        this.val = val;
        this.left = this.right = null;
    }
}

class BinaryTreeInput{
    Treenode buildTree(Integer[] values){
        if(values.length == 0|| values[0] == null) return null;

        Treenode root = new Treenode(values[0]);
        Queue<Treenode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;
        while( i < values.length){
            Treenode current = queue.poll();
            if(values[i] != null){
                current.left = new Treenode(values[i]);
                queue.add(current.left);
            }
            i++;
            if(i < values.length && values[i] != null ){
                current.right = new Treenode(values[i]);
                queue.add(current.right);
            }
            i++;
        }
        return root;
    }
    
    void inorder(Treenode root){
        if(root == null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number of nodes ");
        int n = sc.nextInt();
        Integer[] values = new Integer[n];

        System.out.println("Enter values (-1 for null nodes)");
        for(int i = 0;i<n;i++){
            int val = sc.nextInt();
            values[i] = (val == -1) ? null : val;
        }

        BinaryTreeInput tree = new BinaryTreeInput();
        Treenode root = tree.buildTree(values);
        System.out.println("Inorder traversal ");
        tree.inorder(root);
        sc.close();
    }
}