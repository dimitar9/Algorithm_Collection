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

//solution 2. Use this one

// My idea is to generate the sequence iteratively. 
// For example, when n=3, we can get the result based
// on n=2. 00,01,11,10 -> (000,001,011,010 ) (110,111,101,100).
// The middle two numbers only differ at their highest bit,
// while the rest numbers of part two are exactly symmetric
// of part one. It is easy to see its correctness. Code is simple:

public List<Integer> grayCode(int n) {
    List<Integer> rs=new ArrayList<Integer>();
    rs.add(0);
    for(int i=0;i<n;i++){
        int size=rs.size();
        for(int k=size-1;k>=0;k--)
            rs.add(rs.get(k) | 1<<i);
    }
    return rs;
}

