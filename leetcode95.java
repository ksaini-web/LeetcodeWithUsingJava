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
    public List<TreeNode> generateTrees(int n) {

        if(n==0) return new ArrayList<>();

        return solve(1,n);


        
    }

    private List<TreeNode> solve(int start , int end){

        List<TreeNode> ans = new ArrayList<>();


        if(start>end){
            ans.add(null);
            return ans;

        }
        if(start == end){
            ans.add(new TreeNode(start));
            return ans;
        }

        for(int i=start;i<=end;i++ ){

            List<TreeNode> left = solve(start,i-1);
            List<TreeNode> right = solve(i+1,end);

            for(TreeNode l : left){

                for(TreeNode r : right){

                    TreeNode root = new TreeNode(i);

                    root.left = l;
                    root.right = r;

                    ans.add(root);


                }
            }
        }

        return ans;


    }
}
