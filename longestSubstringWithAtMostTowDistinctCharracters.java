    
public int lengthOfLongestSubstringTwoDistinct(String s) {

        HashMap<Character,Integer> hm = new HashMap<Character,Integer>();

        int len = s.length();

        int j = 0;

        int maxlen = 0;

        int curDistinctCount=0;

        for(int i =0; i < len; i++){

            if(hm.get(s.charAt(i))==null || hm.get(s.charAt(i))==0){

                hm.put(s.charAt(i), 1);

                curDistinctCount++;

            } else {

                hm.put(s.charAt(i), hm.get(s.charAt(i)+1));

            }

            if(curDistinctCount<=2){

                maxlen = Math.max(maxlen, i-j+1);

            } else {

                while(j<s.length() && hm.get(s.charAt(j))!=null && hm.get(s.charAt(j))!=1){

                    hm.put(s.charAt(j),hm.get(s.charAt(j))-1);

                    j++;

                } 

                if(j>=len) break;

                hm.put(s.charAt(j),0);

                curDistinctCount--;

                j++;

            }

        }

        return maxlen;

    }
