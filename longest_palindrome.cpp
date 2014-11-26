#include <string>
#include <iostream>
using namespace std;

int expandPalin(string s, int i, int j, int len){
    int L=i;
    int R = j;
    while( L >=0 && R< len && s[L]==s[R]) {
        L--;
        R++;
    }
    return R-L-1;
}

string longestPalindrome(string s) {
    int maxlen = 0;
    string ret;
    int st,end = 0;
    for(int i = 0; i < s.size(); i ++){
        int lena = expandPalin(s, i,i,s.size());
        int lenb = expandPalin(s,i,i+1,s.size());
        int len = max(lena,lenb);
        if(len > maxlen)
        {
            st = i-(len-1)/2; 
            end = i+len/2;
            maxlen = len;
        }
    }
    return s.substr(st, end-st+1);
}
    


int main(){
    string s = "ccc";
    string ret = longestPalindrome(s);
    cout << ret << endl;
    return 0;
}