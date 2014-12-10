class Solution {
public:
int candy(vector<int> &ratings) {
        int n=ratings.size();
        vector<int> r (n,1);
         
        if(n==0) return 0;
        for(int i=1; i<n;i++){
            if(ratings[i]>ratings[i-1])
                r[i]=r[i-1]+1;
        }
        for(int i=n-2; i>=0;i--){
            if(ratings[i]>ratings[i+1])
            {
                if (r[i] > r[i+1])
                    continue;
                else
                    r[i]=r[i+1]+1;
            }
                //r[i]=max(r[i],r[i+1]+1);
        }
        int res=0;
        for(int i=0;i<n;i++){
            res+=r[i];
        }
        return res;
    
}
};