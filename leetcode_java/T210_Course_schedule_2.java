public class Solution {



    private int[] solveByBFS(int[] incLinkCounts, List<List<Integer>> adjs){

    int[] order = new int[incLinkCounts.length];

    Queue<Integer> toVisit = new ArrayDeque<>();

    for (int i = 0; i < incLinkCounts.length; i++) {

        if (incLinkCounts[i] == 0) toVisit.offer(i);

    }

    int visited = 0;

    while (!toVisit.isEmpty()) {

        int from = toVisit.poll();

        order[visited++] = from;

        for (int to : adjs.get(from)) {

            incLinkCounts[to]--;

            if (incLinkCounts[to] == 0) toVisit.offer(to);

        }

    }

    return visited == incLinkCounts.length ? order : new int[0]; 

}

    

}
