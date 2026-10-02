class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        String[] map = {
            "",     "",     "abc",  "def",
            "ghi",  "jkl",  "mno",  "pqrs",
            "tuv",  "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), result, map);

        return result;
    }

    private void backtrack(
        String digits,
        int index,
        StringBuilder current,
        List<String> result,
        String[] map
    ) {
        // We have processed all digits
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            current.append(ch);

            backtrack(digits, index + 1, current, result, map);

            // Undo the choice
            current.deleteCharAt(current.length() - 1);
        }
    }
}
