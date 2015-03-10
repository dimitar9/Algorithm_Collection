public class Solution {
	    public List<String> letterCombinations(String digits) {
	   	List<String> ret = new ArrayList<>();
	   	List<String> pad = Arrays.asList("","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz" );
	        String s = "";
	        for(int i = 0 ;i < digits.length(); i++){
	        	gen(s, i, digits.length(), pad, ret, digits);
	        }
	        return ret;
	    }
	    public  void gen(String s, int k, int len, List<String> pad, List<String> ret,String digits){
	    	if(s.length() ==len ){
	    		ret.add(s);
	    		return;
	    	}
	    	if(k>=digits.length()) return;
	    	for(int i = 0; i < pad.get(digits.charAt(k)-'0').length(); i++){
	    		 s += pad.get(digits.charAt(k)-'0').charAt(i);
	    		 gen(s, k+1, len, pad, ret,digits);
	    		 s = s.substring(0,s.length()-1);
	    	}
	    }
}
