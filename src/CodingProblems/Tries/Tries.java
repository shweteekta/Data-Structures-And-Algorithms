package Tries;

public class Tries {
        TrieNode root;
        static class TrieNode {
            private final int ALPHABET_SIZE = 25;
            TrieNode[] nodes;
            boolean isEndNode;
            public TrieNode(){
                nodes = new TrieNode[ALPHABET_SIZE];
                isEndNode = false;
            }
        }
        Tries(){
            root = new TrieNode();
        }
        public void insert(String word){
            char[] characters = word.toCharArray();
            TrieNode current = root;
            for (char ch: characters) {
                int index = ch - 'a';
                if(current.nodes[index] == null){
                    current.nodes[index] = new TrieNode();
                }
                current = current.nodes[index];
            }
            current.isEndNode = true;
        }

    public boolean search(String word) {
        TrieNode node = searchNode(word);
        return node != null && node.isEndNode;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchNode(prefix);
        return node != null;
    }

    private TrieNode searchNode(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.nodes[index] == null) {
                return null;
            }
            current = current.nodes[index];
        }
        return current;
    }

    public static void main(String[] args){
            Tries tries = new Tries();
            tries.insert("shweta");
        System.out.println(tries.search("shweta"));
        System.out.println(tries.startsWith("fh"));
    }


}
