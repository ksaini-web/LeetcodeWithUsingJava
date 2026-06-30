class Solution {
    public String shiftingLetters(String s, int[] shifts) {

        long total = 0 ;

        char [] arr = s.toCharArray();

        for(int i = shifts.length-1 ;i>=0;i--){

            total = (total + shifts[i])%26;

            arr[i] = (char)('a' + (arr[i] - 'a' + total)%26);


        }

        return new String(arr);


        
    }
}
