#include <vector>
#include <string>
#include <iostream>
#include <fstream>
#include <sstream>
#include <list>
#include <algorithm>
#include <sstream>
#include <set>
#include <cmath>
#include <map>
#include <stack>
#include <queue>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <numeric>
#include <bitset>
#include <deque>
#include <memory>

const long long LINF = (5e18);
const int INF = (1<<30);
#define EPS 1e-6
const int MOD = 1000000007;

using namespace std;

class StrangeCountry {
	
public:
	vector<string> g;
	bool usedV[55];
	bool usedE[55][55];
	bool single;
	
	int dfs(int x) {
		usedV[x] = true;
		int res = 0;
		for (int i=0; i<g.size(); ++i) {
			if (!usedV[i] && g[x][i] == 'Y') {
				single = false;
				usedE[x][i] = usedE[i][x] = true;
				res += dfs(i);
			}
		}
		for (int i=0; i<g.size(); ++i) {
			if (!usedE[x][i] && g[x][i] == 'Y') {
				usedE[x][i] = usedE[i][x] = true;
				++res;
			}
		}
		return res;
	}
	
	int transform(vector <string> g) {
		this->g = g;
		memset(usedV, false, sizeof(usedV));
		memset(usedE, false, sizeof(usedE));
		
		int noextra = 0, extra = 0;
		int ans = 0;
		for (int i=0; i<g.size(); ++i) {
			if (usedV[i])
				continue;
			++ans;
			single = true;
			int c = dfs(i);
			if (single)
				return -1;
			if (c == 0)
				++noextra;
			else
				extra += c;
		}
		if (extra < ans - 1)
			return -1;
		return ans - 1;
	}
	
	
	// BEGIN CUT HERE
public:
	void run_test(int Case) { if ((Case == -1) || (Case == 0)) test_case_0(); if ((Case == -1) || (Case == 1)) test_case_1(); if ((Case == -1) || (Case == 2)) test_case_2(); if ((Case == -1) || (Case == 3)) test_case_3(); if ((Case == -1) || (Case == 4)) test_case_4(); if ((Case == -1) || (Case == 5)) test_case_5(); }
private:
	template <typename T> string print_array(const vector<T> &V) { ostringstream os; os << "{ "; for (typename vector<T>::const_iterator iter = V.begin(); iter != V.end(); ++iter) os << '\"' << *iter << "\","; os << " }"; return os.str(); }
	void verify_case(int Case, const int &Expected, const int &Received) { cerr << "Test Case #" << Case << "..."; if (Expected == Received) cerr << "PASSED" << endl; else { cerr << "FAILED" << endl; cerr << "\tExpected: \"" << Expected << '\"' << endl; cerr << "\tReceived: \"" << Received << '\"' << endl; } }
	void test_case_0() { string Arr0[] = {"NY",
		"YN"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 0; verify_case(0, Arg1, transform(Arg0)); }
	void test_case_1() { string Arr0[] = {"NYYNN",
		"YNYNN",
		"YYNNN",
		"NNNNY",
		"NNNYN"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1; verify_case(1, Arg1, transform(Arg0)); }
	void test_case_2() { string Arr0[] = {"NYYNNNN",
		"YNYNNNN",
		"YYNNNNN",
		"NNNNYYN",
		"NNNYNYY",
		"NNNYYNY",
		"NNNNYYN"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 1; verify_case(2, Arg1, transform(Arg0)); }
	void test_case_3() { string Arr0[] = {"NYNYNNNNNNNN",
		"YNYNNNNNNNNN",
		"NYNYYNNNNNNN",
		"YNYNNNNNNNNN",
		"NNYNNYYNNNNN",
		"NNNNYNYNNNNN",
		"NNNNYYNNNNNN",
		"NNNNNNNNYYNN",
		"NNNNNNNYNYNN",
		"NNNNNNNYYNNN",
		"NNNNNNNNNNNY",
		"NNNNNNNNNNYN"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = 2; verify_case(3, Arg1, transform(Arg0)); }
	void test_case_4() { string Arr0[] = {"NYNNNN",
		"YNYNNN",
		"NYNYNN",
		"NNYNNN",
		"NNNNNY",
		"NNNNYN"}; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = -1; verify_case(4, Arg1, transform(Arg0)); }
	
	void test_case_5() { string Arr0[] = {"NYYNNNNNNN", "YNYNNNNNNN", "YYNNNNNNNN", "NNNNYYNNNN", "NNNYNYNNNN", "NNNYYNNNNN", "NNNNNNNYNN", "NNNNNNYNNN", "NNNNNNNNNY", "NNNNNNNNYN"}
		
		; vector <string> Arg0(Arr0, Arr0 + (sizeof(Arr0) / sizeof(Arr0[0]))); int Arg1 = -1; verify_case(5, Arg1, transform(Arg0)); }
	
	
	// END CUT HERE
	
	
};



// BEGIN CUT HERE

int main() {
	
	StrangeCountry ___test;
	
	___test.run_test(-1);
	
}

// END CUT HERE
