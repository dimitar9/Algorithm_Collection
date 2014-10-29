
class Solution {
public:
  vector<int> getRow(int rowIndex) {
  vector<int> ret(rowIndex + 1);
  ret[0] = 1;
  for(int i = 1; i <= rowIndex; ++i){
    for(int j = i; j > 0; --j){
      if(j == i) ret[j] = 1;
      else ret[j] = ret[j - 1] + ret[j];
    }
  }
  return ret;
  }
};
