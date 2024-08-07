// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses

class ReverseParentheses {
    public String reverseParentheses(String str) {
                /*Algo  1.Reverse 2.Concat Repeat
        reverse until opening brace found, stop, start concating
        concat previous chars as it till opening brace('(')
        concact later cher as it till closing
        */

        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder current = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                stack.push(current);
                current = new StringBuilder();
            } else if (ch == ')') {
                current.reverse();
                current = stack.pop().append(current);
            } else {
                current.append(ch);
            }
        }

        return current.toString();



//         Stack<Character> st = new Stack<Character>();
//         String ans="";
//         boolean concat = false;
//         char ch1='\0';
//         for(int i=0;i<str.length();i++){
//             char ch = str.charAt(i);
//             if(ch !=')'){
//                 st.push(ch);
//                 System.out.println("-> "+st);
//             }
//             if(ch ==')')
//             {
//                 //pop until open brace found, and reverse that string
//                 while(st.size()>0){ //1.reverse logic
//                     System.out.println("in here: "+st.size());
//                     ch1 = st.pop();
//                     if(ch1 != '(')
//                     {
//                     System.out.println("popped ele: "+ch1);
//                     ans = ans+""+Character.toString(ch1);
//                     System.out.println("inside ans: "+ans);
//                     System.out.println("::str length: "+str.length()+" i-> "+i);
//                     if(i==str.length()-1){
//                     StringBuilder input1 = new StringBuilder(ans);
//                     input1 = input1.reverse();
//                     return input1.toString();
//                     }
//                     }
//                     else{
// //opening brace found, pop at and concat at start till another openign brace found
//                     concat = true;
//                     break;
//                 }
//             }
//             if(concat){
//             System.out.println("concating.. "+st.size()+" "+st+" ch1: "+ch1);
//                 while(st.size()>0){ //
//                     char ch2 = st.pop();
//                     if(ch2!='('){
//                         ans= ch2+ans;
//                     }else if(st.isEmpty()){
//                         System.out.println("stack became emtpy here...");
//                         System.out.println("str length: "+str.length()+" i-> "+i);
//                     }                    
//                 }
//             }
//             System.out.println("outside ans: "+ans+" st: "+st);
//             }
//         }
//         return ans;
    }
}