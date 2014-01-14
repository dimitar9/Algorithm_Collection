Analysis:
As there is no need to consider float number, what we need concern here is
(1) "+" and "-"
(2) The boundary INT_MAX and INT_MIN
(3) Eliminate the spaces before.
(4) Meet non-digit after digit then return.

Code(Updated 201309):

class Solution {
public:
    int atoi(const char *str) {
    // Start typing your C/C++ solution below
    // DO NOT write int main() function
        assert(str != NULL);
        if (*str == '\0') return 0;

        const char *p = str;
        int minus = 1;

        //skip spaces
        while (*p == ' ') p++;

        //get sign
        if (*p == '-') {
            minus = -1;
            p++;
        } else if (*p == '+') {
            minus = 1;
            p++;
        }

        //convert numbers
        int num = 0;
        while (isdigit(*p)) {
            if ( ((num == 214748364) && (((*p) - '0') > 7)) || (num > 214748364) ) {
                return (minus > 0) ? INT_MAX : INT_MIN;
            }
            num = 10*num + ((*p) - '0');
            p++;
        }

        return (minus > 0) ? num : -num;        
    }
};
