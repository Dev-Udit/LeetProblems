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
    public void inorder(TreeNode root,ArrayList<Integer>list){
        if(root==null )return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right,list);
    }

    public TreeNode buildBst(int i,int j, ArrayList<Integer>list){
        if(i>j)return null;
        
        int mid = i+(j-i)/2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildBst(i,mid-1,list);
        root.right = buildBst(mid+1,j,list);
        
        
    return root;

    }
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer>list = new ArrayList<>();
        inorder(root,list);
        return buildBst(0,list.size()-1,list);
        
    }
}