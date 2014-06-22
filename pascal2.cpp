[解题报告]
滚动数组实现。注意Line11，要从后往前加，否则会产生冗余计算。

[Code]

1:    vector<int> getRow(int rowIndex) {  
2:      // Start typing your C/C++ solution below  
3:      // DO NOT write int main() function  
4:      vector<int> result;  
5:      result.resize(rowIndex+2);  
6:      for(int i =0; i< rowIndex+2; i++)  
7:        result[i] = 0;  
8:      result[1]=1;  
9:      for(int i =0; i< rowIndex; i++)  
10:      {  
11:        for(int j =rowIndex+1; j>0; j--)  
12:        {  
13:          result[j] = result[j-1] + result[j];  
14:        }  
15:      }  
16:      result.erase(result.begin());  
17:      return result;  
18:    }  
