package trie;

import java.util.Arrays;
import java.util.List;

public class TrieUtil {

    public static TrieNode createTrie(List<String> words) {
        TrieNode root = new TrieNode(null);
        words.forEach(word -> insertWordsIntoTrie(root,word));
        return root;
    }

    public static void insertWordsIntoTrie(TrieNode root, String word) {
        TrieNode current = root;

        for(int i=0;i<word.length();i++) {
            Character c = word.charAt(i);
            if(current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                TrieNode newTrieNode = new TrieNode(c);
                current.children.put(c,newTrieNode);
                current = newTrieNode;
            }
        }
    }

    public static TrieNode getSampleTrie() {
        return createTrie(Arrays.asList("Word", "Paper", "Willow", "Wasp", "Pay", "Pill", "Wood"));
    }
}
