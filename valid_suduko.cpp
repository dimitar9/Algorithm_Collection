class Solution {
public:
    bool isValidSudoku(vector<vector<char> > &board) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        map<char, bool> row;
        map<char, bool> col;
        map<char, bool> block;
         
        for (int i=0;i<9;i++){
            col.clear();
            row.clear();
            for (int j=0;j<9;j++){
                if (board[i][j]!='.'){
                    if (col[board[i][j]]){
                        return false;
                    }else{
                        col[board[i][j]]=true;
                    } 
                }
                if (board[j][i]!='.'){
                    if (row[board[j][i]]){
                        return false;
                    }else{
                        row[board[j][i]]=true;
                    } 
                }
            }
        }
                 
        for (int ii=0;ii<9;ii=ii+3){
            for (int jj=0;jj<9;jj=jj+3){
                block.clear();
                for (int i=ii;i<ii+3;i++){
                    for (int j=jj;j<jj+3;j++){
                        if (board[i][j]!='.'){
                            if (block[board[i][j]]){
                                return false;
                            }else{
                                block[board[i][j]]=true;
                            } 
                        }
                    }
                }        
            }
        }
         
        return true;
    }
};

solution2:


// rows
for (int i=0; i<9; i++) {
    std::bitset<9> filled;
    for (int j=0; j<9; j++)
        filled.set(grid[i][j] - 1);
    if (filled.count() != 9)
        return false;
}

// ... similar with the loops "swapped" to get the columns
// (or do both in one loop)

for (int i=0; i<9; i += 3)
    for (int j=0; j<9; j += 3) {
        std::bitset<9> filled;
        for (int k=0; k<3; k++)
            for (int l=0; l<3; l++)
                filled.set(grid[i+k][j+l] - 1);
        if (filled.count() != 9)
            return false;
    }

return true;
