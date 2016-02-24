import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0) return res;
        TreeNodeSpecial root = new TreeNodeSpecial(nums[nums.length - 1]);
        res.add(0);
        for(int i = nums.length - 2; i >= 0; i--) {
            int count = insertNode(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    public int insertNode(TreeNodeSpecial root, int val) {
    	System.out.println("Insert Node " + val);
        int thisCount = 0;
        while(true) {
            if(val <= root.val) {
                root.count++;
                System.out.println("DEBUG: thisCount ++ " );
                if(root.left == null) {
                    root.left = new TreeNodeSpecial(val); break;
                } else {
                    root = root.left;
                }
            } else {
                thisCount += root.count;
                System.out.println("DEBUG: thisCount += root.count; " + thisCount);
                if(root.right == null) {
                    root.right = new TreeNodeSpecial(val); break;
                } else {
                    root = root.right;
                }
            }
        }
        System.out.println("DEBUG: thisCount is " + thisCount);
        return thisCount;
    }
    public static void main(String[] args) {
    	T315 t = new T315();
    	List<Integer> ret = t.countSmaller(new int[]{5,2,6,1});
    	System.out.println(ret);
    }
}
class TreeNodeSpecial {
	TreeNodeSpecial left; 
	TreeNodeSpecial right;
    int val;
    int count = 1;
    public TreeNodeSpecial(int val) {
        this.val = val;
    }
}
