import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) { this.val = val; }
}

class BST {
    TreeNode root;

    TreeNode insert(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (val < root.val) root.left = insert(root.left, val);
        else root.right = insert(root.right, val);
        return root;
    }

    void insert(int val) { root = insert(root, val); }

    boolean search(TreeNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        return search(val < root.val ? root.left : root.right, val);
    }

    boolean search(int val) { return search(root, val); }

    TreeNode delete(TreeNode root, int val) {
        if (root == null) return null;
        if (val < root.val) root.left = delete(root.left, val);
        else if (val > root.val) root.right = delete(root.right, val);
        else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            TreeNode min = root.right;
            while (min.left != null) min = min.left;
            root.val = min.val;
            root.right = delete(root.right, min.val);
        }
        return root;
    }

    void delete(int val) { root = delete(root, val); }

    void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.val + " ");
            inorder(root.right);
        }
    }

    void preorder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    void postorder(TreeNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }   
    }

    void levelOrder(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.print(curr.val + " ");
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
    }
}

public class TreeDSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        System.out.print("Enter num of nodes to insert: ");
        int n = sc.nextInt();
        System.out.print("Enter " + n + " integers: ");
        for (int i = 0; i < n; i++) bst.insert(sc.nextInt());
        System.out.print("\nInorder: "); bst.inorder(bst.root);
        System.out.print("\nPreorder: "); bst.preorder(bst.root);
        System.out.print("\nPostorder: "); bst.postorder(bst.root);
        System.out.print("\nLevelOrder: "); bst.levelOrder(bst.root);
        System.out.print("\nEnter value to search: ");
        int searchVal = sc.nextInt();
        System.out.println(searchVal + (bst.search(searchVal) ? " found" : " not found"));
        System.out.print("Enter value to delete: ");
        bst.delete(sc.nextInt());
        System.out.print("Inorder after delete: "); bst.inorder(bst.root);
        sc.close();
    }
}

