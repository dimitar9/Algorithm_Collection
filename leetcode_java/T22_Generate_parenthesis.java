
public class Solution {
    
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        String s = "";
        int l = 0;
        int r = 0;
       
        gen( s, 0, 0, n,ret);
        return ret;
        
    }
    public void gen( String s, int l, int r, int N,List<String> ret){
        if ((l+r)== N*2) { ret.add(s);return;}
        if(l>=r && l <N){
            s = s+"(";
            gen( s, l+1, r,N, ret);
            s = s.substring(0, s.length()-1);
        } 
        if(l > r){
            s = s+")";
            gen( s, l, r+1,N, ret);
            s = s.substring(0, s.length()-1);
        }
    }
}
