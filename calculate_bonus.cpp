#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

vector<int> calculate_bonus(const vector<int>& ratings) {
    vector<int> T(ratings.size(), 1);

    for(int i=1; i< ratings.size(); i++) {
        if (ratings[i] > ratings[i-1])
        {
            T[i] = T[i-1] + 1;
        }
    }
    for (int i = ratings.size()-2; i>0; i--) {
        if (ratings[i] > ratings[i+1])
        {
            T[i] =max(T[i], T[i+1] +1);
        }
    }
    return T;
}

int main() {
    vector<int> test = {1,2,3,4,5,4,3,2,1};
    auto T = calculate_bonus(test);
    for(auto t:T) {
    cout << t << " " ;
    }
    return 0;
}
