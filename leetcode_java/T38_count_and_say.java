class Solution {
public:
 
    string cas(string str){
        string str1;
        char ch=str[0];
        int chn=1;
        for(int i = 1; i<=str.size();i++){
            if (str[i]==ch){chn++;}
            else {
                char chr = chn+'0';
                str1 = str1+ chr;
                str1 = str1+ch;
                ch = str[i];
                chn=1;
            }
        }
        return str1;
    }
    string countAndSay(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n==1) {return "1";}
        string str1 = "1";
        string strn;
        for (int i=1; i<n;i++){
            strn = cas(str1);
            str1 = strn;
        }
        return strn;
    }
};
