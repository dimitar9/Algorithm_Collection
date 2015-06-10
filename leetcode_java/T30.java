public class Solution
{
    public List<Integer> findSubstring(String S, String[] L)
    {
        final List<Integer> result = new ArrayList<>();
        if (L.length > 0 && L[0].length() > 0 && S.length() >= L.length * L[0].length())
        {
            final Map<String, Integer> dict = new HashMap<>();

            for (final String str : L)
            {
                dict.put(str, (dict.containsKey(str) ? dict.get(str) : 0) + 1);
            }

            final int len = L[0].length();
            // We only start from 0 ~ len - 1.
            for (int i = 0; i < len; ++i)
            {
                // This map is used to store the remained word count in the directory.
                Map<String, Integer> map = new HashMap<>(dict);
                // Use queue to store current sequence. All the words in queue also should be in map.
                final Queue<String> queue = new LinkedList<>();
                // Every time add one word.
                for (int j = i; (j + len) <= S.length(); j += len)
                {
                    final String str = S.substring(j, j + len);
                    // If this word is in directory.
                    if (dict.containsKey(str))
                    {
                        // Add the word into the sequence.
                        queue.add(str);
                        // We already have enough such word in the sequence so we need to move the starting point to next such word.
                        if (map.get(str) == 0)
                        {
                            while (!str.equals(queue.element()))
                            {
                                final String item = queue.remove();
                                map.put(item, map.get(item) + 1);
                            }

                            queue.remove();
                        }
                        else
                        {
                            map.put(str, map.get(str) - 1);
                        }

                        // There are enough words in the sequence.
                        if (queue.size() == L.length)
                        {
                            result.add(j - len * (L.length - 1));
                        }
                    }
                    else
                    {
                        queue.clear();
                        map = new HashMap<>(dict);
                    }
                }
            }
        }
        return result;
    }
}
