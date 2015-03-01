//c++ reference.
/*
class Solution {
    public:
    bool matchFirst(const char *s, const char *p){
        return (*p == *s || (*p == '.' && *s != '\0'));
    }

bool isMatch(const char *s, const char *p) {
    if (*p == '\0') return *s == '\0';  //empty

    if (*(p + 1) != '*') {//without *
        if(!matchFirst(s,p)) return false;
        return isMatch(s + 1, p + 1);
    } else { //next: with a *
        if(isMatch(s, p + 2)) return true;    //try the length of 0
        while ( matchFirst(s,p) )       //try all possible lengths 
            if (isMatch(++s, p + 2))return true;
    }
}
};

*/

public class T10 {

	static boolean   matchFirst(String s, String p){
		System.out.println("in matchFirst: s is "+s+",p is: "+p+";");
		System.out.println("s is empty "+ s.isEmpty());
		System.out.println("p is empty "+ p.isEmpty());
        if(s.isEmpty() ^ p.isEmpty()) return false;
        if(s.isEmpty() && p.isEmpty()) return true;
        return ( s.charAt(0)==p.charAt(0) || p.charAt(0)=='.' );
    }
    public static boolean isMatch(String s, String p) {
    	if (p.isEmpty() )return (s.isEmpty());
       

        
        if(p.length()==1 ||  p.charAt(1)!='*') {
            if(!matchFirst(s,p)) return false;
            return isMatch(s.substring(1), p.substring(1));
        } else {
        	
            if (isMatch(s, p.substring(2))) return true;
            while(true){
                if(isMatch(s, p.substring(2))) return true;
            	if(!matchFirst(s, p)) break;
                s=s.substring(1);
            }
        }
        return false;
    }

    
    
    public static void main(String[] args){
    	String s = "aaa";
    	String p = "ab*a";
    	boolean ret = isMatch(s, p);
    	System.out.println(ret);
    }
}
