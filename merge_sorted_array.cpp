// Copyright (c) 2013 Elements of Programming Interviews. All rights reserved.
//EPI 11.1
#include <queue>
#include <vector>
#include <iostream>
using std::pair;
using std::priority_queue;
using std::vector;
using namespace std;
struct Compare {
  bool operator()(const pair<int, int>& lhs, const pair<int, int>& rhs) {
    return lhs.first > rhs.first;
  }
};

vector<int> merge_arrays(const vector<vector<int>>& S) {
  priority_queue<pair<int, int>, vector<pair<int, int>>, Compare> min_heap;
  vector<int> S_idx(S.size(), 0);

  // Every array in S puts its smallest element in heap.
  for (int i = 0; i < S.size(); ++i) {
    if (S[i].size() > 0) {
      min_heap.emplace(S[i][0], i);
      S_idx[i] = 1;
    }
  }

  vector<int> ret;
  while (!min_heap.empty()) {
    pair<int, int> p = min_heap.top();
    ret.emplace_back(p.first);
    // Add the smallest element into heap if possible.
    if (S_idx[p.second] < S[p.second].size()) {
      min_heap.emplace(S[p.second][S_idx[p.second]++], p.second);
    }
    min_heap.pop();
  }
  return ret;
}

int main(){
    vector<int> a (1,10);
    vector<int> b (1,8);
    vector<vector<int> > c ;
    c.push_back(a);
    c.push_back(b);
    vector<int> d;
    d = merge_arrays(c);
    cout << d[1] << " " << d[0] << endl;
    return 0; 
}
