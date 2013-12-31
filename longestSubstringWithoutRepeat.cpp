class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int maxLen=0;
        for(int i=0;i<s.length();i++)
        {
                std::map<int,int> currmap;
                currmap[s[i]]=0;
                if (s.length() ==1) return 1; //this is important. easy to miss.
                for(int j=i+1;j<s.length();j++)
                {
                    if  (currmap.find(s[j]) != currmap.end())
                    {
                        int len = currmap.size();
                        maxLen = max(maxLen,len);
                        break;
                    }
                    else
                    {
                        currmap[s[j]]=0;
                    }
                    if (j==s.length()-1) //this is important. easy to miss.
                    {
                        int len = currmap.size();
                        maxLen = max(maxLen,len);
                        break;
                    }
                }
        }
        return maxLen;
        
    }
};
