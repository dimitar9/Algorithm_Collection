1:    string multiply(string num1, string num2) {  
2:      // Start typing your C/C++ solution below  
3:      // DO NOT write int main() function  
4:      if(num1.size() ==0 || num2.size() ==0) return 0;  
5:      string res(num1.size()+num2.size()+1, '0');  
6:      std::reverse(num1.begin(), num1.end());  
7:      std::reverse(num2.begin(), num2.end());  
8:      for(int i =0; i < num1.size(); i++)  
9:      {  
10:        int dig1 = num1[i] -'0';  
11:        int carry = 0;  
12:        for(int j = 0; j< num2.size(); j++)  
13:        {  
14:          int dig2 = num2[j] - '0';  
15:          int exist = res[i+j] -'0';          
16:          res[i+j] = (dig1*dig2+carry+ exist) % 10 +'0';    
17:          carry = (dig1*dig2+carry+exist)/10;  
18:        }  
19:        if(carry >0)  
20:        {  
21:          res[i+num2.size()] = carry + '0';  
22:        }  
23:      }  
24:      std::reverse(res.begin(), res.end());  
25:      int start =0;  
26:      while(res[start] =='0' && start < res.size())  
27:      {  
28:        start++;  
29:      }  
30:      if(start == res.size()) return "0";  
31:      return res.substr(start, res.size()-start);  
32:    }  

 Given two numbers represented as strings, return multiplication of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.
» Solve this problem

[解题思路]
大整数乘法，一位一位往上乘，注意进位的处理即可。此外，注意0的处理
[Note]
1. Line 25~31, 处理乘法过程中在起始处产生的0。 比如， “9133”， “0”，直接乘的结果是“000000”， 而期待结果是“0”
