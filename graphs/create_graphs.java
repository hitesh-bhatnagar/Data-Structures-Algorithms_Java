import java.util.*;
// Undirected and Unweighted graph

public class create_graphs{

    public static void BFS(int vertex, ArrayList<ArrayList<Integer>> adjacent, int node){
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();

        visited[node] = true;
        queue.offer(node);

        while(!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current + " ");

            for(int neighbour : adjacent.get(current)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
            System.out.println();
        }
    }

    public static void DFS(int node, ArrayList<ArrayList<Integer>> adjacent, boolean[] visited){
        visited[node] = true;
        System.out.print(node + " ");

        for(int neighbour : adjacent.get(node)){
            if(!visited[neighbour]) DFS(neighbour, adjacent, visited);
        }
    }

    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices ");
        int vertex = sc.nextInt();
    
        System.out.print("Enter number of edges ");
        int edges = sc.nextInt();
    
        ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>();
    
        for(int i = 0; i< vertex; i++){
            adjacent.add(new ArrayList<>());
        }

        System.out.println("Enter "+ edges + " edges (u v): ");
        for(int i = 0; i< edges; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjacent.get(u).add(v);
            adjacent.get(v).add(u);
        }
        
        System.out.println("Graph adjacency List: ");
        for(int i = 0; i< vertex; i++){
            System.out.print(i + " -> ");
            for(int j : adjacent.get(i)) System.out.print(j + " ");
            System.out.println();
        }

        System.out.print("BSF traversal from node 0 : ");
        BFS(vertex, adjacent, 0);

        System.out.print("DFS traversal from node 0: ");
        boolean[] visited = new boolean[vertex];
        DFS(0, adjacent, visited);
        System.out.println();
    }
}