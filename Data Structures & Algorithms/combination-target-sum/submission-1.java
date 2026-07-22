class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        findCombination(0, target, nums, new ArrayList<>());
        return res;
    }
    public void findCombination(int start, int target, int[] nums, List<Integer> current){
        if (nums.length == start){
            if (target == 0){
                res.add(new ArrayList<>(current));
            }
            return;
        }
        if (nums[start] <= target){
            current.add(nums[start]);
            findCombination(start, target - nums[start], nums, current);
            current.remove(current.size() - 1);
        }
        findCombination(start + 1, target, nums, current);
    }
}
