package trie;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public Character character;

    public TrieNode() {
        this.children = new HashMap<>();
    }

    public TrieNode(Character c) {
        this.character = c;
        this.children = new HashMap<>();
    }
}
