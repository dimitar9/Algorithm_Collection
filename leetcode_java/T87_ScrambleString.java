public class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1==null || s2==null || s1.length()!=s2.length()) return false;
        if(s1.equals(s2)) return true;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1, c2)) return false;
        for(int i=1; i<s1.length(); i++)
        {
            if(isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
            if(isScramble(s1.substring(0,i), s2.substring(s2.length()-i)) && isScramble(s1.substring(i), s2.substring(0, s2.length()-i))) return true;
        }
        return false;
    }
}

//dp solution
//A more concise C++ DP version. dp[i][j][l] means whether s2.substr(j,l) is a scrambled string of s1.substr(i,l) or not.

class Solution {
public:
    bool isScramble(string s1, string s2) {
        int len=s1.size();
        bool dp[100][100][100]={false};
        for (int i=len-1;i>=0;i--)
            for (int j=len-1;j>=0;j--) {
                dp[i][j][1]=(s1[i]==s2[j]);
                for (int l=2;i+l<=len && j+l<=len;l++) {
                    for (int n=1;n<l;n++) {
                        dp[i][j][l]|=dp[i][j][n]&&dp[i+n][j+n][l-n];
                        dp[i][j][l]|=dp[i][j+l-n][n]&&dp[i+n][j][l-n];
                    }
                }
            }
        return dp[0][0][len];
    }
}; 

