class Solution {
public:
    vector<vector<int> > fourSum(vector<int> &num, int target) {
        int n = num.size();
        vector<vector<int> > ret;

        sort(num.begin(), num.end());
        for (int i = 0; i < n; ++i) {
            if (i != 0 && num[i] == num[i - 1]) continue;

            for (int j = n - 1; j > i; --j) {
                if (j != n - 1 && num[j] == num[j + 1]) continue;

                int L = i + 1, R = j - 1;
                while (L < R) {
                    int sum = num[i] + num[L] + num[R] + num[j];
                    if (L != i + 1 && num[L] == num[L - 1]) {
                        L++;
                    } else if (R != j - 1 && num[R] == num[R + 1]) {
                        R--;
                    } else if (sum > target) {
                        R--;
                    } else if (sum < target) {
                        L++;
                    } else {
                        ret.resize(ret.size() + 1);
                        ret.back().push_back(num[i]);
                        ret.back().push_back(num[L]);
                        ret.back().push_back(num[R]);
                        ret.back().push_back(num[j]);
                        L++;
                        R--;
                    }
                }
            }
        }
        return ret;
    }


};
