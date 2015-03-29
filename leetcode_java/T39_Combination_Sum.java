public class Solution {

    private List<List<Integer>> solution;

    private List<Integer> curSolution;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        solution = new ArrayList<List<Integer>>();
        curSolution = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0); 
        return solution;
    }

    private void backTrack(int[] candidates, int target, int lastIdx) {
        if (target == 0) {
            solution.add(new ArrayList<Integer>(curSolution));
        }
        else if (target < 0) {
            return;
        }
        else {
            int i = lastIdx;
            while (i < candidates.length) {
                int candidate = candidates[i];
                curSolution.add(candidate);
                backTrack(candidates, target - candidate, i);
                curSolution.remove(curSolution.size() - 1);
                while (i < candidates.length && candidates[i] == candidate) {
                    i++;
                }
            }
        }
    }
}
