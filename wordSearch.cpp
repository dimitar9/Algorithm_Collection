class Solution {
public:
 
    bool search(vector<vector<char> > &board, int i,int j,string str,vector<vector<bool> > &mask){
        if (str.size()==0){return true;}
        else{
            if ((i>0)&&(board[i-1][j]==str[0])&&(mask[i-1][j]==false)){
                mask[i-1][j]=true;
                if (search(board,i-1,j,str.substr(1),mask)){
                    return true;
                }
                mask[i-1][j]=false;
            }
            if ((i<board.size()-1)&&(board[i+1][j]==str[0])&&(mask[i+1][j]==false)){
                mask[i+1][j]=true;
                if (search(board,i+1,j,str.substr(1),mask)){
                    return true;
                }
                mask[i+1][j]=false;
            }
            if ((j>0)&&(board[i][j-1]==str[0])&&(mask[i][j-1]==false)){
                mask[i][j-1]=true;
                if (search(board,i,j-1,str.substr(1),mask)){
                    return true;
                }
                mask[i][j-1]=false;
            }
            if ((j<board[0].size()-1)&&(board[i][j+1]==str[0])&&(mask[i][j+1]==false)){
                mask[i][j+1]=true;
                if (search(board,i,j+1,str.substr(1),mask)){
                    return true;
                }
                mask[i][j+1]=false;
            }
        }
        return false;
    }
 
    bool exist(vector<vector<char> > &board, string word) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (word.size()==0) {return false;}
             
        for (int i=0;i<board.size();i++){
            for (int j=0;j<board[0].size();j++){
                if (word[0]==board[i][j]){
                    if (word.size()==1) {return true;}
                    else{
                        vector<vector<bool> > mask(board.size(),vector<bool>(board[0].size(),false));
                        mask[i][j]=true;
                        if (search(board,i,j,word.substr(1),mask)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
};

reviewed
