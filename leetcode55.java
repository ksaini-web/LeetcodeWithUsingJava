class Solution {
    public boolean canJump(int[] nums) {

    int fastest = 0;

    for(int i =0 ;i<nums.length ;i++)
    {
         if(i>fastest){
        return false;
     }
     
     fastest= Math.max(fastest,nums[i] + i);

    

     if(fastest>=nums.length-1){
        return true;
     }

    }
      return true;  
    }
}
