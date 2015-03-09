/*


There's a lot of concern in other posts about "aaaa...aab" test case that causes TLE when we run through our string not in reverse but from start to end. I've thought a bit on how to add a tiny modification and make just the whole thing more effective, not only pass the TLE case.

The approach is the same as before: we loop through all possible prefixes checking if it in the dictionary and caching the results.

But just before jumping into recursion we could also check that the right reminder has a prefix from the dictionary, because if it hasn't then there's no sense in splitting the reminder into sub-strings. It's just a linear check, which I think also could be optimized with some caching but even without optimization the solution is accepted. And also the code looks quite understandable.*/
public class Solution {

    private final Map<String, List<String>> cache = new HashMap<>();

    private boolean containsSuffix(Set<String> dict, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(i))) return true;
        }
        return false;
    }

    public List<String> wordBreak(String s, Set<String> dict) {
        if (cache.containsKey(s)) return cache.get(s);
        List<String> result = new LinkedList<>();
        if (dict.contains(s)) result.add(s);
        for (int i = 1; i < s.length(); i++) {
            String left = s.substring(0,i), right = s.substring(i);
            if (dict.contains(left) && containsSuffix(dict, right)) {
                for (String ss : wordBreak(right, dict)) {
                    result.add(left + " " + ss);
                }
            }
        }
        cache.put(s, result);
        return result;
    }
}
