public class Solution {
    public String addBinary(String a, String b) {
        String res = "";
        int carryOver = 0;
        for(int i = a.length()-1, j = b.length()-1; i>=0 || j>=0; i--, j--){
            int ai = ((i<0)?0:Integer.parseInt(a.charAt(i)+""));
            int bi = ((j<0)?0:Integer.parseInt(b.charAt(j)+""));
            res = ((ai ^ bi)^carryOver) + res;
            carryOver = ((ai+bi+carryOver)>1)?1:0;
        }
        if(carryOver==1)
            res = 1+res;
        return res;
    }
}
