/*
有一堆query<ID, start_time, end_time>, 按照start_time 排序，
输出是<id, start/end, time>按照time排序，
我最开始说全排，面试官说没有那么多的内存，后来我就改进了一下但还是用了priorityqueue实现。

然后问我如果是multithread，每个thread处理的query是不overlap的，问时间复杂度是多少
*/

import java.util.*;

class Tests {
    public static void main(String... args) {
        int[] start = {1, 3, 5, 7, 9};
        int[] end = {4, 7, 10, 12, 18};
        Query[] query = new Query[start.length];
        for (int i = 0; i < start.length; ++i)
            query[i] = new Query(i, start[i], end[i]);
        Solution sol = new Solution();
        System.out.println(sol.sortEvents(query));
    }
}

public class Solution {
    public List<Event> sortEvents(Query[] queries) {
        List<Event> ans = new ArrayList<>();
        PriorityQueue<Event> pq = new PriorityQueue<>();
        for (Query q : queries) {
            while (!pq.isEmpty() && pq.peek().time <= q.start)
                ans.add(pq.poll());
            ans.add(new Event(q.id, true, q.start));
            pq.offer(new Event(q.id, false, q.end));
        }
        while (!pq.isEmpty()) ans.add(pq.poll());
        return ans;
    }
}

class Query {
    public int id, start, end;
    public Query(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
}

class Event implements Comparable<Event> {
    public int id, time;
    public boolean isStart;
    public Event(int id, boolean isStart, int time) {
        this.id = id;
        this.isStart = isStart;
        this.time = time;
    }
    @Override
    public String toString() {
        return time+","+id;
    }
    @Override
    public int compareTo(Event that) {
        if (this.time < that.time) return -1;
        if (this.time > that.time) return +1;
        return 0;
    }
}
