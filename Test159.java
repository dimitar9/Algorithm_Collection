import java.util.HashMap;
import java.util.Hashtable;


public class Test159 {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
    	Hashtable<Character,Integer> hm = new Hashtable<Character,Integer>();
        int len = s.length();
        int j = 0;
        int maxlen = 0;
        int curDistinctCount=0;
        for(int i =0; i < len; i++){
            if(hm.get(s.charAt(i))==null || hm.get(s.charAt(i))==0){
                hm.put(s.charAt(i), 1);
                curDistinctCount++;
            } else {
                hm.put(s.charAt(i), hm.get(s.charAt(i))+1);
            }
            if(curDistinctCount<=2){
                maxlen = Math.max(maxlen, i-j+1);
            } else {
                while(j<s.length() && hm.get(s.charAt(j))!=null && hm.get(s.charAt(j))!=1){
                    hm.put(s.charAt(j),hm.get(s.charAt(j))-1);
                    j++;
                } 
                if(j>=len) break;
                hm.put(s.charAt(j),0);
                curDistinctCount--;
                j++;
            }
        }
        return maxlen;
    }
    
    static int sum(int a, int b){
    	int c = a + b;
    	return c;
    }
    public static void main(String[] args) {
    	String s = "aaabc";
    	//int ret =lengthOfLongestSubstringTwoDistinct(s);
    	int result = sum(1,3);
    	System.out.println(result);
    	//System.out.println(ret);
    }
}
