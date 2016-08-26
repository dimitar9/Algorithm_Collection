
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
public class DuplicateSubTree {

    Set<String> subTreeStr = new HashSet<>();
    Set<String> result = new HashSet<>();
    public List<String> findDupSubTree(TreeNode root){
        generateStr(root, new HashSet<>());
        List<String> ret  = new ArrayList<>();
        for(String s : result){
            ret.add(s);
        }
        return ret;
    }

    private void generateStr(TreeNode node, Set<String> curStrSet){
        if(node == null){
            return ;
        }
        if(node.left == null && node.right == null && subTreeStr.contains(Integer.toString(node.val))){
            result.add(Integer.toString(node.val));
        }
        Set<String> newCur = new HashSet<>();
        for(String cur : curStrSet) {
            if (cur == null || cur.isEmpty()) {
                cur = ""+ node.val;
            } else {
                cur = cur + "->" + node.val;
            }
            newCur.add(cur);
            if (node.left == null && node.right == null) {
                if (!subTreeStr.add(cur)) {
                    result.add(cur);
                }
            }
        }

        newCur.add(Integer.toString(node.val));
        if(node.left == null && node.right == null){
            subTreeStr.add(Integer.toString(node.val));
        }
        generateStr(node.left, newCur);
        generateStr(node.right, newCur);

    }

    public static void main(String... args){
        DuplicateSubTree dup = new DuplicateSubTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        TreeNode left = root;
        left = left.left;
        left.left = new TreeNode(4);
        TreeNode right = root;
        right = right.right;
        right.right = new TreeNode(4);
        right.left = new TreeNode(2);
        right = right.left;
        right.left = new TreeNode(4);
        List<String> ret = dup.findDupSubTree(root);

        for(String s : ret){
            System.out.println(s);
        }
    }
}

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val = val;
    }




}
