public class Solution {
    List<List<String>> ret = new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        List<String> cur = new ArrayList<String>();
        gen(s,cur, 0);
        return ret;
    }
    
    void gen(String s, List<String> cur, int st){
        if(st>=s.length()){
           ret.add(cur);
           return;
        }
        for(int i = st; i < s.length(); i++){
            if(isValid(s,st, i)){
                cur.add(s.substring(st,i+1));
                gen(s,new ArrayList(cur), i+1);//This "new" is so important. Without it, the result is wrong.
                cur.remove(cur.size()-1);
            }
        }
    }
    boolean isValid(String s, int st, int end){
        while(st <=end){
            if(s.charAt(st)!= s.charAt(end)) return false;
            st++; end--;
        }
        return true;
    }
}
