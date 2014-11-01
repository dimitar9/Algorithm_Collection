1:    int threeSumClosest(vector<int> &num, int target) {  
2:      // Start typing your C/C++ solution below  
3:      // DO NOT write int main() function  
4:      std::sort(num.begin(), num.end());  
5:      int len = num.size();  
6:      int minV = INT_MAX, record;  
7:      for(int i =0; i< len; i++)  
8:      {        
9:        int start = i+1, end =len-1;             
10:        while(start<end)  
11:        {  
12:          int sum = num[i] + num[start] + num[end];  
13:          if(sum == target)  
14:          {   
15:            minV = 0;  
16:            record = sum;  
17:            break;  
18:          }  
19:          if(sum < target)  
20:          {  
21:            if(target-sum < minV)  
22:            {  
23:              minV = target-sum;  
24:              record = sum;  
25:            }  
26:            start++;            
27:          }  
28:          else  
29:          {  
30:            if(sum-target < minV)  
31:            {  
32:              minV = sum - target;  
33:              record = sum;  
34:            }  
35:            end--;  
36:          }  
37:        }        
38:        while(i<len-1 && num[i] == num[i+1]) i++;  
39:      }  
40:      return record;  
41:    }  
