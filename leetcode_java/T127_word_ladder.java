public class Solution {
public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
    wordDict.add(endWord);
    if(beginWord.equals(endWord)) return 0;
    int levelLeft=0, levelRight=0, len=beginWord.length();
    Set<String> setLeft=new HashSet<String>();
    Set<String> setRight=new HashSet<String>();
    setLeft.add(beginWord);
    setRight.add(endWord);
    while(setLeft.size()>0 && setRight.size()>0){
        if(setLeft.size()<=setRight.size()){
            levelLeft++;
            if(bfs(setLeft, setRight, wordDict)) return levelLeft+levelRight+1;
        }
        else{
            levelRight++;
            if(bfs(setRight, setLeft, wordDict)) return levelLeft+levelRight+1;
        }
    }
    return 0;
}
public boolean bfs(Set<String> set, Set<String> targetSet, Set<String> wordDict){
    Set<String> nSet=new HashSet<String>();
    for(String word : set){
        for(int i=0;i<word.length();i++)
            for(char c='a';c<='z';c++){
                if(c==word.charAt(i)) continue;
                String nWord=word.substring(0, i)+Character.toString(c)+word.substring(i+1, word.length());
                if(targetSet.contains(nWord)) return true;
                if(wordDict.contains(nWord)){
                    wordDict.remove(nWord);
                    nSet.add(nWord);
                }
            }
    }
    set.removeAll(set);
    set.addAll(nSet);
    return false;
}

}
