import java.util.*;

public class Graphs_usingList {

    static class Pair {
        int node, dist;
        Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static class Edge {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static class Graph {
        int V;
        boolean directed, weighted;
        List<List<Integer>> adj;   // For unweighted graph
        List<List<Pair>> wadj;     // For weighted graph

        Graph(int V, boolean directed, boolean weighted) {
            this.V = V;
            this.directed = directed;
            this.weighted = weighted;
            adj = new ArrayList<>();
            wadj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
                wadj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            if (!directed) adj.get(v).add(u);
        }

        void addEdge(int u, int v, int w) {
            wadj.get(u).add(new Pair(v, w));
            if (!directed) wadj.get(v).add(new Pair(u, w));
        }
    }

    static Graph buildUnweightedGraph(int V, List<List<Integer>> edgeList, boolean directed) {
        Graph g = new Graph(V, directed, false);
        for (List<Integer> e : edgeList) {
            g.addEdge(e.get(0), e.get(1));
        }
        return g;
    }

    static Graph buildWeightedGraph(int V, List<Edge> edgeList, boolean directed) {
        Graph g = new Graph(V, directed, true);
        for (Edge e : edgeList) {
            g.addEdge(e.u, e.v, e.w);
        }
        return g;
    }

    static void BFS(List<List<Integer>> adj, int start, int V) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int curr = queue.poll();
            System.out.print(curr + " ");
            for (int i : adj.get(curr)) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }

    static void DFS(List<List<Integer>> adj, int u, boolean[] visited) {
        visited[u] = true;
        System.out.print(u + " ");
        for (int i : adj.get(u)) {
            if (!visited[i]) DFS(adj, i, visited);
        }
    }

    static void fullBFS(Graph g) {
        for (int i = 0; i < g.V; i++) BFS(g.adj, i, g.V);
    }

    static void fullDFS(Graph g) {
        boolean[] visited = new boolean[g.V];
        for (int i = 0; i < g.V; i++) {
            if (!visited[i]) {
                DFS(g.adj, i, visited);
                System.out.println();
            }
        }
    }

    static boolean hasCycleUndirected(List<List<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) if (!vis[i] && dfsCycleU(adj, i, vis, -1)) return true;
        return false;
    }

