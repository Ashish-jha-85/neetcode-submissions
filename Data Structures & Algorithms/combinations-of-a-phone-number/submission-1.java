class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }
        String[] phoneMap = {
            "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };
        backtrack(res, digits, new StringBuilder(),phoneMap, 0);
        return res;
    }
    private void backtrack(List<String> res, String digits, StringBuilder current, String[] phoneMap, int start){
        if (start == digits.length()){
            res.add(current.toString());
            return;
        }
        char digitsChar = digits.charAt(start);
        String phoneChar = phoneMap[digitsChar - '0'];
        for (char c : phoneChar.toCharArray()){
             current.append(c);
             backtrack(res, digits, current, phoneMap, start+1);
             current.deleteCharAt(current.length() -1);
        }

    }
}
