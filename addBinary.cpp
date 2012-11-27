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

