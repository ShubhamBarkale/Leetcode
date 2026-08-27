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
    public boolean isCompleteTree(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean foundNull = false;

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            if (node == null) {
                foundNull = true;
            } 
            else {

                if (foundNull) {
                    return false;
                }

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        return true;
    }
}