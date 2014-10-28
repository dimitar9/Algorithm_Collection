class Solution {
public:
    vector<vector<int> > generateMatrix(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        vector<vector<int> > res(n,vector<int>(n,0));
        if (n==0){return res;}
        int i=1;
        int x = 0;
        int y = 0;
        res[0][0]=i++;
        while (i<=n*n){
            while (y+1<n && res[x][y+1]==0){   // keep going right
                res[x][++y]=i++;
            }
            while (x+1<n && res[x+1][y]==0){   // keep going down
                res[++x][y]=i++;
            }
            while (y-1>=0 && res[x][y-1]==0){  // keep going left
                res[x][--y]=i++;
            }
            while (x-1>=0 && res[x-1][y]==0){  // keep going up
                res[--x][y]=i++;
            }
        }
        return res;
    }
};
