class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        permutations(nums, new ArrayList<>());
        return res;
    }
    private void permutations(int[] nums, List<Integer> current){
       if (nums.length == current.size()){
        res.add(new ArrayList<>(current));
       }
       for(int i = 0; i < nums.length; i++){
        if (current.contains(nums[i])){
            continue;
        }
        current.add(nums[i]);
        permutations(nums, current);
        current.remove(current.size() -1);
       }
    }
}
