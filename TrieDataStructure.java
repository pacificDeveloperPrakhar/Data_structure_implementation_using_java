public class TrieDataStructure {
    TrieNode root;

    public TrieDataStructure() {
        root = new TrieNode();
    }

    public class TrieNode {
        public TrieNode[] children;
        public boolean isEnd;

        TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public void insert(String key) {
        TrieNode pointer = root;
        for (int i = 0; i < key.length(); i++) {
            int wInd = key.charAt(i) - 'a';
            if (pointer.children[wInd] == null) {
                pointer.children[wInd] = new TrieNode();
            }
            pointer = pointer.children[wInd];
        }
        pointer.isEnd = true;
    }

    public boolean search(String key) {
        TrieNode pointer = root;
        for (int i = 0; i < key.length(); i++) {
            int wInd = key.charAt(i) - 'a';
            if (pointer.children[wInd] == null) {
                return false;
            }
            pointer = pointer.children[wInd];
        }
        return pointer.isEnd;
    }
    public boolean startsWith(String key)
    {
        TrieNode pointer=this.root;
        for (int i = 0; i < key.length(); i++) {
            int wInd=key.charAt(i)-'a';
            if(pointer.children[wInd]==null)
            return false;
            pointer=pointer.children[wInd];
        }
        return true;
    }

    public static void main(String[] args) {
        TrieDataStructure trie = new TrieDataStructure();

        // Insert words into the Trie
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        // Search for words in the Trie
        System.out.println("Search 'apple': " + trie.search("apple")); // Expected: true
        System.out.println("Search 'app': " + trie.search("app"));     // Expected: true
        System.out.println("Search 'bat': " + trie.search("bat"));     // Expected: true
        System.out.println("Search 'batman': " + trie.search("batman")); // Expected: false
        System.out.println("Search 'cat': " + trie.search("cat"));     // Expected: false
        System.out.println("Search 'cat': " + trie.startsWith("ap"));     // Expected: false
        System.out.println("Search 'cat': " + trie.startsWith("applet"));     // Expected: false
    }
}
