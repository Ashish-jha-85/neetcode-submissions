class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        backtrack(0, nums, new ArrayList<>());

        return ans;
    }

    void backtrack(int start, int[] nums, List<Integer> current) {

        // Save current subset
        ans.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(i + 1, nums, current);

            // Undo (Backtrack)
            current.remove(current.size() - 1);
        }
    }
}