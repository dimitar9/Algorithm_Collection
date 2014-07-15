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

my version:

class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) {
        if (strs.size() < 1) return "";
        if (strs.size() == 1) return strs[0];
        int i =0; int j = 0;bool b_flag = false;
       
        for(i=0; (i<strs[0].length()) && (b_flag == false);i++){
            char a = strs[0][i];
            for(j=1;j<strs.size();j++){
                if(strs[j][i] != a){
                    b_flag = true; //last run was a mismatch. need to minus i.
                    break;
                }
            }
        }
        if (b_flag) i--;//last run was a mismatch. need to minus i.
        return strs[0].substr(0,i);
    }
};
