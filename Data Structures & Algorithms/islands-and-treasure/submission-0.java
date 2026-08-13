class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0)
            return;

        int r = grid.length;
        int c = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];

            for (int[] dir : direction) {
                int newRow = dir[0] + row;
                int newCol = dir[1] + col;

                if (newRow < 0 || newCol < 0 || newRow >= r || newCol >= c
                    || grid[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                grid[newRow][newCol] = grid[row][col] + 1;
                queue.offer(new int[] {newRow, newCol});
            }
        }
    }
}
