class Solution {
    public int smallestIndex(int[] nums) {
      int index = 0;

        for(int num : nums){
           
           

            int sum = 0;
            while(num != 0){

                 sum += num%10;

                num = num/10;



            }

            if(sum == index){

                return index;
            }
            index++;
           

        

        }
           return -1;
        
    }
}
