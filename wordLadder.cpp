class Solution {
public:
    int ladderLength(string start, string end, unordered_set<string> &dict) {
        if(start == end) return 0;
        if(start.size() != end.size()) return 0;
         
        // use queue for BFS, store word string and their distance from start
        queue<pair<string, int> > que;
        que.push(make_pair(start, 1));
        dict.erase(start);
         
        while(!que.empty()) {
            string str = que.front().first;
            int len = que.front().second;
            que.pop();
             
            // branching factor of BFS is 26 characters * string size
            for(int i=0; i<str.size(); i++)
            for(char c='a'; c<='z'; c++) {
                char chi = str[i];
                str[i] = c;
                 
                if(str == end) return len+1;
                 
                // use count instead of find to make searching faster
                if(dict.count(str) != 0) {
                    que.push(make_pair(str, len+1));
                    // erase the appeared words from dictionary can save search time
                    dict.erase(str);
                    if(dict.empty()) break;
                }
                 
                str[i] = chi;
            }
        }
        return 0;
    }
};

//http://polythinking.wordpress.com/2013/06/09/leetcode-word-ladder/
