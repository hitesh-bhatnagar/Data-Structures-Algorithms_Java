import java.util.*;

public class Matrix_Based_Graphs{
    static  List<List<Integer>> Adj_List(int V, int[][] edges, boolean directed){
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < V; i++) list.add(new ArrayList<>());
        for(int[] e : edges){
            list.get(e[0]).add(e[1]);
            if(!directed) list.get(e[1]).add(e[0]);
        }
        return list;
    }

    static int[][] Adj_Matrix(int V, int[][] edges, boolean directed){
        int[][] matrix = new int[V][V];
        for(int[] e : edges){
            matrix[e[0]][e[1]] = 1;
            if(!directed) matrix[e[1]][e[0]] = 1;
        }
        return matrix;
    }


    // ---------------------- MODULE 5: Flood Fill / DFS Area Marking ----------------------
    void dfsArea(int[][] grid, int i , int j) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = -1;
        dfsArea(grid, i+1, j);
        dfsArea(grid, i-1, j);
        dfsArea(grid, i, j+1);
        dfsArea(grid, i, j-1);
    }

    // ---------------------- MODULE 6: Multi-source BFS Template ----------------------
    void multiSourceBFS(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 2) q.offer(new int[]{i, j});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int ni = cur[0] + d[0], nj = cur[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1) {
                    grid[ni][nj] = 2;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
    }

    // ---------------------- MODULE 7: Single-source Shortest Path in Grid ----------------------
    int shortestPathBFS(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1], steps = cur[2];
            if (i == m-1 && j == n-1) return steps;

            for (int[] d : dir) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 0 && !vis[ni][nj]) {
                    vis[ni][nj] = true;
                    q.offer(new int[]{ni, nj, steps+1});
                }
            }
        }
        return -1;
    }

    // ---------------------- MODULE 8: Perimeter Counting ----------------------
    int countIslandPerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length, perimeter = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i-1][j] == 1) perimeter -= 2;
                    if (j > 0 && grid[i][j-1] == 1) perimeter -= 2;
                }
            }
        }
        return perimeter;
    }

    // ---------------------- MODULE 9: Grid Backtracking Template ----------------------
    boolean gridBacktrack(char[][] grid, int i, int j, String word, int idx) {
        if (idx == word.length()) return true;
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != word.charAt(idx)) return false;

        char temp = grid[i][j];
        grid[i][j] = '#';
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        for (int[] d : dir) {
            if (gridBacktrack(grid, i + d[0], j + d[1], word, idx + 1)) return true;
        }
        grid[i][j] = temp;
        return false;
    }

    public static void main(String[] args) {
        System.out.println("✅ Graph Modules Template Loaded");
    }
}