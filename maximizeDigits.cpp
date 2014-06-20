重新排序整数的digits使其最大化 (e.g. 3515 -> 5531) 要求O(1)

int largestSibling(int N) {
int digit;
int temp = 0;
int output = 0;

for (digit=9;digit>0;digit--)
   for (temp=N;temp>0;temp/=10)
     if (temp%10==digit) output = output + digit*10;

return output;
}
