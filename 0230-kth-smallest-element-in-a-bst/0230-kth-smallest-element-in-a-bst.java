class Solution {

    public int inorder(TreeNode root, int k, int[] cnt){
        if(root == null) return -1;

        int res = inorder(root.left, k, cnt);
        if(res != -1) return res;

        cnt[0]++;
        if(cnt[0] == k) return root.val;

        return inorder(root.right, k, cnt);
    }

    public int kthSmallest(TreeNode root, int k) {
        return inorder(root, k, new int[1]);
    }
}
