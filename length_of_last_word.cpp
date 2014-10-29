class Solution {
public:
    int lengthOfLastWord(const char *s) {
        int len = strlen(s);
        if (!len) return 0;
        
        int ret = 0;
       
        for(int i=len-1;i>=0;i--){
            if (s[i] != ' ')
                ret++;
            else if (ret >0)
                return ret;
        }
        return ret;
        
    }
};
