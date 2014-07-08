#include <iostream>
#include <string>
#include <set>
#include <algorithm>
#include <unordered_map>
using namespace std;


int lengthOfLongestSubstring(string s) {
  int n = s.length();
  int i = 0, j = 0;
  int maxLen = 0;
  bool exist[256] = { false };
  while (j < n) {
    if (exist[s[j]]) {
      maxLen = max(maxLen, j-i);
      while (s[i] != s[j]) {
        exist[s[i]] = false;
        i++;
      }
      i++;
      j++;
    } else {
      exist[s[j]] = true;
      j++;
    }
  }
  maxLen = max(maxLen, n-i);
  return maxLen;
}



int main() {
   string s = "abbcdefesf";
   int ret = lengthOfLongestSubstring(s);
   cout << ret << endl;   
}

