#include <stdlib.h>
#include <assert.h>
#include <string.h>
#include <limits.h>

#include "suffixArray.h"

static int
saCompare(const void *s1, const void *s2)
{
    return strcmp(*((const char **) s1), *((const char **) s2));
}

SuffixArray
suffixArrayCreate(const char *s)
{
    size_t i;
    SuffixArray sa;

    sa = malloc(sizeof(*sa));
    assert(sa);

    sa->n = strlen(s) + 1;
    sa->string = s;

    sa->suffix = malloc(sizeof(*sa->suffix) * sa->n);
    assert(sa->suffix);

    /* construct array of pointers to suffixes */
    for(i = 0; i < sa->n; i++) {
        sa->suffix[i] = s+i;
    }

    /* this could be a lot more efficient */
    qsort(sa->suffix, sa->n, sizeof(*sa->suffix), saCompare);

    return sa;
}

void
suffixArrayDestroy(SuffixArray sa)
{
    free(sa->suffix);
    free(sa);
}

size_t
suffixArraySearch(SuffixArray sa, const char *substring, size_t *first)
{
    size_t lo;
    size_t hi;
    size_t mid;
    size_t len;
    int cmp;

    len = strlen(substring);

    /* invariant: suffix[lo] <= substring < suffix[hi] */
    lo = 0;
    hi = sa->n;

    while(lo + 1 < hi) {
        mid = (lo+hi)/2;
        cmp = strncmp(sa->suffix[mid], substring, len);

        if(cmp == 0) {
            /* we have a winner */
            /* search backwards and forwards for first and last */
            for(lo = mid; lo > 0 && strncmp(sa->suffix[lo-1], substring, len) == 0; lo--);
            for(hi = mid; hi < sa->n && strncmp(sa->suffix[hi+1], substring, len) == 0; hi++);

            if(first) {
                *first = lo;
            }

            return hi - lo + 1;
        } else if(cmp < 0) {
            lo = mid;
        } else {
            hi = mid;
        }
    }

    return 0;
}

char *
suffixArrayBWT(SuffixArray sa)
{
    char *bwt;
    size_t i;

    bwt = malloc(sa->n);
    assert(bwt);

    for(i = 0; i < sa->n; i++) {
        if(sa->suffix[i] == sa->string) {
            /* wraps around to nul */
            bwt[i] = '\0';
        } else {
            bwt[i] = sa->suffix[i][-1];
        }
    }

    return bwt;
}

char *
inverseBWT(size_t len, const char *s)
{
    /* basic trick: stable sort of s gives successor indices */
    /* then we just thread through starting from the nul */

    size_t *successor;
    int c;
    size_t count[UCHAR_MAX+1];
    size_t offset[UCHAR_MAX+1];
    size_t i;
    char *ret;
    size_t thread;

    successor = malloc(sizeof(*successor) * len);
    assert(successor);

    /* counting sort */
    for(c = 0; c <= UCHAR_MAX; c++) {
        count[c] = 0;
    }

    for(i = 0; i < len; i++) {
        count[(unsigned char) s[i]]++;
    }

    offset[0] = 0;

    for(c = 1; c <= UCHAR_MAX; c++) {
        offset[c] = offset[c-1] + count[c-1];
    }

    for(i = 0; i < len; i++) {
        successor[offset[(unsigned char) s[i]]++] = i;
    }

    /* find the nul */
    for(thread = 0; s[thread]; thread++);

    /* thread the result */
    ret = malloc(len);
    assert(ret);

    for(i = 0, thread = successor[thread]; i < len; i++, thread = successor[thread]) {
        ret[i] = s[thread];
    }

    return ret;
}
