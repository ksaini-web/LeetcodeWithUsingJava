class Solution {
    public int[] searchRange(int[] nums, int target) {

        int z = -1;
        int j = -1;

        for(int i = nums.length -1 ;i>= 0 ;i++){

            if(j == -1  && nums[i] == target){

                j = i;
                z=i;
            }else if(target == nums[i]){
    
    z=i;


            }


        }
       return new int[]{z,j};
       
        
    }
}
