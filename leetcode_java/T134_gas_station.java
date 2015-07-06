public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
            int sum = 0;  
            int total = 0;  
            int j = -1;  
            for(int i = 0; i < gas.length ; ++i)  
            {  
                sum += gas[i]-cost[i];  
                total += gas[i]-cost[i];  
                if(sum < 0)  
                {  
                    j=i; sum = 0;   
                }  
            }  
            if(total<0) return -1;  
            else return j+1;  
    }
}
