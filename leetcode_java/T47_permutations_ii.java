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


//c++
class Solution {
public:
    void recursion(vector<int> num, int i, int j, vector<vector<int> > &res) {
        if (i == j-1) {
            res.push_back(num);
            return;
        }
        for (int k = i; k < j; k++) {
            if (i != k && num[i] == num[k]) continue;
            swap(num[i], num[k]);
            recursion(num, i+1, j, res);
        }
    }
    vector<vector<int> > permuteUnique(vector<int> &num) {
        sort(num.begin(), num.end());
        vector<vector<int> >res;
        recursion(num, 0, num.size(), res);
        return res;
    }
};
