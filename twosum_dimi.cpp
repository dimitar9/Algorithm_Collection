#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;
    vector<int> twoSum(vector<int> &numbers, int target) {
        vector<int> ret;
        unordered_map<int,int> map;
        int len=numbers.size();
        vector<int>mid(len);
        for(int i=0;i<len;i++){
            mid[i] = target - numbers[i];
        }
        for(int i=0;i<len;i++){
            map[numbers[i]] = i;
        }
        for(int j=0;j<len;j++){
            if(  map.find(mid[j]) != map.end()  ){
                if(j< map[mid[j]])
                {
                    ret.push_back(j+1);
                    ret.push_back(map[mid[j]]+1);
                    return ret;
                }
                if(j> map[mid[j]])
                {
                    ret.push_back(map[mid[j]]+1);
                    ret.push_back(j+1);
                    return ret;
                }
            }
        }
        return ret;
        
    }

int main(){
    vector<int> input(3);input[0]=3;input[1]=2;input[2]=4;
    int target = 6;
    auto ret = twoSum(input,target);
    cout<< ret[0]<<ret[1]<<endl;
    return 0;
}
