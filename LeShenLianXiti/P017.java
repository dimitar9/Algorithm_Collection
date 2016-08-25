/*
17. 给一颗二叉树，返回重复的subtree。比如：
    1
   / \
  2  3
 /  / \
4  2  4
  /
 4
结果应该返回[ ( 2 -> 4), (4) ] 两颗树。
 */

import google.TreeNode;

import java.util.*;

public class Solution {
    public List<String> duplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> preorders = new HashMap<>();
        List<String> ans = new ArrayList<>();
        preorder(preorders, ans, root);
        return ans;
    }

    private String preorder(HashMap<String, Integer> preorders, List<String> ans, TreeNode root) {
        if (root == null) return "#";
        String strLeft = preorder(preorders, ans, root.left);
        String strRight = preorder(preorders, ans, root.right);
        String pre = root.val + "," + strLeft + "," + strRight;
        int count = 0;
        if (preorders.containsKey(pre)) {
            count = preorders.get(pre);
            if (count == 1) ans.add(pre);
        }
        preorders.put(pre, count + 1);
        return pre;
    }
}

class Tests {
    public static void main(String... args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1,
                            new TreeNode(2,
                                    new TreeNode(4),null
                            ),
                            new TreeNode(3,
                                    new TreeNode(2,
                                        new TreeNode(4), null),
                                    new TreeNode(4)
                            )
        );
        System.out.print(sol.duplicateSubtrees(root));
    }
}
