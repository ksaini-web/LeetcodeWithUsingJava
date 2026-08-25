class Solution {
    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer>set = new HashSet<>();

        for(int num : nums){

            set.add(num);
        }

        int muiltiple = k;

        while(set.contains(muiltiple)){

            muiltiple+=k;
        }

        return muiltiple;
        
    }
}
