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

      long TotalSum =0;
      long maxProduct =0;
      static final int  MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
      TotalSum = getTotalSum(root);
      getSubtreeSum(root);
      return (int) (maxProduct % MOD);
    }

    public long getTotalSum(TreeNode root){
        if(root==null) return 0;
        return root.val+ getTotalSum(root.left)+ getTotalSum(root.right);
    }

    public long getSubtreeSum(TreeNode root){
        if(root==null) return 0;
       long left = getSubtreeSum(root.left);
       long right = getSubtreeSum(root.right);

       long sum = left + right + root.val;
       long product = sum * (TotalSum - sum);
       maxProduct = Math.max(maxProduct,product);
       return sum;
    }
}