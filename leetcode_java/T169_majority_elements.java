class Solution {//cpp
public:
    int majorityElement(vector<int> &num) {
        int n = num.size();
        int half = (n%2==0)? n/2:n/2+1;
        map<int,int> count;
        for(int i = 0; i < n; i++){
            count[num[i]]++;
            if(count[num[i]]>= half )
                return num[i];
        }
        return 0;
        
    }
};
