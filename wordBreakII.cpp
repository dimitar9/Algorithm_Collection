class Solution {
public:
	void helper(string &s, unordered_set<string> dict, string &tmp, vector<string> &res, vector<bool> &rec, int start, int len){
		if(start == len){
			res.push_back(tmp.substr(0, tmp.size()-1));
			return;
		}
		for(int i=start; i<len; i++){
			string substr = s.substr(start, i-start +1);
			if(dict.find(substr)!=dict.end() && rec[i+1]){
				tmp.append(substr).append(" ");
				int size = res.size();
				helper(s, dict, tmp, res, rec, i+1, len);
				if(size == res.size())
					rec[i+1] = false;
					tmp.resize(tmp.size() - substr.size() - 1);
			}
		}
	}

vector<string> wordBreak(string s, unordered_set<string> &dict) {
	vector<string> res;
	if(dict.empty()) return res;
	string tmp;
	vector<bool> rec(s.size()+1, true);
	int len = s.size();
	helper(s, dict, tmp, res, rec, 0, len);
	return res;
	}
};
