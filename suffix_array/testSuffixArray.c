#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <ctype.h>

#include "suffixArray.h"

/* pretty-print a char */
static void
putcharNice(int c)
{
    if(c == '\\') {
        printf("\\\\");
    } else if(isprint(c)) {
        putchar(c);
    } else {
        printf("\\x%02x", c);
    }
}

/* like puts, but stops after bound many chars */
static void
putsBounded(const char *s, size_t bound)
{
    size_t i;

    for(i = 0; i < bound && s[i]; i++) {
        putcharNice(s[i]);
    }

    putchar('\n');
}

#define INITIAL_BUFFER_SIZE (512)

/* read all of stdin as a string */
char *
getInput(void)
{
    char *buffer;
    size_t top;
    size_t size;
    int c;

    size = INITIAL_BUFFER_SIZE;
    top = 0;

    buffer = malloc(size);
    assert(buffer);

    while((c = getchar()) != EOF) {
        if(top >= size-1) {
            size *= 2;
            buffer = realloc(buffer, size);
            assert(buffer);
        }

        buffer[top++] = c;
    }

    buffer[top++] = '\0';

    buffer = realloc(buffer, top);
    assert(buffer);

    return buffer;
}

int
main(int argc, char **argv)
{
    char *buffer;
    SuffixArray sa;
    size_t first;
    size_t count;
    size_t i;
    size_t context;
    char *bwt;
    char *ibwt;

    if(argc != 2) {
        fprintf(stderr, "Usage: %s substring < file\n", argv[0]);
        return 1;
    }

    buffer = getInput();

    sa = suffixArrayCreate(buffer);

    count = suffixArraySearch(sa, argv[1], &first);

    context = 2*strlen(argv[1]);

    printf("Count: %zu\n", count);

    for(i = first; i < first + count; i++) {
        putsBounded(sa->suffix[i], context);
    }

    bwt = suffixArrayBWT(sa);

    for(i = 0; i < sa->n; i++) {
        putcharNice(bwt[i]);
    }
    putchar('\n');

    ibwt = inverseBWT(sa->n, bwt);

    puts(ibwt);

    free(ibwt);
    free(bwt);
    suffixArrayDestroy(sa);
    free(buffer);

    return 0;
}
