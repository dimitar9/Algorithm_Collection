class Solution {
public:
    void solveSudoku(vector<vector<char> > &board) {
        if(board.size()<9 || board[0].size()<9) return;
        bool findSol = solSudoku(board, 0, 0);
    }
    
    bool solSudoku(vector<vector<char>> &board, int irow, int icol) {
        if(irow==9) return true;
        
        int irow2, icol2;
        if(icol==8) {
            irow2 = irow+1;
            icol2 = 0;
        }
        else {
            irow2 = irow;
            icol2 = icol+1;
        }
        
        if(board[irow][icol]!='.') {
            if(!isValid(board, irow, icol)) return false;
            return solSudoku(board, irow2, icol2);
        }
        
        for(int i=1; i<=9; i++) {
            board[irow][icol] = '0'+i;
            if(isValid(board, irow, icol) && solSudoku(board, irow2, icol2)) return true;
        }
        
        // reset grid 
        board[irow][icol] = '.';
        return false;
    }
    
    bool isValid(vector<vector<char>> &board, int irow, int icol) {
        char val = board[irow][icol];
        if(val-'0'<1 || val-'0'>9) return false;
        
        // check row & col
        for(int i=0; i<9; i++) {
            if(board[irow][i]==val && i!=icol) return false;
            if(board[i][icol]==val && i!=irow) return false;
        }
        
        //check 3x3 box
        int irow0 = irow/3*3;
        int icol0 = icol/3*3;
        for(int i=irow0; i<irow0+3; i++) {
            for(int j=icol0; j<icol0+3; j++) {
                if(board[i][j]==val && (i!=irow || j!=icol)) return false;
            }
        }
        
        return true;
    }
};
