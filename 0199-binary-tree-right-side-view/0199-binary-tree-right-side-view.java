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
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer>ans = new ArrayList<>();
        if(root==null)return ans;
        Queue<TreeNode>qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){
            int level = qu.size();
            for(int i=0;i<level;i++){
                TreeNode curr =qu.poll();
                if(i==level-1)ans.add(curr.val);
                if(curr.left != null)qu.add(curr.left);
                if(curr.right != null)qu.add(curr.right);
            }
            
        }
        return ans;
    }
}