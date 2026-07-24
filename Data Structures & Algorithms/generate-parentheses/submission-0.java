class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, new StringBuilder());
        return res;
    }
    private void backtrack(int max, int open, int close, StringBuilder path){
        if (path.length() == 2*max){
            res.add(path.toString());
            return;
        }
        if (open < max){
            path.append('(');
            backtrack(max, open+1, close, path);
            path.deleteCharAt(path.length() -1);
        }
        if (close < open){
            path.append(')');
            backtrack(max, open, close+1, path);
            path.deleteCharAt(path.length() -1);
        }
    }
}
