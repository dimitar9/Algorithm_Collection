
/* leetcode Question 71: Plus One
Plus One
Given a number represented as an array of digits, plus one to the number.
Analysis:
This problem is pretty easy.
Just consider two special cases:
(1) last digit is 9: need a carry
(2) All the digits are 9 just return 100000... number of 0s is the length of the vector.*/
class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (digits[digits.size()-1]!=9){
            digits[digits.size()-1]++;
            return digits;
        }else{
            digits[digits.size()-1]=0;
            int carry=1;
             
            for (int i=digits.size()-2;i>=0;i--){
                if (digits[i]!=9){
                    digits[i]++;
                    return digits;
                }else{
                    digits[i]=0;
                }
            }
            vector<int> res(digits.size()+1,0);
            res[0]=1;
            return res;
        }
    }
};
