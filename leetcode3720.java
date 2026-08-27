class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] f = freq.clone();

            boolean possible = true;

            for (int j = 0; j < i; j++) {
                int x = target.charAt(j) - 'a';

                if (f[x] == 0) {
                    possible = false;
                    break;
                }

                f[x]--;
            }

            if (!possible) {
                continue;
            }

            int cur = target.charAt(i) - 'a';

            for (int c = cur + 1; c < 26; c++) {
                if (f[c] > 0) {
                    StringBuilder ans = new StringBuilder(target.substring(0, i));

                    ans.append((char)('a' + c));
                    f[c]--;

                    for (int x = 0; x < 26; x++) {
                        while (f[x] > 0) {
                            ans.append((char)('a' + x));
                            f[x]--;
                        }
                    }

                    return ans.toString();
                }
            }
        }

        return "";
    }
}
