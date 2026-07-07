/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int globalMaxSum;
    public int maxPathSum(TreeNode root) {
       globalMaxSum = Integer.MIN_VALUE;
       calculateGain(root);
       return globalMaxSum; 
    }
    private int calculateGain(TreeNode root){
        if(root == null) return 0;

        int leftGain = Math.max(calculateGain(root.left), 0);
        int rightGain = Math.max(calculateGain(root.right), 0);

        int currentPathSum = root.val + leftGain + rightGain;

        globalMaxSum = Math.max(globalMaxSum, currentPathSum);

        return root.val + Math.max(leftGain , rightGain);
    }
}
