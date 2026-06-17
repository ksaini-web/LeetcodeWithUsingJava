class Solution {
    public char processStr(String s, long k) {
      
    StringBuilder str = new StringBuilder();

    for(int i =0 ;i<s.length() ;i++){

            char c = s.charAt(i);

            if(c == '*'){

                if(str.length()>0){

              str.deleteCharAt(str.length()-1);
                    
                }
            }else if(c == '#'){
                str.append(str.toString());
            }else if(c == '%'){
                str.reverse();
                 }
                 else{
                    str.append(c);
                 }


    }



    if(k>=0 && k < str.length()){

        return str.charAt((int)k);
    }
return '.';
        
    }
}
