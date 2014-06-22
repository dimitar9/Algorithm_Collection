class Solution {
public:
    bool isPalindrome(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (s.size()==0)   {return true;}
         
        int st = 0;
        int ed = s.size()-1;
         
        while (st<ed){
            if (isalnum(s[st])==false){st++; continue;}
            if (isalnum(s[ed])==false){ed--; continue;}
             
            if (tolower(s[ed])!=tolower(s[st])){
                return false;
            }else{
                st++;
                ed--;
            }
        }
         
        return true;
    }
};
