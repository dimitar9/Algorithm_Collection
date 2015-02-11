public class Subsets2 {
    
    public static void main(String[] args) {
        int[] S = {1, 2, 2, 2};
        System.out.println(subsetsWithDup(S));
    }
    
    
    public static ArrayList<ArrayList<Integer>> subsetsWithDup (int[] num) {
        
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
 
        subsetsWithDupHelper(result, list, num, 0);
 
        return result;
    }
 
 
    private static void subsetsWithDupHelper(ArrayList<ArrayList<Integer>> result,
            ArrayList<Integer> list, int[] num, int position) {
        result.add(new ArrayList<Integer>(list));
 
        for (int i = position; i < num.length; i++) {
            if (i != position && num[i] == num[i-1]){
                continue;
            }
            
            list.add(num[i]);
            subsetsWithDupHelper(result, list, num, i+1);
            list.remove(list.size() - 1);
        }
    }
}
