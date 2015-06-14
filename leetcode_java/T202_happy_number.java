public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        if(n == 1) return true;
        set.add(n);
        while(true){
            int m = 0;
            while(n!=0){
                m += Math.pow(n%10, 2);
                n /= 10;
            }
            if(m == 1) return true;
            if(!set.add(m)){
                return false;
            }else {
                n = m;
            }
        }
        
        
    }
}
