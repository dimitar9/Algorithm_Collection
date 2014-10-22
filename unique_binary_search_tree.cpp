class Solution {
public:
    int numTrees(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n==0){return 1;}
        if (n==1){return 1;}
        int sum=0;
        for (int i=1;i<=n;i++){
            sum += numTrees(i-1)*numTrees(n-i);
        }
        return sum;
         
    }
};

/*
这是很有意思的一个题。刚拿到这题的时候，完全不知道从那下手，因为对于BST是否Unique，很难判断。
最后引入了一个条件以后，立即就清晰了，即
*****当数组为 1，2，3，4，.. i，.. n时，基于以下原则的BST建树具有唯一性：
以i为根节点的树，其左子树由[0, i-1]构成， 其右子树由[i+1, n]构成。*****
*/
