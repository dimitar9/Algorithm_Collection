class Solution {
public:
    int reverse(int x) {
        bool pos = x > 0 ? true:false;
        x = x < 0? x * (-1) : x; 
        int ret = 0;
        while(x > 0){
            ret = ret  * 10 + x % 10;
            x = x / 10;
        }
        if (!pos){
            ret = 0 - ret;
        }
        return ret;

    }
};