    static boolean dfsCycleU(List<List<Integer>> adj, int u, boolean[] vis, int parent) {
        vis[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v] && dfsCycleU(adj, v, vis, u)) return true;
            else if (v != parent) return true;
        }
        return false;
    }

    static boolean hasCycleDirected(List<List<Integer>> adj) {
        int n = adj.size();
        boolean[] vis = new boolean[n], stack = new boolean[n];
        for (int i = 0; i < n; i++) if (!vis[i] && dfsCycleD(adj, i, vis, stack)) return true;
        return false;
    }

    static boolean dfsCycleD(List<List<Integer>> adj, int u, boolean[] vis, boolean[] stack) {
        vis[u] = stack[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v] && dfsCycleD(adj, v, vis, stack)) return true;
            else if (stack[v]) return true;
        }
        stack[u] = false;
        return false;
    }

    static List<Integer> topoSort(List<List<Integer>> adj) {
        int V = adj.size();
        int[] indeg = new int[V];
        for (var l : adj) for (int v : l) indeg[v]++;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indeg[i] == 0) q.offer(i);
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (int v : adj.get(u)) if (--indeg[v] == 0) q.offer(v);
        }
        if (order.size() < V) System.out.println("Cycle detected; topological sort not possible.");
        else System.out.println("Topological Sort: " + order);
        return order;
    }

    static int[] parent;
    static List<Integer> reconstructPath(int src, int dest) {
        List<Integer> path = new ArrayList<>();
        if (parent[dest] == -1 && src != dest) return path;
        for (int at = dest; at != -1; at = parent[at]) path.add(at);
        Collections.reverse(path);
        return path;
    }

    static void dijkstra(Graph g, int start) {
        int V = g.V;
        parent = new int[V];
        Arrays.fill(parent, -1);
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.dist));
        pq.offer(new Pair(start, 0));

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            for (Pair next : g.wadj.get(cur.node)) {
                if (dist[next.node] > dist[cur.node] + next.dist) {
                    dist[next.node] = dist[cur.node] + next.dist;
                    parent[next.node] = cur.node;
                    pq.offer(new Pair(next.node, dist[next.node]));
                }
            }
        }

        System.out.println("Distances from node " + start + ": " + Arrays.toString(dist));
        System.out.println("Example path from " + start + " to V-1: " + reconstructPath(start, V - 1));
    }

    static void bellmanFord(int V, List<Edge> edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        for (int i = 1; i < V; i++) {
            for (var e : edges) {
                if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }
        for (var e : edges) {
            if (dist[e.u] != Integer.MAX_VALUE && dist[e.u] + e.w < dist[e.v]) {
                System.out.println("Negative cycle detected");
                return;
            }
        }
        System.out.println("Bellman-Ford distances from " + src + ": " + Arrays.toString(dist));
    }

    static void primMST(Graph g) {
        int V = g.V;
        boolean[] vis = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.dist));
        key[0] = 0;
        pq.offer(new Pair(0, 0));
        while (!pq.isEmpty()) {
            int u = pq.poll().node;
            if (vis[u]) continue;
            vis[u] = true;
            for (var p : g.wadj.get(u)) {
                if (!vis[p.node] && p.dist < key[p.node]) {
                    key[p.node] = p.dist;
                    pq.offer(new Pair(p.node, p.dist));
                }
            }
        }
        System.out.println("Prim's MST key array: " + Arrays.toString(key));
    }

    static class DSU {
        int[] p;
        DSU(int n) {
            p = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }

        int find(int x) {
            return p[x] == x ? x : (p[x] = find(p[x]));
        }

        boolean union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return false;
            p[a] = b;
            return true;
        }
    }

    static void kruskalMST(List<Edge> edges, int V) {
        edges.sort(Comparator.comparingInt(e -> e.w));
        DSU dsu = new DSU(V);
        System.out.println("Kruskal's MST edges:");
        for (var e : edges) {
            if (dsu.union(e.u, e.v)) System.out.println(e.u + " - " + e.v + " : " + e.w);
        }
    }

    static void Kosaraju(int V, List<List<Integer>> adj) {
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) if (!vis[i]) dfs1(adj, i, vis, st);

        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < V; i++) rev.add(new ArrayList<>());
        for (int u = 0; u < V; u++) for (int v : adj.get(u)) rev.get(v).add(u);

        Arrays.fill(vis, false);
        System.out.println("SCCs:");
        while (!st.isEmpty()) {
            int u = st.pop();
            if (!vis[u]) {
                dfs2(rev, u, vis);
                System.out.println();
            }
        }
    }

    static void dfs1(List<List<Integer>> adj, int u, boolean[] vis, Stack<Integer> st) {
        vis[u] = true;
        for (int v : adj.get(u)) {
            if (!vis[v]) dfs1(adj, v, vis, st);
        }
        st.push(u);
    }

    static void dfs2(List<List<Integer>> rev, int u, boolean[] vis) {
        vis[u] = true;
        System.out.print(u + " ");
        for (int v : rev.get(u)) {
            if (!vis[v]) dfs2(rev, v, vis);
        }
    }

    static void bridges(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] vis = new boolean[V];
        int[] tin = new int[V], low = new int[V];
        int[] timer = new int[1];
        System.out.println("Bridges:");
        for (int i = 0; i < V; i++) if (!vis[i]) dfsBridge(adj, i, -1, vis, tin, low, timer);
    }

    static void dfsBridge(List<List<Integer>> adj, int u, int p, boolean[] vis, int[] tin, int[] low, int[] timer) {
        vis[u] = true;
        tin[u] = low[u] = timer[0]++;
        for (int v : adj.get(u)) {
            if (v == p) continue;
            if (!vis[v]) {
                dfsBridge(adj, v, u, vis, tin, low, timer);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > tin[u]) System.out.println(u + " - " + v);
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }
    }

    static void printAdjList(List<List<Integer>> adj){
        System.out.println("Adjacency list ");
        for(int i = 0; i < adj.size(); i++){
            System.out.print(i +" ");
            for(int j : adj.get(i)) System.out.print(j +" ");
            System.out.println();
        }
    }
    static void printWeightedAdjList(List<List<Pair>> wadj) {
        System.out.println("Weighted Adjacency List:");
        for (int i = 0; i < wadj.size(); i++) {
            System.out.print(i + ": ");
            for (Pair p : wadj.get(i)) {
                System.out.print("(" + p.node + ", " + p.dist + ") ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("V E directed? weighted? ");
        int V = sc.nextInt(), E = sc.nextInt();
        boolean directed = sc.nextBoolean(), weighted = sc.nextBoolean();

        if (!weighted) {
            List<List<Integer>> edgeList = new ArrayList<>();
            System.out.println("Enter edges (u v):");
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt(), v = sc.nextInt();
                edgeList.add(Arrays.asList(u, v));
            }

            Graph g = buildUnweightedGraph(V, edgeList, directed);

            System.out.print("Start for BFS & DFS: ");
            int s = sc.nextInt();
            BFS(g.adj, s, g.V);
            fullBFS(g);
            fullDFS(g);
            System.out.println("Cycle undirected? " + hasCycleUndirected(g.adj));
            if (directed) System.out.println("Cycle directed? " + hasCycleDirected(g.adj));
            if (directed) topoSort(g.adj);
            Kosaraju(V, g.adj);
            bridges(g.adj);

        } else {
            List<Edge> edgeList = new ArrayList<>();
            System.out.println("Enter edges (u v w):");
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
                edgeList.add(new Edge(u, v, w));
            }

            Graph g = buildWeightedGraph(V, edgeList, directed);

            System.out.print("Source for Dijkstra: ");
            dijkstra(g, sc.nextInt());
            System.out.print("Source for Bellman-Ford: ");
            bellmanFord(V, edgeList, sc.nextInt());
            primMST(g);
            kruskalMST(edgeList, V);
        }

        sc.close();
    }
}
