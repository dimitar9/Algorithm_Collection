[LeetCode] Simplify Path 解题报告

Given an absolute path for a file (Unix-style), simplify it.
For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
» Solve this problem

[解题思路]
利用栈的特性，如果sub string element
1. 等于“/”，跳过，直接开始寻找下一个element
2. 等于“.”，什么都不需要干，直接开始寻找下一个element
3. 等于“..”，弹出栈顶元素，寻找下一个element
4. 等于其他，插入当前elemnt为新的栈顶，寻找下一个element

最后，再根据栈的内容，重新拼path。这样可以避免处理连续多个“/”的问题。


[Code]
1:       string simplifyPath(string path) {   
2:            // Start typing your C/C++ solution below   
3:            // DO NOT write int main() function   
4:            vector<string> stack;   
5:            assert(path[0]=='/');   
6:            int i=0;   
7:            while(i< path.size())   
8:            {   
9:                 while(path[i] =='/' && i< path.size()) i++; //skip the begining '////'  
10:                 if(i == path.size())   
11:                      break;   
12:                 int start = i;   
13:                 while(path[i]!='/' && i< path.size()) i++; //decide the end boundary  
14:                 int end = i-1;   
15:                 string element = path.substr(start, end-start+1);   
16:                 if(element == "..")   
17:                 {   
18:                      if(stack.size() >0)   
19:                      stack.pop_back();   
20:                 }   
21:                 else if(element!=".")   
22:                 stack.push_back(element);      
23:            }   
24:            if(stack.size() ==0) return "/";   
25:            string simpPath;   
26:            for(int i =0; i<stack.size(); i++)   
27:            simpPath += "/" + stack[i];   
28:            return simpPath;   
29:       }   





class Solution {
private:
    string outputPath(vector<string>& dirs){
        if (dirs.empty()){
            return "/";
        }
        string out;
        for (int i = 0; i < dirs.size(); i++){
            out += "/" + dirs[i];
        }
        return out;
    }
public:
    string simplifyPath(string path) {
        vector<string> dirs;
        string cur;
        path += '/';
        for (char& c : path){
            if (c != '/'){
                cur += c;
            } else { //c == "/"
                if (cur == ".."){
                    if (!dirs.empty()){
                        dirs.pop_back();
                    }
                } else if (cur != "." && cur != ""){
                    dirs.push_back(cur);
                }
                cur = "";
            }
        }
        return outputPath(dirs);
    }
};
