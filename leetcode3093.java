class Solution {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];

        // best index for this suffix
        int idx = -1;
        int len = Integer.MAX_VALUE;
    }

    TrieNode root = new TrieNode();

    // update node with better candidate
    private void update(TrieNode node, int wordLen, int index) {

        if (wordLen < node.len) {
            node.len = wordLen;
            node.idx = index;
        }
        else if (wordLen == node.len && index < node.idx) {
            node.idx = index;
        }
    }

    private void insert(String word, int index) {

        TrieNode node = root;

        update(node, word.length(), index);

        // insert reversed word
        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                node.child[ch] = new TrieNode();
            }

            node = node.child[ch];

            update(node, word.length(), index);
        }
    }

    private int search(String word) {

        TrieNode node = root;

        // traverse reversed query
        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.child[ch] == null) {
                break;
            }

            node = node.child[ch];
        }

        return node.idx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int n = wordsQuery.length;

        // build trie
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer[i], i);
        }

        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = search(wordsQuery[i]);
        }

        return ans;
    }
}
