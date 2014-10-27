class Solution {
public:
    int maxArea(vector<int> &height) {
        
        int maxarea = 0;
        int i = 0; int j = height.size();
        if (j == 1) return height[0];
        j--;
        while(i<j){
            if( (j-i) * min(height[i],height[j]) > maxarea)
                maxarea = (j-i) * min(height[i],height[j]) ;
            if (height[i] > height[j])
            {
                j--;
                
            }   else
            {
                i++;
            }
        
        }
        return maxarea;
        
    }
};
