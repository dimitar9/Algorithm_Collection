#include <iostream>
using namespace std;

const int INPUT_SIZE = 10;

// A simple print function
void print(int * input)
{
    for ( int i = 0; i < INPUT_SIZE; i++ )
        cout << input[i] << " ";
    cout << endl;
}

// The partition function
int partition(int* input, int p, int r)
{
    cout<< "partition" << p << r << endl;
    int pivot = input[r];
    cout << "pivot is " << pivot << "r is " << r << endl;
    while ( p < r )
    {
        while ( input[p] < pivot )
            p++;

        while ( input[r] > pivot )
            r--;

        if ( input[p] == input[r] )
            p++;
        else if ( p < r )
        {
            int tmp = input[p];
            input[p] = input[r];
            input[r] = tmp;
        }
    }

    print(input);
    cout<< "r " <<  r << endl;
    return r;
}

// The quicksort recursive function
void quicksort(int* input, int p, int r)
{
    if ( p < r )
    {
        int j = partition(input, p, r);   
        cout << "j is " << j << endl;
        quicksort(input, p, j-1);
        quicksort(input, j+1, r);
    }
}

int main()
{
    int input[INPUT_SIZE] = {10,9,8,7,6,5,4,3,2,1};
    cout << "Input: ";
    print(input);
    quicksort(input, 0, 9);
    cout << "Output: ";
    print(input);
    return 0;
}
