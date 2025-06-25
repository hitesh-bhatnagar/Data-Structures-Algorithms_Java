import java.util.*;


class Treenode{
    int val;
    Treenode left, right;
    public Treenode(int val){
        this.val = val;
        this.left = this.right = null;      
    }
}

class Pair{
    Treenode node;
    int h_dist;
    Pair(Treenode node, int h_dist){
        this.node = node;
        this.h_dist = h_dist;  
    }
}

public class TreeViews{
    
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    static void topView(Treenode root){
        if(root == null) return;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(!map.containsKey(pair.h_dist)) map.put(pair.h_dist, pair.node.val);    // first only
            if(pair.node.left != null) queue.offer(new Pair(pair.node.left, pair.h_dist - 1));
            if(pair.node.right != null) queue.offer(new Pair(pair.node.right, pair.h_dist + 1));
        }

        System.out.print("Top View : ");
        for(int val : map.values()) System.out.print(val + " ");
        System.out.println();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    static void bottomView(Treenode root){
        if(root == null) return;
        Map<Integer,Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            map.put(pair.h_dist, pair.node.val);        // always overwrite
            if(pair.node.left != null) queue.offer(new Pair(pair.node.left, pair.h_dist - 1));
            if(pair.node.right != null) queue.offer(new Pair(pair.node.right , pair.h_dist + 1));

        }

        System.out.print("Bottom View : ");
        for(int val : map.values()) System.out.print(val + " ");
        System.out.println();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    static void verticalOrder(Treenode root){
        if(root == null) return;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            map.computeIfAbsent(pair.h_dist,x -> new ArrayList<>()).add(pair.node.val);
            if(pair.node.left != null) queue.offer(new Pair(pair.node.left, pair.h_dist - 1));
            if(pair.node.right != null) queue.offer(new Pair(pair.node.right, pair.h_dist + 1));
        }
        
        System.out.print("Vertical Order : ");
        for(List<Integer> list : map.values()){
            for(int val : list) System.out.print(val + " ");
        }
        System.out.println();
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    static void leftView(Treenode root){
        List<Integer> result = new ArrayList<>();
        dfs_LeftView(root, 0, result);
        System.out.print("Left View : ");
        for(int val : result) System.out.print(val + " ");
        System.out.println();
    }

    static void dfs_LeftView(Treenode node, int level, List<Integer> result){
        if(node == null) return;
        if(level == result.size()) result.add(node.val);
        dfs_LeftView(node.left, level + 1, result);
        dfs_LeftView(node.right, level + 1, result);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    
    static void rightView(Treenode root){
        List<Integer> result = new ArrayList<>();
        dfs_RightView(root, 0, result);
        System.out.print("Right View : ");
        for(int val : result) System.out.print(val + " ");
        System.out.println();
    }

    static void dfs_RightView(Treenode node, int level, List<Integer> result){
        if(node == null) return;
        if(level == result.size()) result.add(node.val);
        dfs_RightView(node.right, level+1, result);
        dfs_RightView(node.left, level + 1, result);
    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    // UTILITY : Build Tree from array (null = empty node)
    static Treenode buildTree(Integer[] arr){
        if(arr.length == 0 || arr[0] == null) return null;
        Treenode root = new Treenode(arr[0]);
        Queue<Treenode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;
        while(!queue.isEmpty() && i < arr.length){
            Treenode current = queue.poll();
            if(i < arr.length && arr[i] != null){
                current.left = new Treenode(arr[i]);
                queue.add(current.left);

            }
            i++;

        }
        return root;
        
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for(int i = 0;i<n;i++) arr[i] =  sc.nextInt();
        Treenode root = buildTree(arr);

        topView(root);
        bottomView(root);
        verticalOrder(root);
        leftView(root);
        rightView(root);

        sc.close();
    }
}