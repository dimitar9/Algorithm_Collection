class Solution { //c++
public:
    vector<int> twoSum(vector<int> &numbers, int target) {
        int st = 0;
        int ed = numbers.size()-1;
        vector<int> ret(2,0);
        while(st<ed){
            if(numbers[st]+numbers[ed] == target)
            {
                ret[0] = st+1;
                ret[1] = ed + 1;
                return ret;
            }
            else if (numbers[st]+numbers[ed]  <target)
            {
                st++;
            }
            else{
                ed--;
            }
        }
    }
};
