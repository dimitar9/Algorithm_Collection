import java.util.ArrayList;
import java.util.List;
public class pascalTriangle {

public static void main(String [] args) 
{
	int row = 7;
	List<List<Integer>> ret = generate(row);
	for(int i=0;i<ret.size();i++) {
		for(int j=0;j<ret.get(i).size();j++) {
			System.out.printf("%d",ret.get(i).get(j));
		}
		System.out.printf("\n");
	}	
}



public static List<List<Integer>> generate(int numRows) {

	List<List<Integer>> result = new ArrayList<List<Integer>>();
	if (numRows == 0)
		return result;
	
	//Generate the first list
	List<Integer> previous = new ArrayList<Integer>(1);
	previous.add(1);
	result.add(previous);

	for (int i =2; i<= numRows; i++) {
		List<Integer> current = new ArrayList<Integer>(i);
		current.add(1);
		for(int j=1;j<previous.size();j++)
			current.add(previous.get(j-1)+previous.get(j));
		current.add(1);
		result.add(current);
		previous = current;	
	}

	return result;
		

}
}
