import java.util.*;

public class Day_2_WeightedGraph{
    
    static class Edge{
        int u, v, w;
        Edge(int u, int v, int w){
            this.u = u; this.v = v; this.w = w;
        }
    }

    static class Pair{
        int node ,  weight;
        Pair(int node , int weight){
            this.node = node; this.weight = weight;
        }
    }

    //              Dijkstra's Algo (Shortest Path, No Negative Edges)
    
    static int[] dijkstra(int V, List<List<Pair>> list, int src){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);

        queue.offer(new Pair(src, 0));

        while(!queue.isEmpty()){
            Pair current = queue.poll();
            for(Pair p : list.get(current.node)){
                if(dist[p.node] > dist[current.node] + p.weight){
                    dist[p.node] = dist[current.node] + p.weight;
                    queue.offer(new Pair(p.node, dist[p.node]));
                }
            }
        }

        return dist;
    }

    //          Bellman-Ford (Handles Negative weights)

    static int[] bellmanFord(int V, List<Edge> edges, int src){
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i = 0; i<V; i++){
            for(Edge e : edges){
                if(dist[e.u] != Integer.MAX_VALUE && dist[e.v] > dist[e.u] + e.w){
                    dist[e.v] = dist[e.u] + e.w;
                }
            }
        }
        // Negative cycle check

        for(Edge e : edges){
            if(dist[e.u] != Integer.MAX_VALUE && dist[e.v] > dist[e.u] + e.w){
                System.out.println("Negative cycle detected");
                return null;
            }
        }
        return dist;
    }

    //          Prim's Algo for Minimum Spanning Tree

    static int primMST(int V, List<List<Pair>> list){
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        queue.offer(new Pair(0, 0));

        int totalCost = 0;
        while(!queue.isEmpty()){
            int u = queue.poll().node;
            if(inMST[u]) continue;
            inMST[u] = true;
            totalCost += key[u];

            for(Pair p : list.get(u)){
                if(!inMST[p.node] && p.weight < key[p.node]){
                    key[p.node] = p.weight;
                    queue.offer(new Pair(p.node, key[p.node]));
                }
            }
        }
        return totalCost;
    }

    //              Kruskal's MST

    static class DSU{               // Disjoint Set Union
        int[] parent;
        DSU(int n){
            parent = new int[n];
            for(int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x){
            if(x != parent[x]) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int x, int y){
            parent[find(x)] = find(y);
        }
    }

    static int kruskalMST(int V, List<Edge> edges){
        edges.sort(Comparator.comparingInt(e -> e.w));
        
        DSU dsu = new DSU(V);
        int totalCost = 0;

        for(Edge e : edges){
            if(dsu.find(e.u) != dsu.find(e.v)){
                totalCost += e.w;
                dsu.union(e.u, e.v);
            }
        }

        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(), E = sc.nextInt();
        List<List<Pair>> list = new ArrayList<>();
        List<Edge> edgelist = new ArrayList<>();
        for(int i = 0; i < V; i++) list.add(new ArrayList<>());

        for(int i = 0; i< E; i++){
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            list.get(u).add(new Pair(v, w));
            list.get(v).add(new Pair(u, w));
            edgelist.add(new Edge(u, v, w));
        }

        int[] dijkstraResult = dijkstra(V, list, 0);
        System.out.println("Dijkstra from 0 : "+ Arrays.toString(dijkstraResult));

        int[] bellmanResult = bellmanFord(V, edgelist, 0);
        if(bellmanResult != null) System.out.println("Bellman for from 0 : "+ Arrays.toString(bellmanResult));

        System.out.println("Prim's MST cost " + primMST(V, list));
        System.out.println("Kruskal's MST cost "+ kruskalMST(V, edgelist));
    }

}