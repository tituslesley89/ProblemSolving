package trie;

import util.ConsoleUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Autocomplete {

    public static List<String> fetchAutoCompelte(TrieNode root, String prefix) {

        TrieNode current = root;
        for(int i=0;i<prefix.length();i++) {
            Character c = prefix.charAt(i);
            if(current.children.containsKey(c)) {
                current = current.children.get(c);
            } else {
                return Collections.emptyList();
            }
        }

        return getAllSubtrees(current);
    }

    public static List<String> getAllSubtrees(TrieNode current) {
        List<String> completeStringList = new ArrayList<>();
        getAllSubtreesHelper(current, completeStringList,  "");
        return completeStringList;
    }

    public static void getAllSubtreesHelper(TrieNode current, List<String> completedStrings, String currentTrail) {
        if(current.children.isEmpty()) {
            completedStrings.add(currentTrail);
        }

        for(Map.Entry<Character, TrieNode> child : current.children.entrySet()) {
            getAllSubtreesHelper(child.getValue(), completedStrings, currentTrail + child.getKey());
        }
    }

    public static void main(String[] args) {
        TrieNode root = TrieUtil.getSampleTrie();
        List<String> words = fetchAutoCompelte(root, "Wo");
        ConsoleUtil.println("Autocomplete words:");
        words.forEach(word -> ConsoleUtil.println(word));
    }
}
