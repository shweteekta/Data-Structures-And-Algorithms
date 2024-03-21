package Tries;

import java.util.HashMap;
import java.util.Map;
//Design a data structure that supports adding new words and finding if a string matches any previously added string.
//        Implement the WordDictionary class:
//        WordDictionary() Initializes the object.
//        void addWord(word) Adds word to the data structure, it can be matched later.
//        bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
public class WordDictionary {
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndNode;

        TrieNode() {
            this.children = new HashMap<>();
            this.isEndNode = false;
        }
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (Character ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndNode = true;
    }

    public boolean search(String word) {
        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, TrieNode node) {
        if (index == word.length()) {
            return node.isEndNode;
        }
        char ch = word.charAt(index);
        if (ch == '.') {
            for (TrieNode child : node.children.values()) {
                if (searchHelper(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            if (!node.children.containsKey(ch)) {
                return false;
            }
            return searchHelper(word, index + 1, node.children.get(ch));
        }

    }
}

