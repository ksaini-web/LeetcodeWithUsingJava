class Solution {
    public int minimumDistance(int[] nums) {

        int ans = Integer.MAX_VALUE;
        
        HashMap<Integer , ArrayList<Integer>> map = new HashMap<>();

        for(int i =0 ; i<nums.length;i++){

           map.putIfAbsent(nums[i],new ArrayList<>());
           map.get(nums[i]).add(i); 
        }

        for(ArrayList<Integer> v : map.values()){

            if(v.size()<3){
                continue;
            }
            for(int i =2 ; i<v.size();i++){

                ans = Math.min(ans,2*(v.get(i)-v.get(i-2)));
            }

        }

        return ans == Integer.MAX_VALUE ? -1 : ans;    }
}
