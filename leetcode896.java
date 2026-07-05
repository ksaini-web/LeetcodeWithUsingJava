class Solution {
    public boolean isMonotonic(int[] nums) {

        int dir = 0;

        for (int i = 1; i < nums.length; i++) {

            if (nums[i] == nums[i - 1]) continue;

            if (dir == 0) {
                dir = nums[i] > nums[i - 1] ? 1 : -1;
            } else if ((dir == 1 && nums[i] < nums[i - 1]) ||
                       (dir == -1 && nums[i] > nums[i - 1])) {
                return false;
            }
        }

        return true;
    }
}
