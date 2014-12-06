bool foo(vector<vector<char> > &board, int i, int j, string word){
        if (word.size()==0) return true;
         
        if(i>0&&board[i-1][j]==word[0]){
            char ch= board[i][j];
            board[i][j]='#';
            if(foo(board,i-1,j,word.substr(1,word.size())))
                return true;
            board[i][j]=ch;
        }
        if(i<board.size()-1&&board[i+1][j]==word[0]){
            char ch= board[i][j];
            board[i][j]='#';
            if(foo(board,i+1,j,word.substr(1,word.size())))
                return true;
            board[i][j]=ch;
        }
        if(j>0&&board[i][j-1]==word[0]){
            char ch= board[i][j];
            board[i][j]='#';
            if(foo(board,i,j-1,word.substr(1,word.size())))
                return true;
            board[i][j]=ch;
        }
        if(j<board[0].size()-1&&board[i][j+1]==word[0]){
            char ch= board[i][j];
            board[i][j]='#';
            if(foo(board,i,j+1,word.substr(1,word.size())))
                return true;
            board[i][j]=ch;
        }
         
        return false;
             
    }
    bool exist(vector<vector<char> > &board, string word) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        for(int i=0;i<board.size();i++)
           for(int j=0;j<board[0].size();j++){
                if(board[i][j]==word[0])
                    if(foo(board, i,j,word.substr(1,word.size())))
                        return true;
           }
        return false;
    }
