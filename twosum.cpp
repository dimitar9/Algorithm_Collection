#include <vector>
#include <map>
#include <iostream>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<int> res;
        map<int,int>hmap;
        for (int i=0;i<numbers.size();i++){
            hmap[numbers[i]]=i;
        }     
        for (int i=0;i<numbers.size();i++){
            if (hmap.find(target-numbers[i])!=hmap.end()){
                 
                if (i<hmap[target-numbers[i]]){
                    res.push_back(i+1);
                    res.push_back(hmap[target-numbers[i]]+1);
                }else if  (i>hmap[target-numbers[i]]) {
                    res.push_back(hmap[target-numbers[i]]+1);
                    res.push_back(i+1);
                }else 
                {
                    continue;
                }
                return res;
            }
        }
         
    }
};


int main()
{
    Solution sol;
    vector<int> input{-1,-3,-4,-5,-12,-10,-827,28,-8,1,4,2,5,6,7,8,12,15,18,20,21,25,0};
    int target = 6;
    vector<int> result;
    result = sol.twoSum(input,target);
    for (vector<int>::iterator it = result.begin(); it!=result.end(); ++it) {
            cout << *it << endl;
    }

}
//reviewed.
