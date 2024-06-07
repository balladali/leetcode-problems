import java.util.List;

/*
    Link: https://leetcode.com/problems/replace-words
 */
public class ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for (String word: dictionary) {
            trie.insert(word);
        }

        StringBuilder builder = new StringBuilder();
        for (String word: sentence.split(" ")) {
            int index = trie.getPrefixEndForWord(word);
            if (index != -1) {
                builder.append(word, 0, index + 1);
            } else {
                builder.append(word);
            }
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}

class TrieNode {
    public TrieNode[] childNodes;
    public boolean isWordEnd;

    public TrieNode() {
        this.childNodes = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (currentNode.childNodes[index] == null) {
                currentNode.childNodes[index] = new TrieNode();
            }
            currentNode = currentNode.childNodes[index];
        }
        currentNode.isWordEnd = true;
    }

    public int getPrefixEndForWord(String word) {
        TrieNode currentNode = root;
        int result = 0;
        for (char c: word.toCharArray()) {
            int index = c - 'a';
            if (currentNode.childNodes[index] == null) {
                return -1;
            }
            if (currentNode.childNodes[index].isWordEnd) {
                return result;
            }
            result++;
            currentNode = currentNode.childNodes[index];
        }
        return -1;
    }
}
