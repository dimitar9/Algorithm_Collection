#include <stdio.h>
#include <vector>
#include <algorithm>
using namespace std;
int number_of_ways(int n, int m) {
    
  //  if (n<m)
  //      swap(n,m);
    vector<vector<int> > A (n, vector<int>(m,1));
    for(int i = 1; i < n; i++) {
        for(int j = 1; j < m; j++) {
            A[i][j]  = A[i-1][j] + A[i][j-1];
        }
    }
    return A[n-1][m-1];

}

int main(){
    int ret = number_of_ways(5,5);
    printf("%d",ret);
}
