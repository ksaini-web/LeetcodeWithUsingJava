class Solution {
    public int findPeakElement(int[] nums) {

        int maxnumber  = nums[0];
        int index  = 0 ;

        for(int i = 1;i<nums.length ;i++){

            if(nums[i]>maxnumber){

                maxnumber = nums[i];
                index  = i;

            }
        }
        return index;
        
    }
}
