public class Solution {
     List<String> resultList = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s) {
        String cur = "";
        gen(s, cur, 0);
        return resultList;
        
    }
    
    boolean gen(String s, String cur, int section){
        if((section==4) &&(s.isEmpty()))
        {
            resultList.add(cur);
            return true;
        }
        else if(section>=4) return false;
        for(int i = 0; i <s.length(); i++){
            if ((i==2) && ( Integer.parseInt(s.substring(0,3)) <= 255) && (!s.substring(0,1).equals("0"))){
                if(section!=0){
                    cur = cur + "." + s.substring(0,3);
                    gen(s.substring(3),cur, section+1);
                    cur = cur.substring(0,cur.length()-4);
                    
                }else{
                    cur = cur + s.substring(0,3);
                    gen(s.substring(3),cur, section+1);
                    cur = cur.substring(0,cur.length()-3);
                }
                
                
                
            }else if (i==0) {
                if(section!=0){
                    cur = cur + "." + s.substring(0,1);
                    gen(s.substring(1),cur, section+1);
                    cur = cur.substring(0,cur.length()-2);
                } else {
                    cur = cur  + s.substring(0,1);
                    gen(s.substring(1),cur, section+1);
                    cur = cur.substring(0,cur.length()-1);
                }
                
            }else if ((i==1) && (!s.substring(0,1).equals("0"))) {
                if(section !=0){
                    cur = cur + "." + s.substring(0,2);
                    gen(s.substring(2),cur, section+1);
                    cur = cur.substring(0,cur.length()-3);
                }else{
                    cur = cur + s.substring(0,2);
                    gen(s.substring(2),cur, section+1);
                    cur = cur.substring(0,cur.length()-2);
                }
               
            }
            
        }
        return true;
        
    }
}
