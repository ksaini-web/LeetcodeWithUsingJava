class Solution {
    public int minElement(int[] nums) {

int min = Integer.MAX_VALUE;
        for(int i = 0; i<nums.length ;i++){

            int temp = nums[i];

int sum =0;

            while(temp>0){

                int digit=temp%10;
               sum+=digit;

               temp=temp/10;

            }

            nums[i] = sum;
            min=Math.min(nums[i],min);
        }

        return min; 

        
        
    }


}
