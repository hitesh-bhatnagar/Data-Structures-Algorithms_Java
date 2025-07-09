import java.util.*;

public class GridGraph_Patterns {

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    // ✅ 1. Flood Fill / DFS Area Marking Template
    // 🧠 Used in: Number of Islands, Flood Fill, Surrounded Regions
    static void dfsFill(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return;

        grid[i][j] = -1; // mark visited

        for (int[] d : dir) {
            dfsFill(grid, i + d[0], j + d[1]);
        }
    }

    // ✅ 2. MultiSource BFS Template
    // 🧠 Used in: Rotting Oranges, Walls and Gates, Fire Spread
    static void multiSourceBFS(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // Add all sources (e.g., all 2s in rotting oranges)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int[] d : dir) {
                int ni = current[0] + d[0];
                int nj = current[1] + d[1];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 1) {
                    grid[ni][nj] = 2;
                    queue.offer(new int[]{ni, nj});
                }
            }
        }
    }

    // ✅ 3. Shortest path from single source (Grid BFS)
    // 🧠 Used in: Shortest path in binary matrix, escape maze
    static int shortestPathBFS(int[][] grid, int si, int sj, int ei, int ej) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{si, sj, 0});
        visited[si][sj] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], steps = curr[2];

            if (i == ei && j == ej) return steps;

            for (int[] d : dir) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && nj >= 0 && ni < m && nj < n && grid[ni][nj] == 0 && !visited[ni][nj]) {
                    visited[ni][nj] = true;
                    queue.offer(new int[]{ni, nj, steps + 1});
                }
            }
        }

        return -1;
    }

    // ✅ 4. Grid perimeter counting (No BFS/DFS)
    // 🧠 Used in: Island perimeter, Lake Borders
    static int calculatePerimeter(int[][] grid) {
        int m = grid.length, n = grid[0].length, perimeter = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    perimeter += 4;
                    if (i > 0 && grid[i - 1][j] == 1) perimeter -= 2;
                    if (j > 0 && grid[i][j - 1] == 1) perimeter -= 2;
                }
            }
        }

        return perimeter;
    }

    // ✅ 5. Grid Backtracking DFS Template
    // 🧠 Used in: Word search, unique paths III, Rat in Maze
    static boolean dfsBackTrack(char[][] grid, int i, int j, String word, int index) {
        if (index == word.length()) return true;

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = grid[i][j];
        grid[i][j] = '#'; // mark visited

        for (int[] d : dir) {
            int ni = i + d[0];
            int nj = j + d[1];
            if (dfsBackTrack(grid, ni, nj, word, index + 1)) {
                grid[i][j] = temp;
                return true;
            }
        }

        grid[i][j] = temp; // unmark
        return false;
    }

    // Main method with sample tests
    public static void main(String[] args) {
        int[][] grid = {
            {0, 0, 0},
            {1, 1, 0},
            {0, 0, 0},
            {0, 1, 1},
            {0, 0, 0}
        };
        System.out.println("Shortest path = " + shortestPathBFS(grid, 0, 0, 4, 2));

        int[][] island = {
            {0, 1, 0, 0},
            {1, 1, 1, 0},
            {0, 1, 0, 0},
            {1, 1, 0, 0}
        };
        System.out.println("Perimeter = " + calculatePerimeter(island));

        char[][] board = {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        String word = "ABCCED";
        boolean found = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfsBackTrack(board, i, j, word, 0)) {
                    found = true;
                    break;
                }
            }
        }
        System.out.println("Word found = " + found);
    }
}
