class Solution {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0)
            return -1;
        int r = grid.length;
        int min = 0;
        int c = grid[0].length;
        Queue<int []> queue = new LinkedList<>();
        int freshCount = 0;

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                if (grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
                else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) {
            return 0;
        }
        int[][] direction  = {{-1,0},{1,0},{0,-1},{0,1}};
        while (!queue.isEmpty() && freshCount > 0){
            min++;
            int size = queue.size();
            for (int i = 0; i < size; i++){
                int[] curr = queue.poll();
                int row = curr[0];
                int col = curr[1];
                for (int[] dir : direction){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1]; 
                   if (newRow >= 0 && newRow < r && newCol >= 0 && newCol < c 
                        && grid[newRow][newCol] == 1) {
                        
                    
                        grid[newRow][newCol] = 2;
                        freshCount--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return freshCount == 0 ? min : -1;
    }
}
