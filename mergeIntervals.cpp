/* leetcode Question 51: Merge Intervals
Merge Intervals

Given a collection of intervals, merge all overlapping intervals.
For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].


Analysis:
The idea is simple. First sort the vector according to the start value.
Second, scan every interval, if it can be merged to the previous one, 
then merge them, else push it into the result vector.

Note here:
The use of std::sort to sort the vector, need to define a compare function,
which need to be static. (static bool myfunc() ) The sort command should be like 
this:  std::sort(intervals.begin,intervals.end, Solution::myfunc); 
otherwise, it won't work properly.*//**
 * Definition for an interval.
 * struct Interval {
 *     int start;
 *     int end;
 *     Interval() : start(0), end(0) {}
 *     Interval(int s, int e) : start(s), end(e) {}
 * };
 */
class Solution {
public:
    static bool myfunc(const Interval &a, const Interval &b){
        return (a.start < b.start);
    }
    vector<Interval> merge(vector<Interval> &intervals) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<Interval> res;
        if (intervals.size()==0){return res;}
        std::sort(intervals.begin(),intervals.end(),Solution::myfunc);
        res.push_back(intervals[0]);
        for (int i=1;i<intervals.size();i++){
            if (res.back().end>=intervals[i].start){
                res.back().end=max(res.back().end,intervals[i].end);
            }else{
                res.push_back(intervals[i]);
            }  
        }
        return res;
    }
};
