// some common functions and concepts related to Trees
import java.util.*;

class Treenode{
    int val;
    Treenode left ; Treenode right;
    public Treenode(int val){
        this.val = val;
        this.left = this.right = null;
    }

}

// PreOrder

void preorder(Treenode root){
    if(root == null) return;
    System.out.println(root.val +" ");
    preorder(root.left);
    preorder(root.right);    
}

// Postorder
void postorder(Treenode root){
    if(root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.println(root.val+" ");
}

// BFS

void BFS(Treenode root){
    if(root == null) return;
    Queue<Treenode> queue = new LinkedList<>();
    queue.add(root);

    while(!queue.isEmpty()){
        Treenode current = queue.poll();
        System.out.println(current.val+" ");
        if(current.left != null) queue.add(current.left);
        if(current.right != null) queue.add(current.right);
    }
}

// Find height of the Tree
int height(Treenode root){
    if(root == null) return 0;
    return 1+ Math.max(height(root.left), height(root.right));
}

// Lowest Common Ancestor (LCA)
Treenode LCA(Treenode root, Treenode p, Treenode q){
    if(root == null || root == p || root == q) return root;
    Treenode left = LCA(root.left,p,q);
    Treenode right = LCA(root.right,p,q);
    return left != null && right != null ? root : (left != null ? left : right);
}

// Diameter of Binary Tree (Longest Path)

int diameter(Treenode root){
    int[] diameter = new int[1];
    depth(root, diameter);
    return diameter[0];
}

int depth(Treenode root, int[] diameter){
    if(root == null) return 0;
    int left = depth(root.left, diameter);
    int right = depth(root.right, diameter);
    diameter[0] = Math.max(diameter[0], left+right);
    return 1+ Math.max(left,right);
}

// Validate a Binary Search Tree

boolean isvalid(Treenode root){
    return validate(root,Long.MIN_VALUE,long.MAX_VALUE);
}

boolean validate(Treenode root, long min, long max){
    if(root == null) return true;
    if(root.val )
}