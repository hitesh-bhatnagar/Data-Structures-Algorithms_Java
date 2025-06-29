import java.util.*;

class MatrixGraph{
    int vertex;
    int[][] matrix;
    boolean directed;

    MatrixGraph(int vertex, boolean directed){
        this.vertex = vertex;
        this.directed = directed;
        int[][] matrix = new int[vertex][vertex];
    }

    void addEdge(int u, int v){
        matrix[u][v] = 1;
        if(!directed) matrix[v][u] = 1;

    }

    void BFS(int start){
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.println(node +" ");
            for(int i = 0; i<vertex; i++){
                if(matrix[node][i] == 1 && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    void DFS(int node, boolean[] visited){
        visited[node] = true;
        System.out.println(node + " ");
        for(int i = 0; i < vertex; i++){
            if(matrix[node][i] == 1 && !visited[i]){
                DFS(i, visited);
            }
        }
    }
}

public class Adjacency_matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edges = sc.nextInt();
        boolean isDirected = sc.nextBoolean();
        MatrixGraph g = new MatrixGraph(vertex, isDirected);

        System.out.println("enter edges (u v)");
        for(int i = 0; i< edges; i++){
            int u = sc.nextInt(), v = sc.nextInt();
            g.addEdge(u, v);
        }

        System.out.print("BFS from node 0: ");
        g.BFS(0);
        System.out.println();

        System.out.print("DFS from node 0: ");
        boolean[] visited = new boolean[vertex];
        g.DFS(0, visited);
    }    
}

