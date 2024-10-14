import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    Link: https://leetcode.com/problems/search-suggestions-system
    Algorithm: Trie
 */
public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        Trie root = new Trie();
        for (String p: products) {
            Trie current = root;
            for (char c: p.toCharArray()) {
                Trie node = current.nodes[c - 'a'];
                if (node == null) {
                    node = new Trie();
                }
                current.nodes[c - 'a'] = node;
                current = node;
                if (current.words.size() < 3) {
                    current.words.add(p);
                }
            }
        }

        Trie current = root;
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            int c = searchWord.charAt(i);
            if (current.nodes[c - 'a'] == null) {
                for (int j = i; j < searchWord.length(); j++) {
                    result.add(new ArrayList<>());
                }
                break;
            }
            result.add(current.nodes[c - 'a'].words);
            current = current.nodes[c - 'a'];
        }
        return result;
    }

    class Trie {
        public Trie[] nodes = new Trie[26];
        public List<String> words = new ArrayList<>();
    }
}
