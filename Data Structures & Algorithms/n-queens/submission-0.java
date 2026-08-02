class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] chess = new char[n][n];
        for (char[] c : chess){
            Arrays.fill(c,'.');
        }
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2*n];
        boolean[] diag2 = new boolean[2*n];

        backtrack(res, chess, 0, n, cols, diag1, diag2);
        return res;
    }
    private void backtrack(List<List<String>> res , char[][] board, int row, int n, boolean[] cols, boolean[] diag1, boolean diag2[]){
        if (row == n){
            List<String> valid = new ArrayList<>();
            for (char[] c : board){
                valid.add(new String(c));
            }
            res.add(valid);
            return;
        }
        for (int col = 0; col < n; col++){
            int d1 = row + col;
            int d2 = row - col + n;

            if (cols[col] || diag1[d1] || diag2[d2]){
                continue;
            }
            board[col][row] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            backtrack(res, board, row +1 , n , cols, diag1, diag2);
            board[col][row] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }

    }
}
