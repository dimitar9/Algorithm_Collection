class Solution {
public:
     
    void perm(vector<int> num,int k,int n, vector<vector<int> > &res){
        if (k==n){
            res.push_back(num);
        }else{
            for (int i=k;i<=n;i++){
                swap(num[i],num[k]);
                 
                perm(num,k+1,n,res);
                 
                swap(num[i],num[k]);
            }
        }
    }
 
    vector<vector<int> > permute(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<vector<int> > res;
        perm(num,0,(num.size()-1),res);
        return res;
    }
};
