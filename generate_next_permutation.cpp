/*Analysis:
Well, this is more like a math problem, and I don't know how to solve it.
From the wikipedia, one classic algorithm to generate next permutation is:
Step 1: Find the largest index k, such that A[k]<A[k+1]. If not exist, this is the last permutation. (in this    problem just sort the vector and return.)
Step 2: Find the largest index l, such that A[l]>A[k].
Step 3: Swap A[k] and A[l].
Step 4: Reverse A[k+1] to the end.
i*/
class Solution {
public:
    void nextPermutation(vector<int> &num) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        int sz = num.size();
        int k=-1;
        int l;
        //step1
        for (int i=0;i<sz-1;i++){
            if (num[i]<num[i+1]){
                k=i;
            }
        }
        if (k==-1){
            sort(num.begin(),num.end());
            return;
        }
         
        //step2
        for (int i=0;i<sz;i++){
            if (num[i]>num[k]){
                l=i;
            }
        }
        //step3        
        int tmp = num[l];
        num[l]=num[k];
        num[k]=tmp;
        //step4
        reverse(num.begin()+k+1,num.end());
    }
};
