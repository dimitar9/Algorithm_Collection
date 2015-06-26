public class Solution {
	
public List<List<Integer>> combine(int n, int k){
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    combine(n, k, 1, result, new ArrayList<Integer>());
    return result;
}

public void combine(int n, int k , int start, List<List<Integer>> result, ArrayList<Integer> l){
    if(k == 0){
        result.add(new ArrayList<Integer>(l));
        return;
    }
    for(int i = start; i <= n; ++i){
        
        
        l.add(i);
        combine(n, k - 1, i + 1, result, l);
        l.remove(l.size()-1);
    }
}


}
