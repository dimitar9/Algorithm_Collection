class Solution {
private:
    bool isValid(vector<vector<char> > &board, int x, int y){
        char c = board[x][y];
//判断一列
        for(int i=0; i<9; i++){
            if(x!=i && board[i][y] == c){
                return false;
            }
        }
//判断一行
        for(int j=0; j<9; j++){
            if(y!=j && board[x][j] == c){
                return false;
            }
        }
//判断一个小块
        for(int i=(x/3)*3; i<(x/3+1)*3; i++){
            for(int j=(y/3)*3; j<(y/3+1)*3; j++){
                if((i!=x && j!=y) && board[i][j] == board[x][y]){
                    return false;
                }
            }
        }
        return true;
    }
public:
    bool solveSudoku(vector<vector<char> > &board) {
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(int k=1; k<=9; k++){
                        board[i][j] = '0' + k;
                        if(isValid(board, i, j) && solveSudoku(board)){
                            return true;
                        }
                        board[i][j] = '.'; //一定要记得还原现场
                    }
                    return false;
                }
            }
        }
        return true;
    }
};
