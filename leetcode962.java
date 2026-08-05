class Solution {
    public int maxWidthRamp(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        // Build decreasing stack
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[i] < nums[stack.peek()]) {
                stack.push(i);
            }
        }

        int ans = 0;

        // Traverse from right
        for (int j = nums.length - 1; j >= 0; j--) {

            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                ans = Math.max(ans, j - stack.peek());
                stack.pop();
            }
        }

        return ans;
    }
}
