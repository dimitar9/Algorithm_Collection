class Solution {
public:

    // RED< WHITE<BLUE
    void sortColors(int A[], int n) {
        if (n<=1) return;
        int r =0;
        int w = 0; //INPORTANT 
        int b = n-1;
        for(;w<=b;){
            switch (A[w]){
                case 0:
                        swap(A[w++],A[r++]);
                        break;
                case 1:
                        w++;
                        break;
                case 2: 
                    swap(A[b--],A[w]); //IMPORTANT HERE< DO NOT INCREASE W.
                    break;
            }
        }
   } 
};
