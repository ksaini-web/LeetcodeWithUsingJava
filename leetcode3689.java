class Solution {
    public long maxTotalValue(int[] nums, int k) {

        int maxvalue = Integer.MIN_VALUE;
        int minvalue = Integer.MAX_VALUE;

        for(int num : nums){

       maxvalue =Math.max(maxvalue,num);
       minvalue = Math.min(minvalue,num);


        }

        return 1L*k*(maxvalue-minvalue);
        
    }
}
