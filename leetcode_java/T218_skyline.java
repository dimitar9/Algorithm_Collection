import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class T218_skyline {
    public List<int[]> getSkyline(int[][] buildings) {
    List<int[]> result = new ArrayList<>();
    List<int[]> height = new ArrayList<>();
    for(int[] b:buildings) {
        height.add(new int[]{b[0], -b[2]});
        height.add(new int[]{b[1], b[2]});
    }
    Collections.sort(height, (a, b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
    });
    System.out.println("sorted height is: " );
    for(int[] l :height){
    	for(int i = 0; i < l.length; i++){
    		System.out.println(l[i]);
    	}
    }
    Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
    pq.offer(0);
    int prev = 0;
    for(int[] h:height) {
        if(h[1] < 0) {
            pq.offer(-h[1]);
        } else {
            pq.remove(h[1]);
        }
        int cur = pq.peek();
        if(prev != cur) {
            result.add(new int[]{h[0], cur});
            prev = cur;
        }
    }
    return result;
}
    public static void main(String[] args){
    	int[][] buildings = { {2 ,9 ,10}, {3, 7, 15}, {5 ,12 ,12}, {15 ,20 ,10}, {19 ,24 ,8} }; 
    	T218_skyline t = new T218_skyline();
    	t.getSkyline(buildings);
   }
}

