class Solution {
    public boolean checkRecord(String s) {

        int Absert = 0;
        int late = 0 ;
       


        for(int i = 0 ;i<=s.length() -1 ;i++){

           char ch = s.charAt(i);

           if(ch == 'A'){

            Absert++;
            late = 0;

            if(Absert >=  2){
                return false;
            }


           }
           else if(ch == 'L'){

            late++;

            if(late == 3){

                return false;
            }}
            else{
               late =0; 
            }
           
        }

        return true;
        
    }
}
