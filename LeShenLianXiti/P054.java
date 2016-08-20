/*
字符串压缩问题：经典的地里出现过的String压缩编码解码类似题,
后悔当时看到没有好好写过一遍.给一个String比如"abcdfffffffxyz",
写两个methods, encode和decode. encode就是比如"fffffff"变成"7xf",
decode就是要变为原字符串.我说"ff"怎么办,他说变成"2xf"你不觉得更长了吗?
我才明白了,应该是encoded后的String要比原来的短
写完以后他就问我如果原String本来就是"5xt"这种结构,我encode应该怎么处理?
"1x51xx1xq"就好了.. 还讨论了好多种情况, 最后一种是"1aaaaa"这种情况怎么变,
我说"1x15xa". 他说这是6个字符,能不能只用5个? 实在想不出来,这时候第三个小哥进来了,
韩国哥哥就过来告诉我说,其实看做1a和aaaa两部分encode就好....

General Rule:
1. correct decode
2. shortest possible

Details:

decode:
   find the pattern <digits>[x][any] and decompress

encode:

0. <not_digit> greedy compress

find the digits there are three seneriaos:
1. <digits>[x][any]
    all the digits has to be compressed no matter what
2. <digits>[not_x][any]
    dp to find the highest gain for compress digits.
    if the highest gain compress to the end, then treat the rest normally
    if the highest gain not goes to the end, then single out [not_x] and treat the rest normally.
3. <digits>[any]
    dp to find the hightest gain for compress digits.
*/

import org.junit.Test;

import static org.junit.Assert.*;

public class Tests {
    @Test
    public void test() {
        String[] words = {
                "", "1", "x", "a", "1x", "1a", "xa", "1xa",
                "1aaaaa", "1aaaaaaaa", "138281773x", "1238721912a", "1782183728xa",
                "aadabbaa12111212111111111aaaaa", "aaaaaaaa1111122111111111aaaaa",
                "aaaaaaaa1111122111111111xxxxxx",
        };

        for (String s : words) {
            String t = Codec.compress(s);
            String d = Codec.decompress(t);
            System.out.println(s + " -> " + t);
            assertEquals(s, d);
        }
    }
}

class Codec {
    public static String compress(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        for (int i = 0, j = 0; i < n; i = j) {
            // find consecutive non digits
            while (j < n && !Character.isDigit(s.charAt(j))) ++j;
            encode(ans, s, i, j, false);
            i = j;
            if (i == n) break;
            // find consecutive digits
            while (j < n && Character.isDigit(s.charAt(j))) ++j;
            if (j == n || j + 1 == n || s.charAt(j) != 'x') {
                if (!encodeAllDigits(ans, s, i, j)) {
                    if (j < n) ans.append(s.charAt(j));
                    j++;
                }
            } else
                encode(ans, s, i, j, true); //force encode everything
        }
        return ans.toString();
    }

    private static boolean encodeAllDigits(StringBuilder ans, String s, int start, int end) {
        int currGain = 0, maxGain = 0, last = start;
        for (int i = start, j = start; i < end; i = j) {
            while (j < end && s.charAt(j) == s.charAt(i)) ++j;
            currGain += (j - i) - String.valueOf(j - i).length() - 2;
            if (currGain >= maxGain) {
                maxGain = currGain;
                last = j;
            }
        }
        encode(ans, s, start, last, true);
        if (last < end) ans.append(s.substring(last, end));
        return last == end;
    }

    private static void encode(StringBuilder ans, String s, int start, int end, boolean force) {
        for (int i = start, j = start; i < end; i = j) {
            while (j < end && s.charAt(j) == s.charAt(i)) ++j;
            if (force || j - i >= 3)
                ans.append(j - i).append('x').append(s.charAt(i));
            else
                ans.append(s.substring(i, j));
        }
    }

    public static String decompress(String t) {
        StringBuilder ans = new StringBuilder();
        int n = t.length(), i, j;
        //[i, j) are digits
        for (i = 0, j = 0; j < n; ++j) {
            if (!Character.isDigit(t.charAt(j))) {
                if (t.charAt(j) == 'x' && i < j && j + 1 < n)
                    decode(ans, t, i, ++j);
                else
                    ans.append(t.substring(i, j + 1));
                i = j + 1;
            }
        }
        if (i < n)
            ans.append(t.substring(i));
        return ans.toString();
    }

    private static void decode(StringBuilder ans, String t, int i, int j) {
        char ch = t.charAt(j);
        int m = Integer.valueOf(t.substring(i, j - 1));
        for (int k = 0; k < m; ++k) ans.append(ch);
    }
}
