public class Solution {
    public boolean isInterleave(String S1, String S2, String S3) {
        if(S3.length() != S1.length() + S2.length()) return false;
        boolean[][] table = new boolean[S1.length()+1][S2.length()+1];
        char[] s1 = S1.toCharArray();
        char[] s2 = S2.toCharArray();
        char[] s3 = S3.toCharArray();
        for(int i = 0; i < s1.length+1; i++){
            for(int j=0; j < s2.length+1; j++ ){
                if(i==0 && j == 0){
                    table[i][j]=true;
                }
                else if (i==0){
                    table[i][j] = (table[i][j-1] && s2[j-1] == s3[i+j-1]);
                } else if(j==0){
                    table[i][j] = (table[i-1][j] && s1[i-1] == s3[i+j-1]);
                } else {
                    table[i][j] = (table[i-1][j] && s1[i-1] == s3[i+j-1] ) || (table[i][j-1] && s2[j-1] == s3[i+j-1] );
                }
            }
        }
        return table[s1.length][s2.length];
    }
}

