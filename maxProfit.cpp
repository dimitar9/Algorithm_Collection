class Solution {
public:
    int maxProfit(vector<int> &prices) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int res = 0;
        if (prices.size()>1){
            vector<int>::iterator it1,it2;
            vector<int> minv;
            int min1=prices[0];
            for (it1 = prices.begin()+1;it1!=prices.end();it1++){
                if (*it1<min1) { min1 = *it1;}
                minv.push_back(min1);
            }
            for (int i = 1; i<prices.size();i++){
                if (prices[i]-minv[i-1]>res){res = prices[i]-minv[i-1];}
            }          
        }
        return res;
    }
};
