
/*
leetcode Question 29: Edit Distance
Edit Distance
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character
Analysis:
At the first glance, we might think this is a DFS problem, but if we see it is hard to find a quick DFS thought and the problem requires some optimal result (here is the minimum), DP is a good direction to consider.
Actually this is a classic DP problem:
The state is:   table[i][j]=minimum number steps convert word1[1:i] to word2[1:j] (here assume string starts from 1).

The optimal function is:  table[i+1][j+1] = min [table[i][j]+1 or 0 (+1 if word1[i+1]==word2[j+1], else +0),   table[i][j+1]+1, table[i+1][j]+1 ].

Initialization:
table[0][i] = i  i=1:|word1|          here 0 means "", any string convert to "" needs the length of string
table[j][0] = j  i=1:|word2|
table[0][0]=0    "" convert to  "" need 0 steps.
*/

class Solution {
public:
    int minDistance(string word1, string word2) {
        int s1 = word1.size();
        int s2 = word2.size();
        if (s1==0){return s2;}
        if (s2==0){return s1;}
        vector<vector<int> > w(s1+1,vector<int>(s2+1,0));
        for (int i=0;i<=s1;i++){w[i][0]=i;}
        for (int i=0;i<=s2;i++){w[0][i]=i;}
         
        for (int i=1;i<=s1;i++){
            for (int j=1;j<=s2;j++){
                w[i][j]=min(w[i-1][j]+1,w[i][j-1]+1);
                if (word1[i-1]==word2[j-1]){
                    w[i][j]=min(w[i-1][j-1],w[i][j]);
                }else{
                    w[i][j]=min(w[i-1][j-1]+1,w[i][j]);
                }
            }
        }
        return w[s1][s2];
    }
};
