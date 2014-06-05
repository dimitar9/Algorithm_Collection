class Solution {
public:
 
    //del the front and end spaces
    string delspace(const char* s){
        int i=0;
        while (s[i]==' '){
            i++;
        }
        int j=strlen(s)-1;
        while (s[j]==' '){
            j--;
        }
        string res="";
        for (int k=i;k<=j;k++){
            res = res+s[k];
        }
        return res;
    }
     
     
    bool valid(string &s){
        int i=0;
        bool e =false; // check if 'e' exists
        bool dot=false; // check if '.' exists
        bool dig =false;
         
        while (i<s.size()-1){
            if (i==0){ // a number can start with +, -, .
                if (s[i]<'0' || s[i]>'9'){ // if is 0-9 continue
                    if (s[i]=='+' || s[i]=='-' || s[i]=='.'){
                        if (s.size()==1){return false;} // only +, - , . is not a number
                        if (s[i]=='.'){dot=true;}
                    }
                    else {return false;}
                }else{dig=true;}
                i++;continue;
            }
            if (i>0){
                switch (s[i]){
                    case 'e': // e cannot follow +,-
                        if ( e==false && s[i-1]!='+' && s[i-1]!='-' && dig && i!=s.size()-1) {
                            e = true;
                        }else{
                            return false;
                        }
                        break;
                   case 'E': // e cannot follow +,-
                        if ( e==false && s[i-1]!='+' && s[i-1]!='-' && dig && i!=s.size()-1) {
                            e = true;
                        }else{
                            return false;
                        }
                        break;
                   case '+': // + can only occur before e
                        if (s[i-1]=='e' || s[i-1]=='E'){}else{return false;}
                        break;
                   case '-': // - can only occur before e
                        if (s[i-1]=='e' || s[i-1]=='E'){}else{return false;}
                        break;
                   case '.': // . can only occur once and cannot occure after e
                        if (dot==false && e==false){dot=true;}else{return false;}
                        break;
                   default:  // only 0-9 can be valid numbers
                        if (s[i]<'0'||s[i]>'9'){return false;}
                        else{dig = true;}
                        break;
            }
                i++;continue;
            }
        }
         
        //last dig can only be 0-9, or ., when it is . there is no . and e before
        if (s[s.size()-1]>='0' && s[s.size()-1]<='9'){return true;}
        if (s[s.size()-1]=='.' && !dot && !e && s[s.size()-2]>='0' && s[s.size()-1]<='9') {return true;}       
        return false;
    }
    bool isNumber(const char *s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        string s1 = delspace(s); //delete spaces in the front and end, don't delete the spaces in middle.
        if (s1.size()==0){return false;} // if null string, return false;
        return valid(s1);
    }
};
         
