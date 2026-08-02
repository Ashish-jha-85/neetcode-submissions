class Solution {
     public int subsetXORSum(int[] nums) {
        return backtrack(nums, 0, 0);
    }
    private int  backtrack(int[] nums, int start, int currentSum){
        if( start == nums.length){           
            return currentSum;
        }
        int include = backtrack(nums, start + 1, currentSum ^ nums[start]);
        int exclude = backtrack(nums, start+1, currentSum);
        return include + exclude;
        
    }
}