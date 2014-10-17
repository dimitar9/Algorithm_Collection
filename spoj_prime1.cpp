    /// PRIME1 - C++ (g++)

    #include <stdio.h>
    #include <iostream>
    #include <cmath>
    #include <vector>
    #include <set>
    using namespace std;
    int main() {
        vector<int> primes;
        primes.push_back(2);

        for (int i = 3; i <= 32000; i+=2) {
            bool isprime = true;
            int cap = sqrt(i) + 1;

            vector<int>::iterator p;
            for (p = primes.begin(); p != primes.end(); p++) {
                if (*p >= cap) break;
                if (i % *p == 0) {
                    isprime = false;
                    break;
                }
            }
            if (isprime) primes.push_back(i);
        }

        int T,N,M;

        scanf("%d",&T);

        set<int> notprime;
        for (int t = 0; t < T; t++) {
            if (t) cout << endl;
          
    //        cin >> M >> N;
          scanf("%d %d",&M,&N);
            if (M < 2) M = 2;

            notprime.clear();
            int size_of_primes = primes.size();
            for( int i = 0; i<size_of_primes; i++){
                if(primes[i] > N) break;
                if(primes[i] < M) i++;
                if((primes[i] >= M ) && (primes[i] <= N)) notprime.insert(primes[i]);
            }

            set<int>::iterator it_s;
            for(it_s = notprime.begin(); it_s!= notprime.end(); it_s++){
                cout << *it_s << endl;
            }

        }
        return 0;
    }
