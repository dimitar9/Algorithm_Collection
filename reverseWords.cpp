class Solution {
public:
    void reverseWords(string &s) {
        string word; //tmp string to store each word
        string res; // result string
        int i=0;
        while (i<s.size()){
            if (char(s[i])==' ' && word.empty()){i++;continue;} //multiple spaces
            if (char(s[i])==' ' && !word.empty()){ //first space after a word
                res = word+" "+ res; //store the word
                word=""; //reset the word
                i++; continue;
            }
            if (char(s[i])!=' '){word=word+char(s[i]);i++; continue;} //non-space chars
        }
         
        if (!word.empty()){ //last word
            s = word+" "+res;
        }else{
            s = res;
        }
        s = s.substr(0,s.size()-1); //eliminate the last space
    }
};
