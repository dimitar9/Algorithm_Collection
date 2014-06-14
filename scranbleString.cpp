1:       bool isScramble(string s1, string s2) {   
2:            // Start typing your C/C++ solution below   
3:            // DO NOT write int main() function   
4:            if(s1.size() != s2.size()) return false;   
5:            int A[26];   
6:            memset(A,0,26*sizeof(A[0]));   
7:            for(int i =0;i<s1.size(); i++)   
8:            {   
9:                 A[s1[i]-'a']++;   
10:            }   
11:            for(int i =0;i<s2.size(); i++)   
12:            {   
13:                 A[s2[i]-'a']--;   
14:            }   
15:            for(int i =0;i<26; i++)   
16:            {   
17:                 if(A[i] !=0)   
18:                 return false;   
19:            }   
20:            if(s1.size() ==1 && s2.size() ==1) return true;   
21:            for(int i =1; i< s1.size(); i++)   
22:            {   
23:                 bool result= isScramble(s1.substr(0, i), s2.substr(0, i))   
24:                      && isScramble(s1.substr(i, s1.size()-i), s2.substr(i, s1.size()-i));   
25:                 result = result || (isScramble(s1.substr(0, i), s2.substr(s2.size() - i, i))   
26:                      && isScramble(s1.substr(i, s1.size()-i), s2.substr(0, s1.size()-i)));   
27:                 if(result) return true;   
28:            }   
29:            return false;   
30:       }   
