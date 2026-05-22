class Solution {

    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {

        TreeNode find = find(root, x);

        int lc = cnt(find.left);
        int rc = cnt(find.right);
        int pc = n - lc - rc - 1;

        int max = Math.max(lc, Math.max(rc, pc));

        return max > n / 2;
    }

    public int cnt(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lc = cnt(root.left);
        int rc = cnt(root.right);

        return lc + rc + 1;
    }

    public TreeNode find(TreeNode root, int x) {
        if (root == null) {
            return null;
        }

        if (root.val == x) {
            return root;
        }

        TreeNode left = find(root.left, x);
        if (left != null) {
            return left;
        }

        return find(root.right, x);
    }
}
