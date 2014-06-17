class Solution:
    # @param s, a string
    # @return an integer
    def numDecodings(self, s):
        if s == '' or s[0] == '0': return 0
        dp = [1, 1]
        length = len(s)
        for i in xrange(2, length + 1):
            if 10 <= int(s[i-2:i]) <= 26 and '1' <= s[i-1] <= '9':
                dp.append(dp[i-1] + dp[i-2])
            elif 10 <= int(s[i-2:i]) <= 26:
                dp.append(dp[i-2])
            elif '1' <= s[i-1] <= '9':
                dp.append(dp[i-1])
            else:  # s[i] == '0'
                return 0
        return dp[length]
