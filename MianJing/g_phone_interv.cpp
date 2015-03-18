
#include <iostream>
#include <vector>
using namespace std;

void print(const vector<int> &A) {
    int count = 0;
    cout << "[";
    for(auto &i : A) {
        if (count++) {
            cout << ", ";
        }
        cout << i;
    }
    cout << "]" << endl;
};

void zigzag(vector<int> &A) {
    if (A.empty()) return;

    for (size_t i = 1; i < A.size(); ++i) {
        if (i&0x01) { // odd position element should be a local maximum
            if (A[i] <= A[i-1]) {
                swap(A[i-1], A[i]);
            }
        } else { // even position element should be a local minimum
            if (A[i] > A[i-1]) {
                swap(A[i-1], A[i]);
            }
        }
    }
};

int main() {
    // your code goes here
    vector<int> a1{1, 4, 5, 2, 3};
    cout << "Before: ";
    print(a1);
    zigzag(a1);
    cout << "After: ";
    print(a1);

    return 0;
}
