#include <iostream>
#include <vector>
#include <string>




using namespace std;
class BinaryCode{
    public:
        vector<string> decode(string message);
};

vector<string> BinaryCode::decode(string message) {
   
    string c = message;//store cyper
    vector<string> vec(2,"NONE");
    vec[0] = "NONE"; vec[1] = "NONE";
    int n = message.length();
    if (n == 0) 
        return vec;
    if(n==1) {
        if ( c[0]=='0')
            vec[0]=c;
        return vec;
    } else if(n==2) {
       if(( c[0] == '0') && (c[1] == '0')){
        vec[0] = "00";
       }

       if(( c[0] == '1') && (c[1] == '1')){
        vec[0] = "01";
        vec[1] = "10";
       }

       if(( c[0] == '2') && (c[1] == '2')){
        vec[1] = "11";
       }
       return vec;
    }
    string p1=message; string p2=message;          //plain text
    p1[0] = '0';
    p1[1] =  '0' + ((c[0]-'0')-(p1[0]-'0'));
    if ((p1[1] != '0') && (p1[1] != '1'))
        goto case2;
    for(int i =2 ; i < n; i++)
    {
       p1[i] = '0' + ((c[i-1]-'0') - (p1[i-2]-'0') - (p1[i-1]-'0'));
       //cout << i << " -"<<c[i-1]<<"- " << p1[i-2]<< " -"<<p1[i-1] << "-"<< " p1[i] is " << p1[i] << endl;
    }
    //cout << "test p1 before compare "<< p1 << endl;
    if(( (p1[n-1]-'0')+(p1[n-2]-'0')) == (c[n-1]-'0'))
        vec[0]=p1;
case2:
    p2[0] = '1';
    p2[1] = '0' + ((c[0]-'0')-(p2[0]-'0'));
    if ((p2[1] != '0') && (p2[1] != '1'))
        goto end;
    for(int i =2 ; i < n; i++)
    {
       p2[i] = '0' +((c[i-1]-'0') - (p2[i-2]-'0') - (p2[i-1]-'0'));

    }

    if(( (p2[n-1]-'0')+(p2[n-2]-'0') == (c[n-1]-'0')))
        vec[1]=p2;
end:
    return vec;
}




int main() {
    BinaryCode* bin = new BinaryCode();
    string p = "22111";
    auto ret = bin->decode(p);
    cout << ret[0] <<": " << ret[1]<< endl;
    delete bin;
    return 0;
}


