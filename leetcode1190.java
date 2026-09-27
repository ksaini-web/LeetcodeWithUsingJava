class Solution {
    public String reverseParentheses(String s) {

        
    String reverse = "";

    Stack<String> stack = new Stack<>();

    for(char ch : s.toCharArray()){

        

        if(ch == '('){
           
           stack.push(reverse);
           reverse = "";
        }
        else if(ch == ')'){

            String temp = "";

            for(int i = reverse.length()-1 ;i>= 0;i--){

                temp += reverse.charAt(i);
            }
            
           reverse = stack.pop() + temp ;

        }
        else{

            reverse+=ch;
        }

        
    }


 return reverse;
    

        
    }
}
