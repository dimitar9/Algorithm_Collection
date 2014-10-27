class Solution {
public:
    bool searchMatrix(vector<vector<int> > &matrix, int target) {
        if(    (matrix.size()==0) || (matrix[0].size()==0) ) return false;
        int st = 0;
        int end = matrix.size() * matrix[0].size() -1;
        
        while(st <= end) { //IMPORTANT DONT FORGET = sign
            int mid = (st+end)/2;
            int midX = mid/matrix[0].size();
            int midY = mid%matrix[0].size();
            if(matrix[midX][midY] == target) return true;
            else if (matrix[midX][midY] <target){
                st = mid+1;
            }else {
                end = mid-1;
            }
        }
        return false;
        
    }
};
