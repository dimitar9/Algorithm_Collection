class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        int dev=1;
        while(x/dev >= 10)
        {
            dev *= 10;
        }
        while(x/dev > 0)
        {
            if((x%10) != (x/dev))
                return false;
            else {
                x /=dev;
                x-=x%10;
            }
        }
        return true;
    }
};
