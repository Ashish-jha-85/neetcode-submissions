class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsets(0, nums, new ArrayList<>());
        return res;
    }
    private void subsets(int start, int[] nums, List<Integer> current){
        if (!res.contains(current)){
            res.add(new ArrayList<>(current));
        }
        for (int i = start; i < nums.length; i++){
            current.add(nums[i]);
            subsets(i+1, nums, current);
            current.remove(current.size() - 1);
        }
    }
}
