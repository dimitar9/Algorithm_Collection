#include <iostream>
#include <cstdlib>
#include <string>

using namespace std;

int compareVersion(string version1, string version2) {

        

        string a = ""; string b = "";

        int lena=version1.size();

        int lenb=version2.size();

        

        int a_st=0;

        int b_st=0;

        int i=0;

        int j=0;



        while(true){

            bool a_dot=false;

            bool b_dot=false;

            

            for(i=a_st;i<lena;i++){

                if(version1[i]=='.'){

                    a=version1.substr(a_st,i-a_st);

                    a_dot=true;
                    break;

                }

            }

            if(!a_dot) a = version1;

            for(j=b_st;j<lenb;j++){

                if(version2[j]=='.'){

                    b=version2.substr(b_st,j-b_st);

                    b_dot=true;
                    break;

                }

            }

            if(!b_dot) b = version2;

            if(atoi(a.c_str()) > atoi(b.c_str())){

                return 1;

            }

            else if(atoi(a.c_str()) < atoi(b.c_str())){

                return -1;

            }

            else{

             a_st=i+1;

             b_st=j+1;

             if ( !a_dot || !b_dot)

                return 0;

            }

        }

        

    }
int main() 
{
    string a = "1.0"; string b = "1.1";
    compareVersion(a,b);
}
