/*leetcode Question 102: Sqrt(x)
Sqrt(x)

Implement int sqrt(int x).
Compute and return the square root of x.

Analysis:
According to Newton's Method(http://en.wikipedia.org/wiki/Newton's_method), we can use
 x_(k+1)=1/2(x_k+n/(x_k))
to get the sqrt(x).
*/

class Solution {
public:
    int sqrt(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (x==0) {return 0;}
        if (x==1) {return 1;}
       
        double x0 = 1;
        double x1;
        while (true){
            x1 = (x0+ x/x0)/2;
            if (abs(x1-x0)<1){return x1;}
            x0=x1;
        }
         
    }
};




class Solution {
public:
    int sqrt(int x) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        long long high = x;
        long long low = 0;
        if (x<=0) {return 0;}
        if (x==1) {return 1;}
        while (high-low >1){
            long long mid = low + (high-low)/2;
            if (mid*mid<=x){low = mid;}
            else {high = mid;}
        }
        return low;
    }
};
