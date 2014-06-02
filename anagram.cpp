/* Anagram
Given an array of strings, return all groups of strings that are anagrams.
Note: All inputs will be in lower-case.*/

class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        vector<string> res;
        map<string,int> mp;
        for (int i=0;i<strs.size();i++){
            string ss = strs[i];
            sort(ss.begin(),ss.end());
            if (mp.find(ss)!=mp.end()){
                res.push_back(strs[i]);
                if (mp[ss]!=-1){
                    res.push_back(strs[mp[ss]]);   
                    mp[ss]=-1;
                }
            }else{
                mp[ss]=i;
            }
        }
        return res;
    }
