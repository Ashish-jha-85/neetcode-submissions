class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums, new ArrayList<>());
        return ans;
    }

    void dfs(int index, int[] nums, List<Integer> current) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Include
        current.add(nums[index]);
        dfs(index + 1, nums, current);

        // Undo
        current.remove(current.size() - 1);

        // Exclude
        dfs(index + 1, nums, current);
    }
}