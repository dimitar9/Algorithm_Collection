CC=gcc
CFLAGS=-g3 -Wall

all: testSuffixArray

test: all
	/bin/echo -n This_is_a_test_stuff_which_may_contains_abra_wow | ./testSuffixArray abra

testSuffixArray: testSuffixArray.o suffixArray.o
	$(CC) $(CFLAGS) -o $@ $^

testSuffixArray.o suffixArray.o: suffixArray.h

clean:
	$(RM) testSuffixArray *.o

