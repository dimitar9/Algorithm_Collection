public class bestTimeToBuySellStock {

public static void main(String [] args) 
{
	int [] prices = {1,2,3,4,5,6,7,8,9,10,2,3,4,5,6,7,8};

	int ret = maxProfit(prices);
	

	System.out.printf("return value is %d.\n",ret);
	
}




public static int maxProfit(int[] prices) {
	int min = Integer.MAX_VALUE;
	int max = 0;
	for( int i=0; i<prices.length; i++){
		max = Math.max(max,prices[i]-min);
		min = Math.min(min, prices[i]);
	}
	return max;
}



}
