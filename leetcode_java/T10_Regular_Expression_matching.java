//c++ reference.
/*
class Solution {
    public:
    bool matchFirst(const char *s, const char *p){
        return (*p == *s || (*p == '.' && *s != '\0'));
    }

bool isMatch(const char *s, const char *p) {
    if (*p == '\0') return *s == '\0';  //empty

    if (*(p + 1) != '*') {//without *
        if(!matchFirst(s,p)) return false;
        return isMatch(s + 1, p + 1);
    } else { //next: with a *
        if(isMatch(s, p + 2)) return true;    //try the length of 0
        while ( matchFirst(s,p) )       //try all possible lengths 
            if (isMatch(++s, p + 2))return true;
    }
}
};

*/
