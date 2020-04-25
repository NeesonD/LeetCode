package com.neeson.algo.queuestack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author daile
 * @version 1.0
 * @date 2020/4/25 12:38
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        return dfs(grid);
    }

    int dfs(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int m = grid.length, n = grid[0].length, res = 0;
        boolean[][] marked = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '0' || marked[i][j]) {
                    continue;
                }
                helper(grid, marked, i, j);
                res++;
            }
        }
        return res;
    }

    void helper(char[][] grid, boolean[][] marked, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || marked[x][y]) {
            return;
        }
        marked[x][y] = true;
        helper(grid, marked, x - 1, y);
        helper(grid, marked, x + 1, y);
        helper(grid, marked, x, y - 1);
        helper(grid, marked, x, y + 1);
    }

    int bfs(char[][] grid) {
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] marked = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (marked[i][j] || grid[i][j] == '0') {
                    continue;
                }
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i * n + j);
                marked[i][j] = true;
                while (!queue.isEmpty()) {
                    Integer cur = queue.poll();
                    int curX = cur / n;
                    int curY = cur % n;
                    for (int k = 0; k < 4; k++) {
                        int x = curX + directions[k][0];
                        int y = curY + directions[k][1];
                        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0' || marked[x][y]) {
                            continue;
                        }
                        queue.offer(x * n + y);
                        marked[x][y] = true;
                    }
                }
                count++;
            }
        }
        return count;
    }

}
