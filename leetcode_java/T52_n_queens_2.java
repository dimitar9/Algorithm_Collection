public class Solution {
        public int totalNQueens(int n) {
        int ret=0;
        int[] loc = new int[n];
        ret = dfs(ret,loc,0,n);
        return ret;
    }
    
    public int dfs(int ret, int[] loc, int cur, int n){  
        if(cur==n)
           ret++;
        else{
            for(int i=0;i<n;i++){
                loc[cur]=i;
                if(isValid(loc,cur))
                    ret =dfs(ret,loc,cur+1,n);
            }
        }
        return ret;
    }
    
    public boolean isValid(int[] loc, int cur){
        for(int i=0; i<cur; i++){
            if(loc[i]== loc[cur] || Math.abs(loc[i]-loc[cur])==(cur-i) )
                return false;
        }
        return true;
    }
    

    
}
