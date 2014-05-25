#include <iostream>
#include <utility>
#include <vector>
#include <stack>
using namespace std;

int longest_valid_p(string s)
{
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (s.size()<2) {return 0;}
        stack<pair<char,int> > st;
        int maxl=0;
        int i=0;
        int t=0;
        while (i<s.size()){            
            if (s[i]=='(') {st.push(make_pair(s[i],i));}
            else{
                if (st.empty()){t=i+1;}
                if (!st.empty()){
                    pair<char,int> tmp = st.top();
                    st.pop();
                    if (tmp.first=='('){
                        if (!st.empty()){maxl=max(maxl,(i-st.top().second));} //key step, i-st.top().second, but not the tmp.second.
                        else{maxl=max(maxl,i-t+1);}
                    }
                }        
            }
            i++;
        }
        return maxl;
}    
Review
int main() {
    string inupt_parenthesis_8 = "()()(())))(()()";
    string input_parenthesis_10= "()()(())))(()()()()()";
    int result1 = longest_valid_p(inupt_parenthesis_8);
    cout << result1 << endl;

    int result2 = longest_valid_p(input_parenthesis_10);
    cout << result2 << endl;
}

