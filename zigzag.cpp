class Solution {
public:
    string convert(string s, int nRows) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function    
        if(nRows <= 1) return s;
        string ret;
        int zigsize = 2 * nRows - 2;
        for(int i = 0; i < nRows; ++i) {
            for(int base = i; ;base += zigsize) {
                if(base >= s.size())
                    break;
                ret.append(1,s[base]);
                if(i > 0 && i < nRows - 1) {
                    //middle need add ziggggging char
                    int ti = base + zigsize - 2 * i;
                    if(ti < s.size())
                        ret.append(1,s[ti]);
                }
            }
        }
        return ret;
    }
};


/*
直观的算法，写一下不同行数下的例子就能找到规律了。

 nRows = 2
0 2 4 6 ...
1 3 5 7

 nRows = 3
0   4   8  ...
1 3 5 7 9
2   6   10

 nRows = 4
0     6       12 ...
1   5 7    11
2 4   8 10  
3     9

先计算一下每一个zig包含的字符个数，实际上是zigSize = nRows + nRows – 2
然后一行一行的加s中的特定元素就行。
第一行和最后一行都只需要加一个字符，每一个zig，而且在s中的index间隔是zigSize。
中间每一行需要添加两个字符到结果中去。第一个字符同上；第二个字符和前面添加这个字符在s上的inde相差正好是zigSize – 2*ir。ir是行index。



*/
