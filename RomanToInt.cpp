class Solution {
public:
    int romanToInt(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
         
        // 4:IV, 9:IX, 40:XL, 90:XC, 400:CD, 900:CM,
        // 1:I, 10:X, 100:C, 1000:M
        int res=0;
        char pre = ' ';
        for(int i=0;i<s.size();i++){
            if (s[i]=='M' && pre!='C') {res+=1000;}
            if (s[i]=='C' && pre!='X') {res+=100;}
            if (s[i]=='X' && pre!='I') {res+=10;}
             
            if (s[i]=='M' && pre=='C') {res+=800;}
            if (s[i]=='C' && pre=='X') {res+=80;}
            if (s[i]=='X' && pre=='I') {res+=8;}
             
            if (s[i]=='I' ) {res+=1;}
             
            if (s[i]=='V' && pre!='I'){res+=5;}
            if (s[i]=='L' && pre!='X'){res+=50;}
            if (s[i]=='D' && pre!='C'){res+=500;}
             
            if (s[i]=='V' && pre=='I'){res+=3;}
            if (s[i]=='L' && pre=='X'){res+=30;}
            if (s[i]=='D' && pre=='C'){res+=300;}
             
            pre = s[i];
             
        }
         
        return res;
    }
};

