class Solution {
     
     private void resvers(int [] nums , int left , int right){

        while(left<right){

        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
        left++;
        right--;

     }}

    public void rotate(int[] nums, int k) {

       k= k%nums.length;

        resvers(nums,0,nums.length-1);
        resvers(nums,0,k-1);
        resvers(nums,k,nums.length-1);

        
    }
}
