#include<iostream>
#include<stdio.h>
#include <stdlib.h>
using namespace std;


string cas(string str){
    string str1;
    char ch = str[0];
    int chn = 1;
    for(int i = 1; i<= str.size();i++){
       if (str[i] == ch) {chn++;}
       else{
           char chr = chn +  '0';
           str1 = str1 + chr;
           str1 = str1 + ch;
           ch = str[i];
           chn = 1;
       }
    }
    return str1;
}


string countAndSay(int n){
    if (n == 1) { return "1" ;}
    string str1 = "1";
    string strn;
    for(int i=1; i<n; i++) {
        strn = cas (str1);
        str1 = strn;
    }
    return strn;
}

int main(){
    char input[8];
    printf("Enter a number: ");
    fgets(input,256,stdin);
    int number = atoi(input);
    string ret = countAndSay(number);
    cout<<"return is" << ret << endl;
    return 0;
}


