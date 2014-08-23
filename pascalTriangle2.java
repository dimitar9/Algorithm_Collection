import java.util.ArrayList;
import java.util.List;
public class pascalTriangle2 {

public static void main(String [] args) 
{
	int row = 7;
	List<Integer> ret = getRow(row);
	
	for(int j=0;j<ret.size();j++) {
		System.out.printf("%d,",ret.get(j));
	}
	System.out.printf("\n");
	
}


public  static ArrayList<Integer> getRow(int rowIndex) {
	int []res = new int[rowIndex +1];
	res[0] = 1;
	if(rowIndex==0) return getList(res);
	for(int j=1; j<rowIndex+1;j++){
		for(int i=j;i>0;i--){
			res[i] = res[i-1] + res[i];
		}
		res[j]=1;
	}
	return getList(res);
}

public static ArrayList<Integer> getList(int[] nums) {
	ArrayList<Integer> res = new ArrayList<Integer>();
	for(int i=0; i<nums.length; i++) {
		res.add(nums[i]);
	}
	return res;
}




}
