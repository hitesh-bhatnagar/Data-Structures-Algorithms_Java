// Is there a Path from u to v ?

import java.util.*;

public class Path_exists{

    public static boolean BFS(int start, int end, ArrayList<ArrayList<Integer>> adjacent, int vertex){
        boolean[] visited = new boolean[vertex];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.offer(start);

        while(!queue.isEmpty()){
            
            int current = queue.poll();
            if(current == end) return true;
            for(int neighbour : adjacent.get(current)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.offer(neighbour);
                }
            }
        }
        return false;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edges = sc.nextInt();

        ArrayList<ArrayList<Integer>> adjacent = new ArrayList<>();

        for(int i = 0; i<vertex; i++) adjacent.add(new ArrayList<>());

        for(int i = 0; i<edges ; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            adjacent.get(u).add(v);
            adjacent.get(v).add(u);
        }

        System.out.println("Enter source and destination");
        int start = sc.nextInt(), end = sc.nextInt();

        System.out.print(BFS(start,end,adjacent, vertex));
    }
}