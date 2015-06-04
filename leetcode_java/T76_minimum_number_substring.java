1 java solution, use hashMap. a little bit slow:

public class Solution {
    public String minWindow(String S, String T) {
        Map<Character, Integer> pattern = new HashMap<Character, Integer>();
        Map<Character, Integer> cur = new HashMap<Character, Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        int min = Integer.MAX_VALUE;
        int begin = 0, end = 0;

        // fill in pattern by T
        for(int i = 0;i < T.length();i++) addToMap(pattern, T.charAt(i));

        // initialize current set
        for(int i = 0;i < T.length();i++) cur.put(T.charAt(i), 0);

        // go through S to match the pattern by minimum length
        for(int i = 0;i < S.length();i++){
            if(pattern.containsKey(S.charAt(i))){
                queue.add(i);
                addToMap(cur, S.charAt(i));
                // check if pattern is matched
                while(isMatch(pattern, cur)){  /* Important Code! */
                    if(i - queue.peek() < min){
                        min = i - queue.peek();
                        begin = queue.peek();
                        end = i+1;
                    }
                    cur.put(S.charAt(queue.peek()), cur.get(S.charAt(queue.peek()))-1);
                    queue.poll();
                }
            }
        }

        return end > begin?S.substring(begin, end):"";
    }

    private void addToMap(Map<Character, Integer> map, Character c){
        if(map.containsKey(c))
            map.put(c, map.get(c)+1);
        else
            map.put(c,1);
    }

    private boolean isMatch(Map<Character, Integer> p, Map<Character, Integer> cur){
        for(Map.Entry<Character, Integer> entry: p.entrySet())
            if(cur.get((char)entry.getKey()) < (int)entry.getValue()) return false;
        return true;
    }
}











2. cpp solution, use 2 pointers, i, j , and one 'require' array one 'chSet' array. one round iteration. fast


class Solution {
public:
    string minWindow(string S, string T) {
        if (S.empty() || T.empty())
        {
            return "";
        }
        int count = T.size();
        int require[128] = {0};
        bool chSet[128] = {false};
        for (int i = 0; i < count; ++i)
        {
            require[T[i]]++;
            chSet[T[i]] = true;
        }
        int i = -1;
        int j = 0;
        int minLen = INT_MAX;
        int minIdx = 0;
        while (i < (int)S.size() && j < (int)S.size())
        {
            if (count)
            {
                i++;
                require[S[i]]--;
                if (chSet[S[i]] && require[S[i]] >= 0)
                {
                    count--;
                }
            }
            else
            {
                if (minLen > i - j + 1)
                {
                    minLen = i - j + 1;
                    minIdx = j;
                }
                require[S[j]]++;
                if (chSet[S[j]] && require[S[j]] > 0)
                {
                    count++;
                }
                j++;
            }
        }
        if (minLen == INT_MAX)
        {
            return "";
        }
        return S.substr(minIdx, minLen);
    }
};
