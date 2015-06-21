public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        String str = "";
        str += "(";
        gen(ret, str, 1, n, 1, 0);
        return ret;
        
    }
    
    private void gen(List<String> ret, String str, int k, int n, int l, int r){
        if(str.length()==n*2){
            ret.add(str);
            return;
        } else {
            if(l < n) {
                str += "(";
                gen(ret, str, k+1, n, l+1, r);
                str = str.substring(0, str.length()-1);
            }
            if(l > r ) {
                str += ")";
                gen(ret, str, k+1, n, l, r+1);
                str = str.substring(0, str.length()-1);
            } 
             
        }
        
    }
}
