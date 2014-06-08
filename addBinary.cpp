//leetcode OJ : add binary

const char* AddBinary(const char* x, const char* y, char res[])
{
    if(x == NULL || y == NULL || res == NULL || *x == 0 || *y == 0)
		return NULL;

	int i = strlen(x)-1;
	int j = strlen(y)-1;
	char* p = res;
	bool bAdd = false;

	while (i >= 0 || j >= 0)
	{
		int c = 0;
		if (i >= 0) c += x[i] - '0';
		if (j >= 0) c += y[j] - '0';
		
		if (bAdd) c++;

		bAdd = c > 1;
		*p++ = c%2 + '0';

		i--, j--;
	}

	if (bAdd) *p++ = '1';
	*p-- = 0;

	char* q = res;
	while (q < p)
		swap(*q++, *p--);

	return res;
}



/* leetcode Question 4: Add binary

Add binary:
Given two binary strings, return their sum (also a binary string).
For example,
a = "11"
b = "1"
Return "100".

This is a relative easy question. Main idea is 2 steps, 1. Check the length of each string and add "0" to the shorter one. 2.Add the two string, using a carry (variable 'jin' in the code).
Just don't forget the "else" in line 27,31, 35 and 39.(Otherwise will cause wrong answer.)*/
class Solution {
public:
    string addBinary(string a, string b) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        string res = a.size()>b.size()?a:b;
        string str = a.size()>b.size()?b:a;
        bool carry=false;
        int i=str.size()-1;   
        int j=res.size()-1;
        while (i>=0){
            if (res[j]=='1' && str[i]=='1'){res[j]=carry?'1':'0';carry=true;i--;j--;continue;}
            if (res[j]=='0' && str[i]=='0'){res[j]=carry?'1':'0';carry=false;i--;j--;continue;}
            if (res[j]=='0' && str[i]=='1'){res[j]=carry?'0':'1';i--;j--;continue;}
            if (res[j]=='1' && str[i]=='0'){res[j]=carry?'0':'1';i--;j--;continue;}
        }
        while (j>=0 && carry){
            if (res[j]=='1'){res[j]='0';j--;continue;}
            if (res[j]=='0'){res[j]='1';break;}
        }
        if (j<0 && carry){ res="1"+res;}
        return res;
    }
};

reviewed
