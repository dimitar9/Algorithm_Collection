class Solution {
public:
 
    bool se(int st, int ed, int row, int col, int target, vector<vector<int> > &matrix){
        if (ed<st){return false;}
        int mid = st+ (ed-st)/2;
        int r = floor(mid/col);
        int c = mid%col;
        if (target==matrix[r][c]){return true;}               
        if (target>matrix[r][c]) {
            return se(mid+1,ed,row,col,target,matrix);
        }else{
            return se(st,mid-1,row,col,target,matrix);
        }
    }
     
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int row = matrix.size();
        if (row==0) {return false;}
        int col = matrix[0].size();
        if (col==0) {return true;}
        int tol = row*col;
        return se(0,tol-1,row,col, target, matrix);
          
    }
};
