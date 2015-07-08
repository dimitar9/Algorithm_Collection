import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class ManhattanDistansIterator {


	    
	    PriorityQueue<Point> pList = null;
	    int len;
	    int index;
	    
	    public ManhattanDistansIterator(List<Point> points) {
	    	len = points.size();
	    	
	    	pList = new PriorityQueue<>(len, new Comparator<Point>() {
	    		public int compare(Point p1, Point p2){
	    			return (int) (Math.pow(p1.x, 2) + Math.pow(p2.x, 2) - Math.pow(p2.x, 2) - Math.pow(p2.x, 2));
	    		}
			});
	        for(Point p : points){
	        	pList.offer(p);
	        }
	    }

	    /** @return whether we have a next point  */
	    public boolean hasNext() {
	        return (!pList.isEmpty());
	        
	    }

	    /** @return the next nearest point */
	    public Point next() {
	        if(hasNext()){
	            return pList.poll();
	        } else {
	            return null;
	        }
	    }
	    
	    
	    public static void main(String[] args){
	    	List<Point> pointList = new ArrayList<>();
	    	Point p1 = new Point(1,4);
	    	Point p2 = new Point(2,2);
	    	Point p3 = new Point(0,1);
	    	Point p4 = new Point(5,9);
	    	pointList.add(p1);
	    	pointList.add(p2);
	    	pointList.add(p3);
	    	pointList.add(p4);
	    	ManhattanDistansIterator i = new ManhattanDistansIterator(pointList);
	    	while(i.hasNext()){
	    		System.out.print(i.next());
	    	}
	    }

}

class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString(){
		return "[" +x + "," + y + "] ";
	}
}
/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */



