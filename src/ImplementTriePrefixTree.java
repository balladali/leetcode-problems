/*
    Link: https://leetcode.com/problems/implement-trie-prefix-tree
 */
public class ImplementTriePrefixTree {
    private TrieNode root;

    public ImplementTriePrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (current.childNodes[index] == null) {
                current.childNodes[index] = new TrieNode();
            }
            current = current.childNodes[index];
        }
        current.isWordEnd = true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (current.childNodes[index] == null) {
                return false;
            }
            current = current.childNodes[index];
        }
        return current.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char c: prefix.toCharArray()) {
            int index = c - 'a';
            if (current.childNodes[index] == null) {
                return false;
            }
            current = current.childNodes[index];
        }
        return true;
    }

    class TrieNode {
        public TrieNode[] childNodes;
        public boolean isWordEnd;

        public TrieNode() {
            this.childNodes = new TrieNode[26];
        }
    }
}
