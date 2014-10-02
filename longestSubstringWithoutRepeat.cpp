class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if(s.size()==0){return 0;}
        if(s.size()==1){return 1;}
        int i=0;
        int j=0;
        int maxl = 0;
        map<char,bool> table;
        while ( (i<s.size()) && (j<s.size()) ){
            if (table[s[j]]==false){
                table[s[j]]=true;
                maxl = max(maxl,j-i+1);
                j++;
            }else if (table[s[j]]==true){
                maxl = max(maxl,j-i);
                table[s[i]]=false;
                i++;
            }
        }
        return maxl;
    }
};