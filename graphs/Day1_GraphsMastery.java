// ✅ DAY 1: Graphs Mastery for Coding Rounds
// Topic: Graphs (DFS, BFS, Cycle Detection, Topo Sort)
// Supports both Directed and Undirected graphs (Unweighted)

import java.util.*;

class Graph{
    int vertex;
    ArrayList<ArrayList<Integer>> adj;
    boolean directed;                    // true = directed , false = undirected;

    Graph(int vertex, boolean directed){
        this.vertex = vertex;
        this.directed = directed;
        adj = new ArrayList<>();
        for(int i = 0; i < vertex; i++) adj.add(new ArrayList<>());
    }

    void addEdge(int u, int v){
        adj.get(u).add(v);
        if(!directed) adj.get(v).add(u);
    }

    void BFS(int start) {
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int node = queue.poll();
            System.out.print(node + " ");
            for(int i : adj.get(node)){
                if(!visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    void DFS(int start, boolean[] visited){
        visited[start] = true;
        System.out.print(start + " ");
        for(int i : adj.get(start)){
            if(!visited[i]){
                DFS(i, visited);
            }
        }
    }

    // detect cycle in undirected graph (DFS with parent tracking)
    boolean hasCycleUndirected(int node, boolean[] visited, int parent){
        visited[node] = true;
        for(int i : adj.get(node)){
            if(!visited[i]){
                if(hasCycleUndirected(i, visited, node)) return true;
            }
            else if( i != parent) return true;
        }
        return false;
    }

    // detect cycle in directed graph using DFS and recursion stack
    boolean hasCycleDirected(int node, boolean[] visited, boolean[] arr){
        visited[node] = true;
        arr[node] = true;
        for(int i : adj.get(node)){
            if(!visited[i]){
                if(hasCycleDirected(i, visited, arr)) return true;
            }
            else if(arr[i]) return true;
        }
        arr[node] = false;
        return false;
    }

    // Entry method to detect cycle based on graph type

    boolean detectCycle(){
        boolean[] visited = new boolean[vertex];
        if(directed){
            boolean[] arr = new boolean[vertex];
            for(int i = 0; i < vertex; i++){
                if(!visited[i]){
                    if(hasCycleDirected(i, visited, arr)) return true;
                }
            }
        }
        else{
            for(int i = 0; i< vertex; i++){
                if(!visited[i]){
                    if(hasCycleUndirected(i, visited, -1)) return true;
                }
            }
        }
        return false;
    }

    // Topological sort using Kahn's Algorithm (BFS) for DAGs
    void topoSortKahn(){
        int[] coming_arrows = new int[vertex];  
        for(int fromNode = 0; fromNode< vertex; fromNode++){
            for(int toNode : adj.get(fromNode)){
                coming_arrows[toNode]++;
            }
        }

        Queue<Integer> nodes_with_no_incoming = new LinkedList<>();
        for(int node = 0; node < vertex; node++){
            if(coming_arrows[node] == 0) nodes_with_no_incoming.add(node);
        }

        List<Integer> sortedOrder = new ArrayList<>();
        while(!nodes_with_no_incoming.isEmpty()){
            int current = nodes_with_no_incoming.poll();
            sortedOrder.add(current);

            for(int i :adj.get(current)){
                coming_arrows[i]--;         // remove the arrow
                if(coming_arrows[i] == 0) nodes_with_no_incoming.add(i);    // ready to process
            }
        }

        if(sortedOrder.size() == vertex){
            System.out.print("Topological sort ");
            for(int i : sortedOrder) System.out.print(i +" ");
        }
        else System.out.println("There is a cycle! no valid topo sort.");
    }

}

public class Day1_GraphsMastery{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vertex = sc.nextInt();
        int edges = sc.nextInt();

        System.out.print("I the graph directed ? (true/false) ");
        boolean isDirected = sc.nextBoolean();

        Graph g = new Graph(vertex, isDirected);
        System.out.println("Enter edges (u v) ");
        for(int i  = 0; i< edges; i++){
            int u = sc.nextInt(), v = sc.nextInt();
            g.addEdge(u, v);
        }

        System.out.print("BFS from node 0: ");
        g.BFS(0);
        System.out.println();

        System.out.print("DFS from node 0: ");
        boolean[] visited = new boolean[vertex];
        g.DFS(0, visited);
        System.out.println();

        System.out.println("Cycle exists: " + g.detectCycle());

        if(isDirected) g.topoSortKahn();
    }
}