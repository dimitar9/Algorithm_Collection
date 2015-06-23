import java.util.*;

public class Solution {
    private Map<Integer, Integer> record = new HashMap<>();
    private int recordSize = 0;
    private List< List<Integer> > result = new LinkedList<>();
    private LinkedList<Integer> curResult = new LinkedList<>();

    private void build() {
        // new seq
        if (recordSize == 0) {
            result.add((List<Integer>)curResult.clone());
            return;
        }

        for (Map.Entry<Integer, Integer> entry: record.entrySet()) {
            int key = entry.getKey(),
                value = entry.getValue();
            if (value == 0) continue;
            // add key to curResult
            curResult.add(key);
            // reduce value
            value--;
            if (value == 0) recordSize--;
            record.put(key, value);
            // build
            build();
            // put back
            if (value == 0) recordSize++;
            value ++;
            record.put(key, value);
            // remove key from curResult
            curResult.removeLast();
        }
    }

    public List< List<Integer> > permuteUnique(int[] num) {
        for (int i = 0; i < num.length; i ++) {
            if (record.containsKey(num[i])) {
                int val = record.get(num[i]);
                record.put(num[i], val + 1);
            }
            else {
                record.put(num[i], 1);
                recordSize ++;
            }
        }
        build();
        return result;
    }
}



















//////////
//permutation2 c++
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
