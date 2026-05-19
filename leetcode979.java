class Solution {
    int ans = 0;

    public int distributeCoins(TreeNode root) {
        help(root);
        return ans;
    }

    public int help(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lc = help(root.left);
        int rc = help(root.right);

        ans += Math.abs(lc) + Math.abs(rc);

        return lc + rc + root.val - 1;
    }
}
