public class Solution {
    public int searchInsert(int[] A, int target) {
        int len = A.length;
        if(len==0) return -1;
        int mid = (len-1)/2;
        int st = 0;
        int end = len-1;
        while(st<end){
            mid = (st+end)/2;
            if(A[mid]==target){
                return mid;
            } else if(A[mid]<target){
                st=mid+1;
            } else if(A[mid]>target){
                end=mid-1;
            }
        }
        if(A[st]>=target){
            return st;
        }else{
            return st+1;
        }
        
    }
}
