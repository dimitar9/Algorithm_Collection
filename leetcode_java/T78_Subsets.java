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


//my solution
public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int retn = (int) Math.pow(2, S.length);
        Arrays.sort(S);
        List<Integer> empty = new ArrayList<Integer>();
        ret.add(empty);
        for(int i = 1; i< retn; i++){
            ret.add(getList(i, S));
        }
        return ret;
    }
    List<Integer> getList(int k , int[] S){
        List<Integer> l = new ArrayList<Integer>();
        int i = 0;
        int len = S.length;
        while((k  > 0) &&(i < len)){
            if((k & 1) == 1) {
                l.add(S[i]);
               
            }
            i++;
            k = k >>> 1;
        } 
        return l;
    }
}
