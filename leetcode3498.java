class Solution {
    public int reverseDegree(String s) {

        int index = 1;
        int sum  =0 ;


        for(char ch : s.toCharArray()){

            int value = 'z' - ch +1;   
               
          sum +=  value*index;

          index++;
        }
        return sum;
        
    }
}
