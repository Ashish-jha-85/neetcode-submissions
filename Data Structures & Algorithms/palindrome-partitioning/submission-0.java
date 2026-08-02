class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s, 0, new ArrayList<>());
        return res;
    }
    private void backtrack(List<List<String>> res, String s, int start, List<String> current){
        if (start == s.length()){
            res.add(new ArrayList<>(current));
            return;
        }
        for (int i = start; i < s.length(); i++){
            if (isPalindrom(s,start, i)){
                current.add(s.substring(start, i+1));
                backtrack(res, s, i+1,current);
                current.remove(current.size()-1);
            }
        }
    }
    private boolean isPalindrom(String s, int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
