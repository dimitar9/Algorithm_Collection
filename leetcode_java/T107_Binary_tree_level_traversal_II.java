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
    List<List<Integer>> ll = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
        
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root==null) return ll;
        int level = 1;
        list.add(root.val);
        ll.add(list);
        insertNode(root.left, level+1);
        insertNode(root.right, level+1);
        Collections.reverse(ll);
        return ll;

    }
    void insertNode(TreeNode node, int level){
        if(node == null) return;
        if (ll.size() < level) {
            List<Integer> newList= new ArrayList<Integer>();
            newList.add(node.val);
            ll.add(newList);
        } else {
            ll.get(level-1).add(node.val);
        }
        insertNode(node.left, level+1);
        insertNode(node.right, level+1);
    }
}
