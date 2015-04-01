public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int newbit = 1;
        for(int i =0; i < len; i++){
            if(digits[i]!=9){
                newbit = 0;
            }
        }
        int[]ret = new int[len+newbit];
        if(digits[len-1]<=8){
            for(int i = 0; i < len; i++){
                ret[i]=digits[i];
            }
            ret[len-1]++;
            return ret;
        } else{
            int carry = 1;
            for(int i = len-1; i >=0; i--){
                if((digits[i]+carry)>=10){
                    ret[i] = 0;
                    carry = 1;
                } else {
                    ret[i]=digits[i]+carry;
                    carry = 0;
                }
            }
        }
        if(newbit==1){
            ret[0]=1;
        }
        return ret;
        
    }
}
