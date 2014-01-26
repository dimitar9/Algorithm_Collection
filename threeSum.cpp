//O(n^2) solution.
class Solution {
public:
    vector<vector <int> > threeSum(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
     vector<int> res_m(3);
        vector< vector<int> > res;
        vector<int>::iterator it1,it2,it3,iend;
         
        sort(num.begin(),num.end());
        if(num.size()>=3){
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
                                     
                    if (*it1 + *it2 + *it3==0){
                        res_m.at(0)=*it1;
                        res_m.at(1)=*it2;
                        res_m.at(2)=*it3;
                        res.push_back(res_m);
                    }
                    if (*it1 + *it2 + *it3 >0){
                        it3=it3-1;
                        f3 = true;
       
                    }else{
                        it2=it2+1;
                        f2 = true;
                    }
                     
                }
                 
            }
        }
        return res;
    }
};
