import java.util.*;

// Number of connected Components  [ DFS ]

public class Connected_components{
    static void DFS(int node, ArrayList<ArrayList<Integer>> adjacent, boolean[] visited){
        visited[node] = true;
        for(int neighbour : adjacent.get(node)){
            if(!visited[neighbour]) DFS(neighbour, adjacent, visited);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter no. of vertices ");
        int vertex = sc.nextInt();
        System.out.print("Enter number of edges ");
        int edges = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>();
        for(int i = 0; i<vertex; i++) adjacent.add(new ArrayList<>());

        System.out.println("Enter edges (u v) ");
        for(int i = 0; i<edges; i++){
            int u = sc.nextInt(), v = sc.nextInt();
            adjacent.get(u).add(v);
            adjacent.get(v).add(u);
        }

        boolean[] visited = new boolean[vertex];
        int count = 0;
        
        for(int i = 0; i< vertex; i++){
            if(!visited[i]){
                count++;
                DFS(i, adjacent, visited);
            }
        }

        System.out.println("Number of connected components " + count);
    }
}