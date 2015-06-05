

public class T97 {
	 public static  boolean isInterleave(String S1, String S2, String S3) {
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
		 
		 
		 for(int i = 0; i < s1.length+1; i++) {
			 for(int j=0; j < s2.length+1; j++ ){
				 System.out.printf("%b\t",table[i][j]);
				 
			 }
			 System.out.println();
		 } 
		 //
//		 true	false	
//		 true	true	
//		 false	true	

		 
		 return table[s1.length][s2.length];

		 
		 }
	 
	 public  static  void main(String[] args){
		 String s1 = "ab";
		 String s2 = "c";
		 String s3 = "acb";
		 boolean ret = isInterleave(s1,s2,s3);
	 }
}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



public class Solution {
public boolean isInterleave(String s1, String s2, String s3) {

    if ((s1.length()+s2.length())!=s3.length()) return false;

    boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];

    matrix[0][0] = true;

    for (int i = 1; i < matrix[0].length; i++){
        matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
    }

    for (int i = 1; i < matrix.length; i++){
        matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
    }

    for (int i = 1; i < matrix.length; i++){
        for (int j = 1; j < matrix[0].length; j++){
            matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                    || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
        }
    }

    return matrix[s2.length()][s1.length()];

}
}
