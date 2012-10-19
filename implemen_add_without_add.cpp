nclude <stdlib.h> /* atoi() */
#include <stdio.h>  /* (f)printf */
#include <assert.h> /* assert() */

int add(int x, int y) {
        int carry = 0;
            int result = 0;
                int i;

                    for(i = 0; i < 32; ++i) {
                                int a = (x >> i) & 1;
                                        int b = (y >> i) & 1;
                                                result |= ((a ^ b) ^ carry) << i;
                                                        carry = (a & b) | (b & carry) | (carry & a);
                                                            }

                        return result;
}

int negate(int x) {
        return add(~x, 1);
}

int subtract(int x, int y) {
        return add(x, negate(y));
}

int is_even(int n) {
        return !(n & 1);
}

int divide_by_two(int n) {
        return n >> 1;
}

int multiply_by_two(int n) {
        return n << 1;
}

int multiply(int x, int y) {
        int result = 0;

            if(x < 0 && y < 0) {
                        return multiply(negate(x), negate(y));
                            }

                if(x >= 0 && y < 0) {
                            return multiply(y, x);
                                }

                    while(y > 0) {
                                if(is_even(y)) {
                                                x = multiply_by_two(x);
                                                            y = divide_by_two(y);
                                                                    } else {
                                                                                    result = add(result, x);
                                                                                                y = add(y, -1);
                                                                                                        }
                                    }

                        return result;
}

int main(int argc, char **argv) {
        int from = -100, to = 100;
            int i, j;

                for(i = from; i <= to; ++i) {
                            assert(0 - i == negate(i));
                                    assert(((i % 2) == 0) == is_even(i));
                                            assert(i * 2 == multiply_by_two(i));
                                                    if(is_even(i)) {
                                                                    assert(i / 2 == divide_by_two(i));
                                                                            }
                                                        }

                    for(i = from; i <= to; ++i) {
                                for(j = from; j <= to; ++j) {
                                                assert(i + j == add(i, j));
                                                            assert(i - j == subtract(i, j));
                                                                        assert(i * j == multiply(i, j));
                                                                                }
                                    }

                        return 0;
}
