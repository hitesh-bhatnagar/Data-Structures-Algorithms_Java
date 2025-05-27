
import java.util.*;

class Treenode{
    int val;
    Treenode left, right;
    public Treenode(int val){
        this.val = val;
        this.left = this.right = null;
    }
}

class BST{
    Treenode root;

    Treenode insert(Treenode root, int val){
        if(root == null) return new Treenode(val);
        if(val < root.val) root.left = insert(root.left , val);
        else root.right = insert(root.right, val);
        return root;
    }

    Set<Integer> set = new HashSet<>();
    void test(Treenode root, int low , int high){
        
        if(root == null) return; 
        else{
            if(root.left != null) test(root.left,low,high);
            if(root.right != null) test(root.right,low,high);
            if(root.val >= low && root.val <= high) set.add(root.val);
        }
    }
    
    void Calc(){
        int sum = 0;
        for(int i : set) sum += i;
        System.out.println(sum);
    }
}

public class Range_Sum {
    public static void main(String args[]){   
    int low = 5;
    int high = 15;
    BST bst = new BST();
    for(int i = low; i<= high; i++) bst.root = bst.insert(bst.root,i);
    bst.test(bst.root,low,high);
    bst.Calc();
    }
}
