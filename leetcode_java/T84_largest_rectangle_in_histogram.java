public class Solution {
public int largestRectangleArea(int[] height) {
    if (height==null) return 0;//Should throw exception
    if (height.length==0) return 0;

    Stack<Integer> index= new Stack<Integer>();
    index.push(-1);
    int max=0;

    for  (int i=0;i<height.length;i++){
            //Start calculate the max value
        while (index.peek()>-1)
            if (height[index.peek()]>height[i]){
                int top=index.pop();                    
                max=Math.max(max,height[top]*(i-1-index.peek()));  
            }else break;

        index.push(i);
    }
    while(index.peek()!=-1){
        int top=index.pop();
        max=Math.max(max,height[top]*(height.length-1-index.peek()));
    }        
    return max;
}

}
