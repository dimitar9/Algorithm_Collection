L: 16 l: 8 k: 3
how many: 4
L: 16 l: 8 k: 3
how many: 4
This    is    an

L: 16 l: 13 k: 3
how many: 2
L: 16 l: 13 k: 3
how many: 1
example  of text

justification.



code:

using namespace std;
vector<string> fullJustify(vector<string> &words, int L) {
    vector<string> res;
    for(int i = 0, k, l; i < words.size(); i += k) {
        for(k = l = 0; i + k < words.size() && l + words[i+k].size() <= L - k; k++) {
            //l: length of current line.
            //k: length of current number of words fit in this line.
            l += words[i+k].size();
        }
        string tmp = words[i];
        for(int j = 0; j < k - 1; j++) {
            cout << "L: " << L << " l: " << l << " k: " << k << endl;
            cout << "how many: " << (L - l) / (k - 1) + (j < (L - l) % (k - 1)) << endl;
            if(i + k >= words.size()) tmp += " ";
            else tmp += string((L - l) / (k - 1) + (j < (L - l) % (k - 1)), ' ');
            tmp += words[i+j+1];
        }
        tmp += string(L - tmp.size(), ' ');
        cout << tmp << endl;
        cout << endl;
        res.push_back(tmp);
    }
    return res;
}


int main() {
    vector<string> input;
    input.push_back("This");

    input.push_back("is");
    input.push_back("an");
    input.push_back("example");
    input.push_back("of");
    input.push_back("text");
    input.push_back("justification.");
    //["This", "is", "an", "example", "of", "text", "justification."]
    fullJustify(input, 16);
}
