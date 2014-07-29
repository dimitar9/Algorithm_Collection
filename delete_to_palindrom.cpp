#include <stdio.h>
#include <cmath>
#include <vector>
#include <string>
using namespace std;


int delete_to_palindrome( string str) {

 int max_length = 1;
    if (str.length() == 0)
   {
       return 0;
   }
   if (str.length() == 1) {
       return 1;
   }
   int n = str.length();
   if(str[0] ==str[n-1]) {
       max_length =   2+delete_to_palindrome(str.substr(1,n-2));
   }
   else {
       max_length = max(delete_to_palindrome(str.substr(1,n-1)),delete_to_palindrome(str.substr(0,n-1)));
   }
   return max_length;
}


int main() {
    string input_str = "abcdefdcba";
    int ret = delete_to_palindrome(input_str);
    printf("result is %d.\n",ret);
}
