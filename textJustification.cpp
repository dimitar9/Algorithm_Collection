[LeetCode] Text Justification 解题报告

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces' ' when necessary so that each line has exactly L characters.
Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
For the last line of text, it should be left justified and no extra space is inserted between words.
For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.
Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.
Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.
» Solve this problem

[解题思路]
实现题，非算法题。但是写出来还真挺麻烦。这道题草稿只花了不到20分钟，但是让它能正确运行通过测试数据，我花了一个小时。

[Code]
1:       vector<string> fullJustify(vector<string> &words, int L) {   
2:            vector<string> result;   
3:            if(0 == words.size()) return result;     
4:            int i =0;   
5:            while(i< words.size())   
6:            {   
7:                 int start = i;   
8:                 int sum = 0;   
9:                 while(i<words.size() && sum + words[i].size()<=L)   
10:                 {   
11:                      sum+=words[i].size() +1;   
12:                      i++;   
13:                 }   
14:                 int end = i-1;    
15:                 int intervalCount = end - start;   
16:                 int avgSp = 0, leftSp = 0;   
17:                 if(intervalCount >0)   
18:                 {   
19:                      avgSp = (L-sum + intervalCount+1)/intervalCount;   
20:                      leftSp = (L-sum + intervalCount+1)%intervalCount;   
21:                 }      
22:                 string line;      
23:                 for(int j = start; j<end; j++)   
24:                 {   
25:                      line+=words[j];   
26:                      if(i == words.size()) // the last line  
27:                      line.append(1, ' ');   
28:                      else   
29:                      {   
30:                           line.append(avgSp, ' '); //average space  
31:                           if(leftSp>0) // the extra space  
32:                           {   
33:                                line.append(1, ' ');   
34:                                leftSp--;   
35:                           }   
36:                      }   
37:                 }   
38:                 line+=words[end];   
39:                 if(line.size()<L)   
40:                      line.append(L-line.size(), ' ');   
41:                 result.push_back(line);      
42:            }   
43:            return result;   
44:       }   
