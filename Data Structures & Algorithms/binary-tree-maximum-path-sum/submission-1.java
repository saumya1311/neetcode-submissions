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
    int maxsum= Integer.MIN_VALUE;

    public int maxvalue(TreeNode root){
        if(root==null) return 0;

        int leftMax= Math.max(maxvalue(root.left),0);
        int rightMax=Math.max(maxvalue(root.right),0);

        int currsum=root.val+leftMax+rightMax;

        maxsum=Math.max(maxsum, currsum);

        return Math.max(leftMax,rightMax)+root.val;
    }

    public int maxPathSum(TreeNode root) {
        maxvalue(root);
        return maxsum;
    }
}
