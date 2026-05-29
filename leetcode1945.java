class Solution {

    public int getLucky(String s, int k) {

        StringBuilder sb = new StringBuilder();

        // convert characters to numbers
        for (char ch : s.toCharArray()) {

            sb.append(ch - 'a' + 1);
        }

        String str = sb.toString();

        // perform k transformations
        while (k-- > 0) {

            int sum = 0;

            for (char ch : str.toCharArray()) {

                sum += ch - '0';
            }

            str = String.valueOf(sum);
        }

        return Integer.parseInt(str);
    }
}
