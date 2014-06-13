1:  int largestRectangleArea(vector<int> &h) {  
2:       stack<int> S;  
3:       h.push_back(0);  
4:       int sum = 0;  
5:       for (int i = 0; i < h.size(); i++) {  
6:            if (S.empty() || h[i] > h[S.top()]) S.push(i);  
7:            else {  
8:                 int tmp = S.top();  
9:                 S.pop();  
10:                 sum = max(sum, h[tmp]*(S.empty()? i : i-S.top()-1));  
11:                 i--;  
12:            }  
13:       }  
14:       return sum;  
15:  }  
