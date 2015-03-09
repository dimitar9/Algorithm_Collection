public class Solution {
	long gennext(int bi){
		return (bi >>> 1) ^ bi; // This is the key
	}
    public List<Integer> grayCode(int n) {
    	
        List<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < Math.pow(2, n); i++){  // careful about end point. it is pow(2,n) not n
        	ret.add((int) gennext(i));
        }
        
        return ret;
    }
}
