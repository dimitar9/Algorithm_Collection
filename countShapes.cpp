/* amazon-interview-questions
0
of 0 votes
42
Answers

Count the number of shapes in a given (1/0) matrix. A cluster of consecutive (not diagonal) 1's defines one shape.
eg
1 1 0 0 1
1 0 0 1 0
1 1 0 1 0
0 0 1 0 0

No of shapes = 4*/

# In this solution as soon as we find a 1, we replace
# all the elements in the shape with 2 to avoid double
# counting the 1s.  Otherwise, it's simple iteration. 
def count_shapes(m):
    num_shapes = 0
    for r in range(len(m)):
        for c in range(len(m[0])):
            if m[r][c] == 1:
                fill_shape_with_twos(m, r, c)
                num_shapes += 1
    # restore the original values
    for r in range(len(m)):
        for c in range(len(m[0])):
            m[r][c] = m[r][c] / 2
    return num_shapes

def fill_shape_with_twos(m, r, c):
    m[r][c] = 2
    if r > 0 and m[r-1][c] == 1:
        fill_shape_with_twos(m, r-1, c)
    if r + 1 < len(m) and m[r+1][c] == 1:
        fill_shape_with_twos(m, r+1, c)
    if c > 0 and m[r][c-1] == 1:
        fill_shape_with_twos(m, r, c-1)
    if c + 1 < len(m[0]) and m[r][c+1] == 1:
        fill_shape_with_twos(m, r, c+1)






#include <iostream>
#include <vector>
 
using namespace std;
 
bool inRange(int i, int j, int m, int n){
return i>=0 && i<m && j>=0 && j<n ;
}
 
void dfs(const vector< vector<int> >& v , vector< vector<bool> >& mark, int m, int n, int i, int j){
if(!inRange(i,j,m,n) || mark[i][j])
return;
 
if( v[i][j]==1){
mark[i][j]=true;
dfs(v, mark, m, n, i-1, j);
dfs(v, mark, m, n, i, j-1);
dfs(v, mark, m, n, i+1, j);
dfs(v, mark, m, n, i, j+1);
}	
}
 
 
int getConnectedCount(const vector< vector<int> >& v , int m, int n){
 
int count=0;
vector< vector<bool> > mark(m, vector<bool>(n, false));
for (int i = 0; i < m; ++i){
for(int j=0; j<n; ++j){
if(v[i][j]==1 && !mark[i][j]){
dfs(v, mark,m, n, i, j);
count++;
}	
}
}
return count;
}
 
 
int main(int argc, char const *argv[])
{
vector< vector<int> > a =
{
{1,0,1},
{0,1,0},
{1,1,1}
};
 
vector< vector<int> > b =
{
{1,1,1},
{0,0,1},
{1,1,1}
};
 
 
vector< vector<int> > c =
{
{1,1,1,1,1,1,1,1,1,1,1,1},
{0,0,0,0,0,0,0,0,0,0,0,1},
{1,1,1,0,0,0,0,0,0,0,0,1},
{1,0,0,0,0,0,1,0,0,0,0,1},
{1,0,0,0,0,0,0,0,0,0,0,1},
{1,0,0,0,0,0,0,0,0,0,0,1},
{1,1,1,1,1,1,1,1,1,1,1,1}
};
 
 
 
cout<<getConnectedCount(a,3,3)<<endl;
cout<<getConnectedCount(b,3,3)<<endl;
cout<<getConnectedCount(c,7,12)<<endl;
return 0;
}
