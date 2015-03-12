public class Solution {
public List<List<Integer>> permute(int[] num) {
    List<List<Integer>> lists = new ArrayList<List<Integer>>();
    List<Integer> list = new ArrayList<Integer>();
    backtrack(lists, list, num);
    return lists;
}
public void backtrack(List<List<Integer>> lists, List<Integer> list, int[] num){
    if(list.size() == num.length) {
        lists.add(new ArrayList<Integer>(list));//important, don't forget new
        return;
    }
    for(int i:num){
        if(!list.contains(i)){
            list.add(i);
            backtrack(lists, list, num);
            list.remove(Integer.valueOf(i));
        }
    }
}

}
