public class Solution {

    public int orangesRotting(int[][] grid) {
        Queue<Point> q1 = new LinkedList<>();
        Queue<Point> q2 = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q1.add(new Point(i, j));
                }
            }
        }
        int time = 0;
        while (!q1.isEmpty()) {
            Point p = q1.remove();
            int i = p.x;
            int j = p.y;
            // up
            if (i > 0) {
                if (grid[i - 1][j] == 1) {
                    grid[i-1][j] = 2;
                    q2.add(new Point(i - 1, j));
                }
            }
            // down
            if (i < grid.length - 1) {
                if (grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 1;
                    q2.add(new Point(i + 1, j));
                }
            }
            // left
            if (j > 0) {
                if (grid[i][j - 1] == 1) {
                    q2.add(new Point(i, j - 1));
                }
            }
            // right
            if (j < grid[0].length - 1) {
                q2.add(new Point(i, j + 1));
            }

            if (q1.isEmpty()) {
                time++;
                while (!q2.isEmpty()) {
                    q1.add(q2.remove());
                }
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return time;
    }