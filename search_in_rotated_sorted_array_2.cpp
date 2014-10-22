class Solution {
public:
 
    bool se(int st, int ed, int target, int A[]){
        if (st>ed) {return false;}
        else{
            int mid = st+(ed-st)/2;
            if (A[mid]==target){return true;}
             
            if (A[mid]>A[st]){
                if (target<=A[mid] && target>=A[st]){
                    return se(st,mid-1,target,A);
                }else{
                    return se(mid+1,ed,target,A);
                }
            }
             
            if (A[mid]<A[st]){
                 
                if (target<=A[mid] || target >= A[st]){  //IMPORTANT, note, it is OR here.
                    return se(st,mid-1,target,A);
                }else{
                    return se(mid+1,ed,target,A);
                }
                 
            }
             
            if (A[mid]==A[st]){return se(st+1,ed,target,A);}
             
            return false;
       } 
         
    }
 
    bool search(int A[], int n, int target) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        if (n==0){return false;}
        return  se(0,n-1,target,A);
    }
};


//note:
/*
the gist of this code is: for 2 branches, try to find one section we knoe it is monotonically increasing for sure.

*/
