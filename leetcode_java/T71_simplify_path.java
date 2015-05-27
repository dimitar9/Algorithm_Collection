public class Solution {
public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
    for (String dir : path.split("/")) {
        if (dir.equals("..") && !stack.isEmpty()) stack.pop();
        else if (!skip.contains(dir)) stack.push(dir);
    }
    String res = "";
    for (String dir : stack) res = res + "/" + dir; 
    return res.isEmpty() ? "/" : res;
}

}
