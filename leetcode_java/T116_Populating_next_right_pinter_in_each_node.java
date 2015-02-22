/* Go through parent level by its next pointer to generate children level next pointer */
public class Solution {
    public void connect(TreeLinkNode root) {

        TreeLinkNode leftWall = root;
        while (leftWall != null) {

            TreeLinkNode across = leftWall;
            while (across != null) {
                if (across.left != null) {
                    across.left.next = across.right;
                }

                if (across.right != null && across.next != null) {
                    across.right.next = across.next.left;
                }

                across = across.next;
            }
            leftWall = leftWall.left;
        }
    }
}
