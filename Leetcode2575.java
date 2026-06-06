class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;

        for (int i = 0; i < n; i++) {
            total -= nums[i]; // right sum
            answer[i] = Math.abs(leftSum - total);
            leftSum += nums[i];
        }

        return answer;
    }
}
