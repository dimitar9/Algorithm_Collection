import java.util.ArrayList;
import java.util.List;


public class T95 {
	public List<TreeNode> generateTrees(int n) {

        return genTrees(1,n);
    }

    public List<TreeNode> genTrees (int start, int end)
    {

        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

     

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {

            left = genTrees(start, i-1);
            right = genTrees(i+1,end);

            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }
    
	   public static void main(String[] args){
		   T95 t95 = new T95();
		   List<TreeNode> l = new ArrayList<>();
		   l = (t95.generateTrees(3));
		   for(TreeNode tl : l) {
			   System.out.println(tl.val);
		   }
	   }
}
