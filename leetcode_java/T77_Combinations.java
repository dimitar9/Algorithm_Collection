public class Solution {
	
public List<List<Integer>> combine(int n, int k){
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    combine(n, k, 1, result, new ArrayList<Integer>());
    return result;
}

public void combine(int n, int k , int start, List<List<Integer>> result, ArrayList<Integer> l){
    if(k == 0){
        result.add(l);
        return;
    }
    for(int i = start; i <= n; ++i){
        ArrayList<Integer> a = (ArrayList<Integer>) l.clone();
        a.add(i);
        combine(n, k - 1, i + 1, result, a);
    }
}


}
