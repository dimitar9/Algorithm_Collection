#include <string>
#include <vector>
#include <stdio.h>
#include <iostream>
using namespace std;
   

       

   
void generate_string(vector<string>& lookup, string digits, vector<string>& result, string& sequence, int deep ) {

        if(deep == digits.length()) {

            result.push_back(sequence);

            return;

        } 

        int curr_digit = digits[deep]-'0';

        for(int i=0;i<lookup[curr_digit].length();i++ ){

            sequence.push_back(lookup[curr_digit][i]);

            //string new_digits = digits.substr(1,digits.length()-1);

            generate_string(lookup,digits,result,sequence,deep+1);

            sequence = sequence.substr(0,sequence.length()-1);

        }
}


vector<string> letterCombinations(string digits) {

        vector<string> lookup = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        vector<string> result;

        string sequence;

        int deep = 0;

        generate_string(lookup, digits, result, sequence, deep);

        

        return result;

   } 
int main() {

    string digits = "2";
    auto result = letterCombinations(digits);
    cout<< result[1] << endl;
}


