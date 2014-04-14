//The code is slight different from the 3 sum problem, just change the if condition, the key point is to use the abs() function to get the distances between the target and the output value.
class Solution {
public:
    int threeSumClosest(vector<int> &num, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int res;
        vector<int>::iterator it1,it2,it3,iend;
          
        sort(num.begin(),num.end());
        if(num.size()>=3){
            res = num.at(0)+num.at(1)+num.at(2);
            iend = num.end();
            it1 = num.begin();
            bool f1 = false;
            for ( ;it1!=iend-2;++it1){
                if(f1 && *it1==*(it1-1)) {continue;}
                f1 = true;
                bool f2 = false;
                bool f3 = false;
                it3 = iend-1;
                it2 = it1+1;
                while (it2!=it3){
                      
                    if(f3 && *it3==*(it3+1)) { it3 = it3 -1 ;continue;}
                    if(f2 && *it2==*(it2-1)) { it2 = it2 +1 ;continue;}
                                      
                    if (*it1 + *it2 + *it3==target){
                        res = target;
                        return res;
                    }
                    if (*it1 + *it2 + *it3 >target){
                        if (abs(target - (*it1 + *it2 + *it3)) < abs(target-res)){
                            res = *it1 + *it2 + *it3;
                        }
                        it3=it3-1;
                        f3 = true;
        
                    }else{
                        if (abs(target - (*it1 + *it2 + *it3)) < abs(target-res)){
                            res = *it1 + *it2 + *it3;
                        }
                        it2=it2+1;
                        f2 = true;
                    }
                      
                }
                  
            }
        }
        return res;
    }
};
