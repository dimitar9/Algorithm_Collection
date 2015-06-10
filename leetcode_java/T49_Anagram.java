public class Solution {
    public static List<String> anagrams(String[] strs) {

        HashMap<String, List<String>> hashMap= new HashMap<String, List<String>>();
        List<String> anagramStrings = new ArrayList<String>();

        for (String str: strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            String mapKey = new String(charArray);

            if (hashMap.containsKey(mapKey)) {
                hashMap.get(mapKey).add(str);
            } else {
                List<String> stringList = new ArrayList<String>();
                stringList.add(str);
                hashMap.put(mapKey, stringList);
            }
        }

        for(Map.Entry<String, List<String>> entry: hashMap.entrySet()) {
            List<String> value = entry.getValue();

            if (value.size() > 1) {
                anagramStrings.addAll(value);
            }   
        }
        return anagramStrings;

    }

}
