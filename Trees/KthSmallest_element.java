// Finding the Kth smallest element in a BST

class Treenode {
    int val;
    Treenode left, right;

    public Treenode(int x) {
        this.val = x;
        this.left = this.right = null;
    }
}

public class KthSmallest_element{
    Treenode root;
    public Treenode insert(Treenode root, int val){
        if(root == null ) return new Treenode(val);
        if(val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    void insert(int val) {root = insert(root,val); }
    int count = 0;
    int result = -1;
    void inorder(Treenode root, int k){
        
        if(root != null){
            inorder(root.left,k);
            count ++;
            if(count == k) {
                result = root.val;
                return;
            }
            inorder(root.right,k);
        }
    }
    
    public static void main(String args[]){
        int[] values = {5,33,6,2,4,1}; int k = 3;
        KthSmallest_element obj  = new KthSmallest_element();
        for(int i : values) obj.root = obj.insert(obj.root,i);
        obj.inorder(obj.root,k);
        System.out.println(obj.result);
    }
}