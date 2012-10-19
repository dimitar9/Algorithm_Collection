#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;
void maxContiSum(vector<int>& a);
int main()
{
    
    double inputar[]={-2,11,-4,13,-5,2};
    std::vector<int> arrayA(inputar,inputar+6);
    maxContiSum(arrayA);
}
void maxContiSum(std::vector<int>& origArray)
{
    int len = origArray.size();
    int maxSum = 0;
    int runningSum = origArray[0];
    int j = 0;
    int start = 0, finish = 0;
    for(int i =1; i<len;i++){
        if (runningSum >0)
        {
            runningSum += origArray[i];
        }else
        {
            runningSum = origArray[i];
            j = i;
        }
        if(runningSum > maxSum)
        {
            maxSum = runningSum;
            start = j;
            finish = i;
        }
    }
    cout <<"Max Sum: " << maxSum << endl;
    cout <<"Indices: i=" << start << ":j=" << finish<< endl;
}
