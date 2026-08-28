class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();

        // Count characters in s
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Check whether s can form a palindrome
        int odd = 0;
        int middle = -1;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = i;
            }
        }

        if (odd > 1) {
            return "";
        }

        // Characters used in the left half
        int halfLen = n / 2;

        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++) {
            halfFreq[i] = freq[i] / 2;
        }

        String targetHalf = target.substring(0, halfLen);

        /*
         * Find the smallest possible half >= targetHalf.
         */
        String left = smallestHalf(halfFreq, targetHalf);

        if (left == null) {
            return "";
        }

        /*
         * Build the palindrome from that half.
         */
        String answer = makePalindrome(left, middle, n);

        /*
         * If it is already strictly greater, it is the answer.
         */
        if (answer.compareTo(target) > 0) {
            return answer;
        }

        /*
         * This means left == targetHalf and the resulting
         * palindrome is <= target.
         *
         * So we need the next permutation of left.
         */
        left = nextPermutation(left);

        if (left == null) {
            return "";
        }

        answer = makePalindrome(left, middle, n);

        return answer.compareTo(target) > 0 ? answer : "";
    }


    /*
     * Returns the smallest permutation of the available
     * characters which is >= target.
     */
    private String smallestHalf(int[] freq, String target) {

        int n = target.length();

        char[] result = new char[n];

        // Characters still available
        int[] remaining = freq.clone();

        for (int i = 0; i < n; i++) {

            int wanted = target.charAt(i) - 'a';

            /*
             * Case 1:
             * We can keep the prefix equal to target.
             */
            if (remaining[wanted] > 0) {

                result[i] = (char) ('a' + wanted);
                remaining[wanted]--;

                continue;
            }

            /*
             * We cannot use target[i].
             *
             * First try to put the smallest character
             * greater than target[i].
             */
            for (int c = wanted + 1; c < 26; c++) {

                if (remaining[c] > 0) {

                    result[i] = (char) ('a' + c);
                    remaining[c]--;

                    fillSmallest(
                        result,
                        i + 1,
                        remaining
                    );

                    return new String(result);
                }
            }

            /*
             * No greater character is possible here.
             *
             * Backtrack.
             */
            for (int pos = i - 1; pos >= 0; pos--) {

                // Return the character used at pos
                int previous = result[pos] - 'a';
                remaining[previous]++;

                int wantedAtPos = target.charAt(pos) - 'a';

                /*
                 * Try to increase this position.
                 */
                for (int c = wantedAtPos + 1; c < 26; c++) {

                    if (remaining[c] > 0) {

                        result[pos] = (char) ('a' + c);
                        remaining[c]--;

                        fillSmallest(
                            result,
                            pos + 1,
                            remaining
                        );

                        return new String(result);
                    }
                }
            }

            // No permutation >= target exists
            return null;
        }

        /*
         * We successfully constructed target itself.
         */
        return new String(result);
    }


    /*
     * Fill result[start...] using the smallest
     * possible characters.
     */
    private void fillSmallest(
        char[] result,
        int start,
        int[] remaining
    ) {

        int index = start;

        for (int c = 0; c < 26; c++) {

            while (remaining[c] > 0) {

                result[index++] = (char) ('a' + c);
                remaining[c]--;
            }
        }
    }


    /*
     * Standard next lexicographical permutation.
     */
    private String nextPermutation(String str) {

        char[] a = str.toCharArray();

        int i = a.length - 2;

        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }

        // Already the largest permutation
        if (i < 0) {
            return null;
        }

        int j = a.length - 1;

        while (a[j] <= a[i]) {
            j--;
        }

        // Swap
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        // Reverse suffix
        int left = i + 1;
        int right = a.length - 1;

        while (left < right) {

            temp = a[left];
            a[left] = a[right];
            a[right] = temp;

            left++;
            right--;
        }

        return new String(a);
    }


    /*
     * Convert left half into a palindrome.
     */
    private String makePalindrome(
        String left,
        int middle,
        int n
    ) {

        StringBuilder result = new StringBuilder();

        // Left half
        result.append(left);

        // Middle character for odd length
        if (n % 2 == 1) {
            result.append((char) ('a' + middle));
        }

        // Right half = reverse(left)
        for (int i = left.length() - 1; i >= 0; i--) {
            result.append(left.charAt(i));
        }

        return result.toString();
    }
}
