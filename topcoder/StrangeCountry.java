import static java.util.Arrays.fill;
import static java.util.Arrays.sort;

public class StrangeCountry {

    private int[] redundantCount; //how many redundant edges are there in each component (i.e. that can be removed without disconnecting it). -1 means this is not a component
    private int[] finishTime;
    private int[] entryTime;  //what time we entered each node. Also used as the "seen" array.
    private int time = 0;
    int n;

    public int transform(String[] g) {
        n = g.length;
        if (thereIsDisconnectedVertex(g)) return -1;
        initialiseArrays();
        calculateCyclesPerComponent(g);
        int operations = mergeRedundantWithNonRedundantEdgeComponents();
        if (singleComponentLeft()) return operations;

        //Now there are at least two components left and they are either all Zeroes or all NonZeroes. Because if it was a 0 and a nonzero it would have been merged in the previous step
        //if they all have zero redundant edges it's impossible to merge them
        for (int i = 0; i < n; i++) if (redundantCount[i] == 0) return -1;

        //Otherwise all components have >0 redundant edges
        //2 components with redundant edges can be merged by doing 1 operation. So n components can be merged with n-1 operations
        int componentsLeft = 0;
        for (int i = 0; i < n; i++) {
            if (redundantCount[i] > 0) {
                componentsLeft++;
            }
        }
        return operations + (componentsLeft - 1);
    }

    private boolean thereIsDisconnectedVertex(String[] g) {
        for (String s : g) if (s.indexOf('Y') < 0) return true;
        return false;
    }

    private void calculateCyclesPerComponent(String[] g) {
        int component = 0;
        for (int i = 0; i < g.length; i++) {
            if (entryTime[i] == -1) {
                redundantCount[component] = 0;
                dfs(g, i, -1, component);
            }
            component++;
        }
    }

    private void dfs(String[] g, int u, int parent, int component) {
        entryTime[u] = time++;
        String potentialNeighbors = g[u];
        for (int v = 0; v < potentialNeighbors.length(); v++) {
            if (parent != -1 && v != parent && potentialNeighbors.charAt(v) == 'Y' && entryTime[v] != -1 && finishTime[v] == -1) {
                //v is still in progress - this is a backedge, so there is a cycle. unless it's to the immediate parent
                redundantCount[component]++;
            }
            if (potentialNeighbors.charAt(v) == 'Y' && entryTime[v] == -1) {
                dfs(g, v, u, component);
            }
        }
        finishTime[u] = time++;
    }

    private int mergeRedundantWithNonRedundantEdgeComponents() {
        int operations = 0;
        sort(redundantCount);
        int indexZeroRed = 0;   //index to the first zero-redundant-edges component
        while (redundantCount[indexZeroRed] == -1) indexZeroRed++;
        int indexRed = n - 1;   //index to the last components with redundant edges

        //Connect a component with redundant edges with a component without redundant edges by consuming a redundant edge
        while (redundantCount[indexRed] > 0 && redundantCount[indexZeroRed] == 0) {
            operations++;
            redundantCount[indexRed]--;   //reduce by 1 the number of redundant edges cause we used 1 to connect the two components
            if (redundantCount[indexRed] == 0) indexRed--;
            redundantCount[indexZeroRed] = -1; //this component doesn't exist anymore, it got merged!
            indexZeroRed++;
        }
        return operations;
    }


    private boolean singleComponentLeft() {
        int componentsLeft = 0;
        for (int i = 0; i < n; i++) if (redundantCount[i] != -1) componentsLeft++;
        if (componentsLeft == 1) return true;
        return false;
    }

    private void initialiseArrays() {
        entryTime = new int[n];
        finishTime = new int[n];
        redundantCount = new int[n];
        fill(entryTime, -1);
        fill(finishTime, -1);
        fill(redundantCount, -1);
    }

    public static void main(String[] args){
    	String[] in = 
    		{"NYYNN",
    		 "YNYNN",
    		 "YYNNN",
    		 "NNNNY",
    		 "NNNYN"};
    	StrangeCountry sc = new StrangeCountry();
    	int ret = sc.transform(in);
    	System.out.print(ret);
    }

}
