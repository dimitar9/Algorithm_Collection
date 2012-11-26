class Solution {
public:
    vector<vector<int> > threeSum(vector<int> &num) {
    vector<vector<int> > *set = new vector<vector<int> >;
    sort(num.begin(), num.end());
    vector<int> b;
    b.reserve(num.size());
    for(int k = 0; k < num.size(); ++k)
    {   
        int c = num[k];
        for(int j = 0; j < k; ++j)
        {
            b[j] = -c - num[j];
        }
       
        int i = 0;
        int j =  k - 1 ;
        while(i < k && j > -1)
        {
            if (num[i] == b[j])
            {
                if(i >= j)
                {
                    break;
                }
                vector<int> tmp;
                tmp.push_back(num[i]);
                tmp.push_back(num[j]);
                tmp.push_back(num[k]);
                if(find(set->begin(), set->end(), tmp) == set->end())
                {
                    set->push_back(tmp);
                }
                ++i;
                --j;
            }
            else if(num[i] < b[j])
            {
                ++i;
            }
            else
            {
                --j;
            }
        }   
  
    }
    return *set;
       
    }
}
