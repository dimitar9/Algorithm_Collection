// dot not need to handle negative because -43 % 40 = -3;
//leetcode solution:
class Solution {
public:
    int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            // handle overflow/underflow
            if (abs(ret) > 214748364) 
            {
                return 0;
            }
            ret = ret * 10 + x % 10;
            x /= 10;
        }
        return ret;
    }
};


//java version:
public class Solution {
    public int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            if (Math.abs(ret) > Integer.MAX_VALUE/10) {
                return 0;
            }
            ret = ret * 10 + x % 10;
            x = x/10;
        }
        return ret;
    }
};

//python version

class Solution:
    # @return an integer
    def reverse(self, x):
        answer = 0
        sign = 1 if x > 0 else -1
        x = abs(x)
        while x > 0:
            if answer > 214748364:
                return 0
            answer = answer * 10 + x % 10
            x /= 10
        return sign*answer