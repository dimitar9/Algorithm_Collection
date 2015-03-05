public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> solutions = new ArrayList<List<Integer>>();
       
        Arrays.sort(S);
        for(int i = 0; i < (1<<S.length); i++){
            ArrayList<Integer> solution = new ArrayList<Integer>();
            for(int j = 0; j < S.length; j++){
                if(( (1<<j) & i) !=0){
                    solution.add(S[j]);
                }
            }
            solutions.add(solution);
        }
        return solutions;
    }
}
