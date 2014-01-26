class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (strs.empty()){return "";}
        string str = strs[0];
        int i;
        for (i=0;i<str.size();i++){
            bool fl=true;
            for (int j=0;j<strs.size();j++){
                if (strs[j][i]!=str[i]) {fl=false; break;}
            }
            if (fl==false){return str.substr(0,i);}
        }
        return str.substr(0,i);
    }
};
