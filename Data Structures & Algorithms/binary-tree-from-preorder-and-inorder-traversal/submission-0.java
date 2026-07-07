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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        stack.push(root);
       int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderValue = preorder[i];
            TreeNode currentNode = stack.peek();
            if (currentNode.val != inorder[inorderIndex]) {
                currentNode.left = new TreeNode(preorderValue);
                stack.push(currentNode.left);
            } else {
                TreeNode lastPopNode = null;
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    lastPopNode = stack.pop();
                    inorderIndex++;
                }
                lastPopNode.right = new TreeNode(preorderValue);
                stack.push(lastPopNode.right);
            }
        }
        return root;
    }
}
