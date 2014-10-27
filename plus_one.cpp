class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        int n = digits.size();
        int needOneMore = 1;
        for(int i=0;i<n;i++){
            if(digits[i]!=9){
                needOneMore = 0;
                break;
            }
        }
        vector<int> res(n+needOneMore,0);
       
        int carry = 1;
        
        for(int i=n-1;i>=0;i-- ){
            if( (carry + digits[i]) <=9){
                res[i+needOneMore] = carry + digits[i];
                carry=0;
                //return digits;
            }
            else {
                res[i+needOneMore] = carry + digits[i]-10;
                carry = 1;
            }
        }
        if (needOneMore){
            res[0]=1;
        }
        return res;
        
    }
};
