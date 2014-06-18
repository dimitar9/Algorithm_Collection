
/* leetcode Question 83: Restore IP Addresses
Restore IP Addresses:

Given a string containing only digits, restore it by returning all possible valid IP address combinations.
For example:
Given "25525511135",
return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)


Analysis:
This problem can be viewed as a DP problem. There needed 3 dots to divide the string, and make sure the IP address is valid:  less than or equal to 255, greater or equal to 0, and note that, "0X" or "00X" is not valid.
For the DP, the length of each part is from 1 to 3. We use a vector<string> to store each part, and cut the string every time. Details see the code.

Note that "atoi" is for c-string, <string> need to convert to cstring by str.c_str();*/

class Solution {
public:
    bool valid(string s){
        if (s.size()==3 && (atoi(s.c_str())>255 || atoi(s.c_str())==0)){return false;}
        if (s.size()==3 && s[0]=='0'){return false;}
        if (s.size()==2 && atoi(s.c_str())==0){return false;}
        if (s.size()==2 && s[0]=='0'){return false;}
        return true;
    }
 
    void getRes(string s, string r, vector<string> &res, int k){
        if (k==0){
            if (s.empty()){res.push_back(r);}
            return;
        }else{
            for (int i=1;i<=3;i++){
                if (s.size()>=i && valid(s.substr(0,i))){
                    if (k==1){getRes(s.substr(i),r+s.substr(0,i),res,k-1);}
                    else{getRes(s.substr(i),r+s.substr(0,i)+".",res,k-1);}
                }
            }
        }
    }
 
    vector<string> restoreIpAddresses(string s) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<string> res;
        getRes(s,"",res,4);
        return res;
    }
};
