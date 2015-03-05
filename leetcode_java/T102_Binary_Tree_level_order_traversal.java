public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    List<TreeNode> level = new ArrayList<>();
    level.add(root);
    while(true){
        if (level.isEmpty() || level.get(0) == null){
            break;
        }
        List<TreeNode> nextLevel = new ArrayList<>();
        List<Integer> currentLevel = new ArrayList<>();

        for (TreeNode node : level){
            currentLevel.add(node.val);
            if (node.left != null) nextLevel.add(node.left);
            if (node.right != null) nextLevel.add(node.right);
        }
        result.add(currentLevel);
        level = nextLevel;
    }
    return result;
}
