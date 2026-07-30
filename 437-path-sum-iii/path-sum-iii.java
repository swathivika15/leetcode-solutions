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
    int res=0;
    void dfs(TreeNode root,int tar,long sum){
        if(root==null)
            return;
        sum+=root.val;
        if(sum==tar)
            res++;
        dfs(root.left,tar,sum);
        dfs(root.right,tar,sum);
    }
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null)
            return 0;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode node=st.pop();
            dfs(node,targetSum,0);
            if(node.left!=null)
                st.push(node.left);
            if(node.right!=null)
                st.push(node.right);
        }
        return res;
    }
}