import java.util.HashSet;
import java.util.Set;


public class findFactor {

	public static void main(String[] args){
		Set<Integer> arr = new HashSet<>();
        int x=48;
        int y=1;
        while(x!=1)
        {
            if(x%y==0)
            {
                x=x/y;
                arr.add(y);
                if(y==1)
                {
                    y++;
                }
            }
            else
            {
                y+=1;
            }
        }
        System.out.println(arr);
	}
}
