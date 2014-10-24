/*leetcode Question 16: Climbing Stairs

Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


The easiest idea is a Fibonacci number. f(n) = f(n-1) + f(n-2). 
The nth stairs is from either n-1th the stair or the n-2th stair. 
However recursive is time-consuming. We know that recursion can be written in loop, 
the trick here is not construct a length of n array, only three element array is enough.*/



/*DP*/

class Solution {
public:
    int climbStairs(int n) {
    
        if (n<=2) return n;
        int f1=1;
        int f2=2;
        for(int i=3;i<=n;i++){
            f2=f1+f2;
            f1=f2-f1;
        }
        return f2;
        
    }
};




/*recursive*/

class Solution {
public:
    int climbStairs(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n<=2) {return n;}
        else {
            return climbStairs(n-1) + climbStairs(n-2);
        }
    }
};

/*loop*/


class Solution {
public:
    int climbStairs(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int s[3]={0,1,2};
        if (n<=2) {return s[n];}
        int j = 2;
        while (true){
            j++;
            s[(j%3)] = s[((j+1)%3)] + s[((j+2)%3)];
            if (j==n) {return s[j%3];}
        }
    }
};



