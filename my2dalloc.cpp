#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>



int** My2DAlloc1(int rows, int cols){
    int header = rows * sizeof(int*);
    int data = rows * cols * sizeof(int);
    int **arr = (int**)malloc(header + data);
    int *buf = (int*)(arr + rows);
    for(int i=0; i<rows; ++i)
        arr[i] = buf + i * cols;
    return arr;
}

int main()
{
    int** a/*[3][5]*/ = My2DAlloc1(3,5);
    a[0][1] = 1;
    a[2][0] = 2;
    printf ("%d, %d", a[0][1], a[2][0]);
}
