//find longest substring which contains just two unique characters.
string longestSubstringWithTwoUniqueCharacters(string S)
{
    string res;
    int letterCount[256];
    int uniqueCount = 0;
    int len = S.size();
    int begin=0, end=0, maxLen = 0;
    memset(letterCount,0,256*sizeof(int));
    
    for(begin=0,end=0;end<len;end++)
    {
        letterCount[(int)S[end]]++;
        if(letterCount[(int)S[end]]==1) uniqueCount++;
        if(uniqueCount==2)
        {
            if(maxLen < end-begin+1) 
            {
                maxLen = end-begin+1;
                res = S.substr(begin, maxLen);
            }
        }
        else if(uniqueCount>2)
        {
            while(uniqueCount>2)
            {
                letterCount[(int)S[begin]]--;
                if(letterCount[(int)S[begin]]==0) uniqueCount--;
                begin++;
            }        
        }        
    }
    
    return res;
}
