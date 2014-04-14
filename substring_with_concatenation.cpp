#include <vector>
#include <iostream>
#include <map>
using namespace std;


vector<int> find_substring( string s, vector<string> &l) {
    vector<int> ret;
    //assume that l has at least one element
    int elem_len = l[0].size();
    int elem_num = l.size();
    int match_size = elem_len * elem_num; 
    if (s.size() < match_size){
        cout <<"no match" << endl;
        ret.push_back(0);
        return ret;
    }
    else {
        map <string,int>map_l;
        for(int m=0;m<elem_num;m++){map_l[l[m]]++;}
        for(int i=0; i< (s.length()-match_size); i++)
        {
            int j=0;
            while(j<elem_num) {
                map<string,int> map2;
                string tmp = s.substr(i+j*elem_len,elem_len); 
                if(map_l.find(tmp) == map_l.end()) {
                        break;
                }
                else {
                    map2[tmp]++;
                    if(map2[tmp] > map_l[tmp])
                        break;
                    else
                        j++;
                }
                
            }
            if (j==elem_num) 
                ret.push_back(i);
            i++;


        }
    }
    return ret; 

}

int main() {
    string s = "foobarandhellofooworldbarfoobarandfabarfoyeah";
    vector<string> l(2);
    l = {"foo","bar"}; 
    auto result_vec = find_substring(s,l);
    cout<<"words size: " << result_vec.size()<<endl;
    for(int i=0;i<result_vec.size();i++)
    {
        cout << result_vec[i] << endl;
    }
}
