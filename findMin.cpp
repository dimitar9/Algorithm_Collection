class Solution {
public:

    int helper(vector<int> &num, int st, int end) {
        if (st == end) return num[st];
        if (end-st == 1) return (num[st] > num[end] )? num[end]:num[st];
        int mid = st+(end-st+1)/2;
        if ((num[mid]  > num[st]) && (num[mid] < num[end])  ) {
            return num[st]; // easy to make mistake, not 0, it's 'st'
        } else if ((num[mid]  > num[st]) && (num[mid] > num[end])  )
        {
            return helper(num,mid+1,end);
        } else if ((num[mid]  < num[st]) && (num[mid] < num[end])  )
        {
            return helper(num,st,mid);
        }

    }

    int findMin(vector<int> &num) {
    int len = num.size();
    if (len ==1) return num[0];
    return helper(num,0,len-1);

    }




};
