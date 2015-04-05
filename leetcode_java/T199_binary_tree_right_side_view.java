/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> rst = new ArrayList<>();
        if(root == null) return rst;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            for(int i = 0; i < levelNum; i++){
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                if(i == levelNum - 1) rst.add(queue.poll().val);
                else queue.poll();
            }
        }
        return rst;
    }
}
