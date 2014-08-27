
import java.util.ArrayList;
import java.util.Iterator;

public class GrayCode {

    // 392ms for 12 test cases
    public ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n < 0)      // Invalid input
            return result;
        result.add(0);
        if (n == 0)     // No bit
            return result;
        result.add(1);  // With one bit

        // Iteratively contruct the grey code of n bits on that of n-1 bits
        // gc(n) = gc(n-1) ... gc'(n-1)+2^(n-1), where
        // gc'(n-1) means the reverse sequence of gc(n-1), and +2^(n-1) means adding
        // 2^(n-1) to each number in the sequence
        for (int i = 2; i <= n; i++) {
            int size = result.size();
            for (int j = size-1; j >= 0; j--)
                result.add(result.get(j)+(1<<(i-1)));
        }

        return result;
    }
    
    public static void main(String [ ] args)
    {
        GrayCode gray = new GrayCode();
        ArrayList<Integer> ret =  gray.grayCode(4);
        Iterator<Integer> it = ret.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
    }
    }
}

