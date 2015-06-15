public class Solution {
    public int divide(int dividend, int divisor)
    {
        if (divisor == 0)
        {
            return Integer.MAX_VALUE;
        }
        else if (divisor == 1)
        {
            return dividend;
        }
        else if (divisor == -1)
        {
            return (dividend == Integer.MIN_VALUE) ? Integer.MAX_VALUE : -dividend;
        }
        else
        {
            final boolean negative = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);

            long ldividend = Math.abs((long) dividend);
            final long ldivisor = Math.abs((long) divisor);
            int result = 0;

            for (int bit = Integer.SIZE - 1; bit >= 0 && ldividend >= ldivisor; --bit)
            {
                if (ldividend >= (ldivisor << bit))
                {
                    ldividend -= ldivisor << bit;
                    result |= 1 << bit;
                }
            }

            return negative ? -result : result;
        }
    }
}



//c++ consise solution:
class Solution {
public:
    int divide(int dividend, int divisor) {
    /******* handling the case of overflow *******/
    if(divisor == 1)
        return dividend;
    if(dividend == INT_MIN && abs(divisor) == 1)
        return INT_MAX;
    /*********************************************/

    int sign = (dividend > 0 ^ divisor > 0) ? -1 : 1;

    long ans = 0;
    long end = abs((long)dividend);
    long sor = abs((long)divisor);

    while(end >= sor) {
        long temp  = sor;
        long power = 1;
        while((temp << 1) < end) {
            power <<= 1;
            temp  <<= 1;
        }
        ans += power;
        end -= temp;
    }
    return sign * ans;
}
};
