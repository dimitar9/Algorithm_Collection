

    public int jump(int[] A) {
        int maxReach = A[0];
        int edge = 0;
        int minstep = 0;
        
        for(int i = 1; i < A.length; i++) {
            if (i > edge) {
                minstep += 1;
                edge = maxReach;
                if(edge > A.length - 1)
                    return minstep;
            }
            maxReach = Math.max(maxReach, A[i] + i);
            if (maxReach == i):
                return -1;
        }
        
        return minstep;
    } 

When iterate the array, I set an edge for the Search phase, 
which means that if I exceeds the edge, the minstep must 
add one and the maxReach will be update. And when the last 
index is within the range of the edge, output the minstep.

[2, 3, 1, 1, 4]

First, the edge is 0; Second, after start iterate the array,
it exceeds the edge 0 when reaching the A[0] and update the edge to 2; 
Third, after it reach the A[2], it exceeds the edge 2 and update the 
new edge to the maxReach 4. Finally, end of the array is inside the 
edge, output the minstep.
