
#使用BFS, 单词和length一块记录, dict中每个单词只能用一次, 所以用过即删。dict给的是set类型, 检查一个单词在不在其中(word in dict)为O(1)时间。设单词长度为L, dict里有N个单词, 每次扫一遍dict判断每个单词是否与当前单词只差一个字母的时间复杂度是O(N*L), 而每次变换当前单词的一个字母, 看变换出的词是否在dict中的时间复杂度是O(26*L), 所以要选择后者。Python真是慢啊, 同样的代码C++ 668ms过, Python 1416ms过。看到双向BFS的做法, 应该能更快, 再研究研究。

class Solution:
    # @param start, a string
    # @param end, a string
    # @param dict, a set of string
    # @return an integer
    def ladderLength(self, start, end, dict):
        dict.add(end)
        wordLen = len(start)
        queue = collections.deque([(start, 1)])
        while queue:
            curr = queue.popleft()
            currWord = curr[0]; currLen = curr[1]
            if currWord == end: return currLen
            for i in xrange(wordLen):
                part1 = currWord[:i]; part2 = currWord[i+1:]
                for j in 'abcdefghijklmnopqrstuvwxyz':
                    if currWord[i] != j:
                        nextWord = part1 + j + part2
                        if nextWord in dict:
                            queue.append((nextWord, currLen + 1))
                            dict.remove(nextWord)
        return 0
