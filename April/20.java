// https://leetcode.com/problems/valid-parentheses

//Approach 1

class Solution {
    
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            
            if(st.isEmpty() || ch == '(' || ch == '{' || ch == '[') {
                
                st.push(ch);
                continue;
                
            }
            
            if(ch == ')') {
                
                if(st.peek() == '(') 
                    st.pop();
                
                else
                    return false;
                               
            }
            
            if(ch == '}') {
                
                if(st.peek() == '{') 
                    st.pop();
                
                else
                    return false;
                               
            }
            
            else if(ch == ']') {
                
                if(st.peek() == '[') 
                    st.pop();
                
                else
                    return false;
                               
            }
            
        }
        
        return st.isEmpty();
        
    }
}

// approach 2

class Solution {
    
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack();
        
        for(char ch : s.toCharArray()) {
            
            
            if(ch == '(') 
                st.push(')');
            
            else if(ch == '{') 
                st.push('}');
            
            else if(ch == '[') 
                st.push(']');
            
            else if(st.isEmpty() || st.peek() != ch) {
                
                return false;
                
            } 
            
            else {
                st.pop();
            }
   
        }
        
        return st.isEmpty();
    }
}