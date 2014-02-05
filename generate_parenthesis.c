//use DFS and dynamic programming    
//generate parenthesis
        void gp(string str,int l,int r, int &n, vector<string> &res){
            if (l>n){return;}
            if (l==n && r==n){
                res.push_back(str);
            }else{
                gp(str+"(",l+1,r,n,res);
                if (l>r){
                    gp(str+")",l,r+1,n,res);
                }
            }
        }
        vector<string> generateParenthesis(int n) {
            // Start typing your C/C++ solution below
            // DO NOT write int main() function
            vector<string> res;
            if (n==0){return res;}
            gp("",0,0,n,res);
            return res;
        }

