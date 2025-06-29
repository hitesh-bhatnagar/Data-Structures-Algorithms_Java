// ✅ DAY 1: Graphs Mastery for Coding Rounds
// Topic: Graphs (DFS, BFS, Cycle Detection, Topo Sort, Path, Components)
// Supports both Directed and Undirected graphs (Unweighted)
// Use this as your universal graph codebase for interview prep

import java.util.*;

// Graph class (supports both Directed and Undirected)
class Graph {
    int V; // number of vertices
    ArrayList<ArrayList<Integer>> adj;
    boolean directed; // true = directed, false = undirected

    // Constructor
    Graph(int V, boolean directed) {
        this.V = V;
        this.directed = directed;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
    }

    // Add edge (handles directed/undirected)
    void addEdge(int u, int v) {
        adj.get(u).add(v);
        if (!directed) adj.get(v).add(u);
    }

    // Breadth-First Search from a source node
    void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            System.out.print(node + " ");
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
    }

    // Depth-First Search from a source node
    void dfs(int start, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int neighbor : adj.get(start)) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited);
            }
        }
    }

    // Count connected components in the graph
    int countComponents() {
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                count++;
            }
        }
        return count;
    }

    // Check if path exists from u to v using BFS
    boolean isPathExists(int src, int dest) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);
        visited[src] = true;
        while (!q.isEmpty()) {
            int node = q.poll();
            if (node == dest) return true;
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                }
            }
        }
        return false;
    }

    // Detect cycle in undirected graph (DFS with parent tracking)
    boolean hasCycleUndirected(int node, boolean[] visited, int parent) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycleUndirected(neighbor, visited, node)) return true;
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }

    // Detect cycle in directed graph using DFS and recursion stack
    boolean hasCycleDirected(int node, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycleDirected(neighbor, visited, recStack)) return true;
            } else if (recStack[neighbor]) {
                return true;
            }
        }
        recStack[node] = false;
        return false;
    }

    // Entry method to detect cycle based on graph type
    boolean detectCycle() {
        boolean[] visited = new boolean[V];
        if (directed) {
            boolean[] recStack = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    if (hasCycleDirected(i, visited, recStack)) return true;
                }
            }
        } else {
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    if (hasCycleUndirected(i, visited, -1)) return true;
                }
            }
        }
        return false;
    }

    // Topological sort using Kahn's Algorithm (BFS) for DAGs
    void topoSortKahn() {
        int[] arrowsComingIn = new int[V];  // How many arrows come into each node
    
        // Step 1: Count incoming arrows for each node
        for (int fromNode = 0; fromNode < V; fromNode++) {
            for (int toNode : adj.get(fromNode)) {
                arrowsComingIn[toNode]++;
            }
        }
    
        // Step 2: Add all nodes with 0 incoming arrows to the queue
        Queue<Integer> nodesWithNoIncoming = new LinkedList<>();
        for (int node = 0; node < V; node++) {
            if (arrowsComingIn[node] == 0) {
                nodesWithNoIncoming.add(node);
            }
        }
    
        // Step 3: Build the final sorted order
        List<Integer> sortedOrder = new ArrayList<>();
        while (!nodesWithNoIncoming.isEmpty()) {
            int currentNode = nodesWithNoIncoming.poll();
            sortedOrder.add(currentNode);
    
            // Look at nodes that currentNode points to
            for (int neighbor : adj.get(currentNode)) {
                arrowsComingIn[neighbor]--; // Remove the arrow
                if (arrowsComingIn[neighbor] == 0) {
                    nodesWithNoIncoming.add(neighbor); // Ready to process
                }
            }
        }
    
        // Step 4: Check if we included all nodes
        if (sortedOrder.size() == V) {
            System.out.print("Topological Order: ");
            for (int node : sortedOrder) {
                System.out.print(node + " ");
            }
            System.out.println();
        } else {
            System.out.println("There is a cycle! No valid topological sort.");
        }
    }
    
    
}

// ---------------- Main Class ----------------
public class Day1_GraphsMastery {

    // Leetcode 207 — Course Schedule (using topological sort)
    static boolean canFinishCourses(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());

        for (int[] pre : prerequisites) {
            int u = pre[1];
            int v = pre[0];
            adj.get(u).add(v);
        }

        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adj.get(i)) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) q.offer(i);
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) q.offer(neighbor);
            }
        }

        return count == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nRun Course Schedule Test (Leetcode 207)? true/false: ");
        boolean runCourseTest = sc.nextBoolean();
        if (runCourseTest) {
            System.out.print("Enter number of courses: ");
            int n = sc.nextInt();
            System.out.print("Enter number of prerequisites: ");
            int m = sc.nextInt();
            int[][] prerequisites = new int[m][2];
            System.out.println("Enter prerequisites (a b):");
            for (int i = 0; i < m; i++) {
                prerequisites[i][0] = sc.nextInt();
                prerequisites[i][1] = sc.nextInt();
            }
            boolean canFinish = canFinishCourses(n, prerequisites);
            System.out.println("Can finish all courses: " + canFinish);
            return;
        }

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();
        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        System.out.print("Is the graph directed? (true/false): ");
        boolean isDirected = sc.nextBoolean();

        Graph g = new Graph(V, isDirected);
        System.out.println("Enter edges (u v):");
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        System.out.print("BFS from node 0: ");
        g.bfs(0);
        System.out.println();

        System.out.print("DFS from node 0: ");
        boolean[] visited = new boolean[V];
        g.dfs(0, visited);
        System.out.println();

        int components = g.countComponents();
        System.out.println("Connected Components: " + components);

        System.out.print("Check path from node u to v. Enter u and v: ");
        int u = sc.nextInt(), v = sc.nextInt();
        System.out.println("Path exists: " + g.isPathExists(u, v));

        System.out.println("Cycle exists: " + g.detectCycle());

        if (isDirected) {
            g.topoSortKahn();
        }
    }
}
