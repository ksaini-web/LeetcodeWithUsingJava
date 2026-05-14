class Solution {
    public boolean isGood(int[] nums) {

        int n =0 ;

        for( int x : nums){

            n = Math.max(x,n);
        }

         if(nums.length != n+1){

            return false ;
         }

         int [] freq = new int[n+1];

         for(int x : nums) {

            if(x<1 || x>n){
                return false ;
            }

            freq[x]++;
         }

         for(int i = 1 ; i<n ; i++){

            if(freq[i] != 1){
                return false;
            }
         }

         return freq[n] == 2;
        
    }
}
