class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(i == 0 && j == 0)
                    continue;
                int left = 10000;
                if(i-1 >= 0){
                    left = grid[i-1][j];
                }
                int up = 10000;
                if(j-1 >= 0){
                    up = grid[i][j-1];
                }
                grid[i][j] = Math.min(grid[i][j] + left,grid[i][j] +up);
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

}