#include <iostream>
#include <cmath>
using namespace std;
int divide(int divident, int divisor)
{
    int sign = 1;
    if(divident < 0) sign = -sign;
    if(divisor < 0) sign = -sign;

    unsigned long long var1 = abs((long long) divident);
    unsigned long long var2 = abs ((long long ) divisor);

    unsigned long c = 1;

    while (var1 < var2)
    {
        var2 = var2 << 1;
        c = c << 1;
    }

    int ret = 0;
    while ( var1 >= (abs((long long ) divisor))) {
        while(var1 >= var2 ){
            var1 -= var2;
            ret = ret + c;
        }
        var2 = var2 >> 1;
        c = c >> 1;
    }
   // return sign * ret;
   if (sign == -1)
       return 0-ret;
   else
       return ret;
}

int main() {
    int a = 13;
    int b = 3;
    int c = divide(a,b);
    cout << c << endl;
}
