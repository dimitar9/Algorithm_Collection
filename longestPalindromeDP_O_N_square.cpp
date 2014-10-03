string longestPalindromeDP(string s) {
  int n = s.length();
  int longestBegin = 0;
  int maxLen = 1;
  bool table[1000][1000] = {false};
  for (int i = 0; i < n; i++) {
    table[i][i] = true;
  }
  for (int i = 0; i < n-1; i++) {
    if (s[i] == s[i+1]) {
      table[i][i+1] = true;
      longestBegin = i;
      maxLen = 2;
    }
  }
  for (int len = 3; len <= n; len++) {
    for (int i = 0; i < n-len+1; i++) {
      int j = i+len-1;
      if (s[i] == s[j] && table[i+1][j-1]) {
        table[i][j] = true;
        longestBegin = i;
        maxLen = len;
      }
    }
  }
  return s.substr(longestBegin, maxLen);
}


1:       string longestPalindrome(string s) {  
2:            int len = s.size();  
3:            int P[len][len];  //bool table[1000][1000] = {false}; 
// or vector<vector<int> > table (n, vector<int>)(n,0);
4:            memset(P, 0, len*len*sizeof(int));  
5:            int maxL=0, start=0, end=0;  
6:            for(int i =0; i< s.size(); i++)  
7:            {  
8:                 for(int j =0; j<i; j++)  
9:                 {  
10:                      P[j][i] = (s[j] == s[i] && (i-j<2 || P[j+1][i-1]));  
11:                      if(P[j][i] && maxL < (i-j+1))  
12:                      {  
13:                           maxL = i-j+1;  
14:                           start = j;  
15:                           end = i;  
16:                      }  
17:                 }  
18:                 P[i][i] =1;  
19:            }  
20:            return s.substr(start, end-start +1);  
21:       } 
