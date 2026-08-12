class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        
        HashMap<Integer ,Integer> map = new HashMap<>();

        int left = 0 , ans =0  ;
        

        for(int i = 0;i<nums.length ;i++){

            
         
            map.put(nums[i] ,map.getOrDefault(nums[i],0)+1);



            while(map.get(nums[i]) > k){


                map.put(nums[left] , map.get(nums[left]) -1);
                left++;

            }

            ans = Math.max(ans,i-left +1);
           


            

            
        } 

        return ans;
    }
}
