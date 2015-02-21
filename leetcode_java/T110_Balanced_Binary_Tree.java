private static final int UNBALANCED = -99;

public boolean isBalanced(TreeNode root) {
    if (root == null) {
        return true;
    }
    return getHeight(root) != UNBALANCED;
}

private int getHeight(TreeNode root) {
    if (root == null) {
        return -1;
    }
    int l = getHeight(root.left);
    int r = getHeight(root.right);
    if (l == UNBALANCED || r == UNBALANCED || Math.abs(l-r) > 1) {
        return UNBALANCED;
    }
    return 1 + Math.max(l,r);
}
/*
O(n）solution
It visits each node just once hence the linear time complexity.

Even if you don't understand what the code does just notice that the only place where recursion happens is at:

int l = getHeight(root.left);
int r = getHeight(root.right);

thus we will never visit the same node twice.

*/
