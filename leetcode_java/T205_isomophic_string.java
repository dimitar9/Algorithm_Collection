public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256]; 
        int[] m2 = new int[256];  
        Arrays.fill(m1,-1);
        Arrays.fill(m2,-1);
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i ;
            m2[t.charAt(i)] = i ;
        }
        return true;
    }
    
      
}
