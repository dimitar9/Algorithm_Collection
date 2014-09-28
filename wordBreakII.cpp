 1     vector<string> wordBreak(string s, unordered_set<string> &dict) {
 2         string result;
 3         vector<string> solutions;
 4         int len = s.size();
 5         vector<bool> possible(len+1, true); // to record the search which has been executed once
 6         GetAllSolution(0, s, dict, len, result, solutions, possible);
 7         return solutions;
 8     }
 9     
10     void GetAllSolution(int start, const string& s, const unordered_set<string> &dict, int len, string& result, vector<string>& solutions, vector<bool>& possible)
11     {
12         if (start == len)
13         {
14             solutions.push_back(result.substr(0, result.size()-1));//eliminate the last space
15             return;
16         }
17         for (int i = start; i< len; ++i)
18         {
19             string piece = s.substr(start, i - start + 1);
20             if (dict.find(piece) != dict.end() && possible[i+1]) // eliminate unnecessory search
21             {
22                 result.append(piece).append(" ");
23                 int beforeChange = solutions.size();
24                 GetAllSolution(i + 1, s, dict, len, result, solutions, possible);
25                 if(solutions.size() == beforeChange) // if no solution, set the possible to false
26                     possible[i+1] = false;
27                 result.resize(result.size() - piece.size()-1);
28             }
29         }
30     }
