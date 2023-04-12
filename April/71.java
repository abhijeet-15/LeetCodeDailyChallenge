// https://leetcode.com/problems/simplify-path/

// Using tokenizer

import java.util.StringTokenizer;    

class Solution {
    
    public String simplifyPath(String path) {
        
        String token = "";
        
        StringTokenizer ss = new StringTokenizer(path, "/");
        
        Stack<String> st = new Stack<>();
        
        while(ss.hasMoreTokens()) {
            
            token = ss.nextToken();
            
            if(token.equals("") || token.equals(".")) continue;
            
            if(!token.equals("..")) {
                
                st.push(token);
                
            }
            else if(!st.isEmpty()) {
                
                st.pop();
                
            }
            
        }
        
        StringBuilder result = new StringBuilder();
        
        if(st.isEmpty())
            return "/";
        
        while(!st.isEmpty()) {
            
            System.out.println(st.peek());
            
            StringBuilder temp = result;
            
            result = new StringBuilder();
            
            result = result.append("/").append(st.peek()).append(temp);
            
            st.pop();
            
        }
        
        return result.toString();
    }
}