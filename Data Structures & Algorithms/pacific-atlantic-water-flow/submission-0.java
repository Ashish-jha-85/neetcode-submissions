class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0)
            return result;
        int row = heights.length;
        int col = heights[0].length;
        boolean[][] pacificReachable = new boolean[row][col];
        boolean[][] atlanticReachable = new boolean[row][col];
        for (int c = 0; c < col; c++) {
            dfs(heights, pacificReachable, 0, c, heights[0][c]);
            dfs(heights, atlanticReachable, row - 1, c, heights[row - 1][c]);
        }
        for (int r = 0; r < row; r++) {
            dfs(heights, pacificReachable, r, 0, heights[r][0]);
            dfs(heights, atlanticReachable, r, col - 1, heights[r][col - 1]);
        }
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (pacificReachable[r][c] && atlanticReachable[r][c]) {
                    result.add(Arrays.asList(r, c));
                }
            }
        }
        return result;
    }
    private void dfs(int[][] heights, boolean[][] reachable, int r, int c, int prevHeight) {
        if (r < 0 || r >= heights.length || c < 0 || c >= heights[0].length)
            return;
        if (reachable[r][c] || prevHeight > heights[r][c])
            return;
        reachable[r][c] = true;
        int currentHeight = heights[r][c];
        dfs(heights, reachable, r + 1, c, currentHeight);
        dfs(heights, reachable, r - 1, c, currentHeight);
        dfs(heights, reachable, r, c + 1, currentHeight);
        dfs(heights, reachable, r, c - 1, currentHeight);
    }
}
