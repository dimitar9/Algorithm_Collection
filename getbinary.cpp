#include <iostream>
#include <string>
using namespace std;

void reverseString(string& str)
{
    int i,j;
    char temp;
    i=j=temp=0;

    j=(str).length() -1;
    for(i=0;i<j;i++,j--)
    {
        temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }

}


string getbinary(int d, int len)
{
    string str="";
    while(d>0) {
        str = str + char((d%2) + '0');
        d=d/2;
    }
    for(int i=0; i<len-str.size();i++) {
        str = str + '0';
    }

    reverseString(str);
    
    return str;
}
int main() {
    string ret;
    ret = getbinary(7,4);
    cout<<ret<<endl;


}
