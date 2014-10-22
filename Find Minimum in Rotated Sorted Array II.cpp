class Solution { //my solution
public:

	int helper(vector<int> &num, int st, int end) {
		if (st == end)
			return num[st];
		if (end - st == 1)
			return (num[st] > num[end]) ? num[end] : num[st];
		int mid = st + (end - st + 1) / 2;
	//	if ((num[mid] == num[st]) && (num[mid] == num[end]))
	//		return num[st];
		if (num[mid] > num[end]) {
			if (num[end] <= num[st])
				return helper(num, mid, end);
			else
				return helper(num, st, mid);
		}

        else if (num[mid] < num[end]) {
            if (mid < 1)
                return helper(num, mid, end);
            if (num[mid] < num[mid - 1])
                return helper(num, mid, end);
            if (num[mid] > num[mid - 1])
                return helper(num, st, mid - 1);
            else {
                int ori_mid = mid;
                mid--;
                while (mid >= 0)  {
                    if (num[mid] < num[mid + 1])
                        return helper(num, st, ori_mid);
                    else if (num[mid] > num[mid+1])
                        return helper(num, ori_mid, end);
                    mid--;
                }
                return helper(num, ori_mid, end);
            }
        } else if (num[mid] == num[end]) {
            return min(helper(num, st, mid),helper(num,mid+1,end));
        }


	}

	int findMin(vector<int> &num) {
		int len = num.size();
		if (len == 1)
			return num[0];
		return helper(num, 0, len - 1);

	}

};




//better solution


    int findMin(vector<int> &num) {
        int start=0, end=num.size()-1;
        while(start<end) {
            if(num[start]==num[end]) {
                while(start<end && num[start]==num[end])
                    start++;               
            }
            else {
                int mid = start+(end-start)/2; 
                if(num[mid]>num[end])
                    start = mid+1;
                else
                    end = mid;
            }
        }
        return num[start];
    }
