public class Solution {
private List<List<Integer>> res = new ArrayList<List<Integer>>();
private ArrayList<Integer> per = new ArrayList<Integer>();

public List<List<Integer>> permuteUnique(int[] num) {
    Arrays.sort(num);
    for(int n:num) per.add(n);
    getPer(0);
    return res;
}

void getPer(int index) {
    if( index >= per.size()-1 ) {
        res.add(new ArrayList<Integer>(per));
        return;
    }
    Integer previous = null;
    for( int i=per.size()-index; i>0; i-- ) {
        if( per.get(index) != previous ) getPer(index+1);
        per.add(previous = per.remove(index));
    }
}
}
