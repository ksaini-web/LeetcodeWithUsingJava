class Solution {
    public boolean checkValidString(String s) {

        int max = 0;
        int min = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                max++;
                min++;
            }
            else if (ch == ')') {
                max--;
                min--;
            }
            else { 
                max++;
                min--;
            }

          
            if (max < 0) {
                return false;
            }

            min = Math.max(min, 0);
        }

        return min == 0;
    }
}
