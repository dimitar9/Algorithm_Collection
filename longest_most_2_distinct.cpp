#include <iostream>
#include <string>

using namespace std;

int lenOfSubstring2Distinct(string s){
	int i = 0, j = -1, maxlen = 0;
	for (int k = 1; k < s.size(); k++) {
		if (s[k] == s[k-1]) continue;
		if(j >=0 && s[k] != s[j]) {
			maxlen = max(maxlen, k - i);
			i = j + 1;
		}
		j = k - 1;
	}
	return maxlen;

}

int main() {
	string str = "aabcddaacf";
	cout << lenOfSubstring2Distinct(str) << endl;

}