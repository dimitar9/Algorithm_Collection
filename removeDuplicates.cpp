int removeDuplicates(int A[], int n) {
// Start typing your C/C++ solution below
// DO NOT write int main() function
int i=0;
int j;
if (n<=1) return n;
 
for (j=1;j<n;j++)
{
if (A[j] != A[i])
{
A[++i]=A[j];
}
}
return i+1;
}
