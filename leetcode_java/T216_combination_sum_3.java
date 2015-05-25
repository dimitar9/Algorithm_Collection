
public class Solution {
    
    private List<List<Integer>> ret;
    private List<Integer> curList;
    
    public List<List<Integer>> combinationSum3(int k, int target) {
        ret = new ArrayList<List<Integer>>();
        curList = new ArrayList<Integer>();
        int[] candidates = { 1,2,3,4,5,6,7,8,9};
        getSum(candidates,target,0, k);
        return ret;
    }
    private void getSum(int[] candidates, int target, int lastIndex,int cap){
        if(target == 0){
            if (curList.size()!=cap)
                return;
            ret.add(new ArrayList<Integer>(curList));
        } else if(target < 0){
            return;
        } else {
            int i = lastIndex;
            while(i < candidates.length){
                int candidate = candidates[i];
                curList.add(candidate);
                getSum(candidates, target-candidate, i+1, cap);
                curList.remove(curList.size()-1);
                while( (i< (candidates.length-1)) && (candidates[i]==candidates[i+1])){
                    i++;
                }
                i++;
            }
        }
    }
}
