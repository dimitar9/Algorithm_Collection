class Solution {
public:
vector<string> generateParenthesis(int n) {
        vector<string> result;
        string candy;
        if ( n!=0)
            generate_p(result, candy, n);
        return result;
    }
    void generate_p(vector<string>& result, string& candy, int n){
        int leftp = 0; 
        int rightp = 0;
        int curr_len = candy.length();
        if (curr_len == n*2)
        {
            result.push_back(candy);
        }
        for(int i =0; i< curr_len; i++) {
            if (candy[i] == '(')
                leftp++;
            else
                rightp++;
        }
        if (leftp < n) {
            //*candy.append("(");
            candy.push_back('(');
            generate_p(result, candy, n);
            candy= candy.substr(0,candy.length()-1);
        }
         if ( (leftp > rightp) )
        {
            candy.push_back(')');
            generate_p(result,candy,n);
            candy= candy.substr(0,candy.length() - 1);
        }
        if(leftp > n) 
            return;
   } 
};
