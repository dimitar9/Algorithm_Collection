private ListNode node;

public TreeNode sortedListToBST(ListNode head) {
    if(head == null){
        return null;
    }

    int size = 0;
    ListNode runner = head;
    node = head;

    while(runner != null){
        runner = runner.next;
        size ++;
    }

    return inorderHelper(0, size - 1);
}

public TreeNode inorderHelper(int start, int end){
    if(start > end){
        return null;
    }

    int mid = start + (end - start) / 2;
    TreeNode left = inorderHelper(start, mid - 1);

    TreeNode treenode = new TreeNode(node.val);
    treenode.left = left;
    node = node.next;

    TreeNode right = inorderHelper(mid + 1, end);
    treenode.right = right;

    return treenode;
}
