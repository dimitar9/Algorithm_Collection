/*
 leetcode Question 35: Insert Interval
Insert Interval


Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
You may assume that the intervals were initially sorted according to their start times.
Example 1:
Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
Example 2:
Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].



Analysis:

In other words, the questions gives a new interval, the task is to insert this new interval into an ordered non-overlapping intervals. Consider the merge case.

Idea to solve this problem is quite straight forward:
1. Insert the new interval according to the start value.
2. Scan the whole intervals, merge two intervals if necessary.

*/


/**
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
 
    bool myfunc(Interval a, Interval b) {
        return( a.start<b.start);
    }
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        vector<Interval> res;
        vector<Interval>::iterator it; 
        for (it = intervals.begin();it!=intervals.end();it++){
            if (newInterval.start<(*it).start){
                intervals.insert(it,newInterval);
                break;
            }
        }   
        if (it==intervals.end()){intervals.insert(it,newInterval);}
         
         
        if (intervals.empty()) {return res;}
           
        res.push_back(*intervals.begin());
        for (it = intervals.begin()+1;it!=intervals.end();it++){
            if ((*it).start>res.back().end){res.push_back(*it);}
            else{ res.back().end = max(res.back().end,(*it).end);}
        }
        return res;
    }
};
