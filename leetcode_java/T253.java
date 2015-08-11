public class Solution {
class intervalComparator implements Comparator<Interval>{
    public int compare(Interval o1, Interval o2){
        return o1.start-o2.start;
    }
}
public int minMeetingRooms(Interval[] intervals) {
    Arrays.sort(intervals, new intervalComparator());
    List<List<Interval>> list = new ArrayList<>();
    for(int i=0; i<intervals.length; i++){
        int idx = findIdx(list, intervals[i]);
        if(list.size()==0 || idx==-1){
            List<Interval> tmp = new ArrayList<>();
            tmp.add(intervals[i]);
            list.add(tmp);
        }else{
            list.get(idx).add(intervals[i]);
        }
    }
    return list.size();
}
public int findIdx(List<List<Interval>> list, Interval interval){
    int idx = -1;
    int min=Integer.MAX_VALUE;
    for(int i=0; i<list.size(); i++){
        if(interval.start>=list.get(i).get(list.get(i).size()-1).end){
            return i;
        }
    }
    return idx;
}

}
