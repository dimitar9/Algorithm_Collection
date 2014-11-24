class Solution {
public:
        void reverseWords(string &s) {
        string reversed;
        int j = s.size();
        for(int i = s.size()-1; i >=0; i--){
            if (s[i] == ' ') {
                j = i;
            } else if (i==0 || s[i-1] == ' ') {
                if (reversed.size() !=0) {
                    reversed += ' ';
                }
                reversed += (s.substr(i, j-i));
            }
            
        }
        s = reversed;
    
    }
};
