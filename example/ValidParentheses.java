// https://leetcode.com/problems/valid-parentheses

import java.util.Stack;
class ValidParentheses {
    public boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        if(str.length()<=1){
            return false;
        }
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(ch== '(' || ch== '{' || ch== '['){
                stack.push(ch);
            }else{
            if(!stack.isEmpty()){    
                char top = stack.pop();
                switch(ch){
                case ')':
                    if (top == '{' || top == '[')
                    return false;
                break;
                case '}':
                if (top == '(' || top == '[')
                    return false;
                break;
                case ']':
                if (top == '(' || top == '{')
                    return false;
                break;

                }
            }else{
                return false;
            } 
        }    
    }   
        return stack.isEmpty();        
    }
}