class Solution {
public:
    bool isPalindrome(int x) {
        if(x<0) return false;
        int dev=1;
        while(x/dev >= 10)
        {
            dev *= 10;
        }
        while(x/dev > 0)
        {
            if((x%10) != (x/dev))
                return false;
            else {
                x %=dev;
                x /= 10;
                dev /= 100;
            }
        }
        return true;
    }
};
---> WRONG because this one will faile such as 100000021


next is right



class Solution {
public:
      bool isPalindrome(int x) {  
            if(x<0) return false;  
            int div = 1;  
            while(x/div >=10)  
                div*=10;  
            while(x>0)  
           {  
                 int l = x/div;  
              int r = x%10;  
                if(l!=r) return false;  
                 x=x%div/10;  
             div/=100;  
           }  
           return true;  
       }  
};
