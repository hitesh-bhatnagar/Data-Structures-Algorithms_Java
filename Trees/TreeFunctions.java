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
    return validate(root,Long.MIN_VALUE,Long.MAX_VALUE);
}

boolean validate(Treenode root, long min, long max){
    if(root == null) return true;
    if(root.val <= min || root.val >= max) return false;
    return validate(root.left, min, root.val) && validate(root.right, root.val, max);
}


// Serialise and deserialize a Binary Tree
// Convert a tree into a string (serialize) and reconstruct it back (deserialize)

String serialize(Treenode root){
    if(root == null) return "null";
    return root.val + "," +serialize(root.left) + serialize(root.right);
}

Treenode deserialize(String data){
    Queue<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
    return buildTree(nodes);
}

TreeNode buildTree(Queue<String> nodes){
    String val = nodes.poll();
    if(val.equals("null")) return null;
    TreeNode root = new TreeNode(Integer.parseInt(val));
    root.left = buildTree(nodes);
    root.right = buildTree(nodes);
    return root;
}

// Kth smallest element in a BST
// Concept : Inorder traversal of BST gives sorted order 
int count = 0, result = -1;
int k_smallest(Treenode root, int k){
    inOrder(root, k);
    return result;
}
void inOrder(Treenode root, int k){
    if(root == null) return;
    inOrder(root.left, k);
    count++;
    if(count == k){
        result = root.val;
        return;
    }
    inOrder(root.right,k);
}


// Recover a BST (swapped nodes)

Treenode first = null, second = null, prev = new Treenode(Integer.MIN_VALUE);

void recoverBST(Treenode root){
    findswapped(root);
    int temp = first.val;
    first.val = second.val;
    second.val = temp;
}

void findswapped(Treenode root){
    if(root == null) return;
    findswapped(root.left);
    if(first == null && prev.val >= root.val) first = prev;
    if(first != null && prev.val >= root.val) second = root;
    prev = root;
    findswapped(root.right); 
}


// Check if two Trees are identical

boolean isSameTree(Treenode p, Treenode q){
    if(p == null || q == null) return p == q;
    return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}

// ## Check if the tree is symmetric (Mirror Image)
boolean isSymmetric(Treenode root){
    return root == null || isMirror(root.left , root.right);
}

boolean isMirror(Treenode t1, Treenode t2){
    if(t1 == null || t2 == null) return t1 == t2;
    return (t1.val== t2.val) && isMirror(t1.left, t2.right) && isMirror(t2.right, t2.left);
}




