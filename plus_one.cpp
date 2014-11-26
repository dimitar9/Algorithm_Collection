class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        
        for(int i=digits.size()-1;i>=0;i-- ){
            if( ( digits[i]<9) ){
                digits[i]++;
                return digits;
            }
            else {
                digits[i]=0;
            }
        }
        digits.push_back(0);
        digits[0]=1;
        
        return digits;
        
    }
};