package solved.problem1to1000._201to300.Trie208;

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {}

    public TrieNode(char c) {
        TrieNode node = new TrieNode();
        node.val = c;
    }
}
class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()) {
            if(cur.children[ch-'a']==null) {
                cur.children[ch-'a'] = new TrieNode(ch);
            }
            cur = cur.children[ch-'a'];
        }
        cur.isWord=true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char ch : word.toCharArray()) {
            if(cur.children[ch-'a']==null) return false;
            cur = cur.children[ch-'a'];
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char ch : prefix.toCharArray()) {
            if(cur.children[ch-'a']==null) return false;
            cur = cur.children[ch-'a'];
        }
        return true;
    }
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        System.out.println(trie.startsWith("apple"));
        trie.insert("app");
        System.out.println(trie.search("app"));


    }
}
//
//public class Trie {
//    Set<String> words;
//    Set<String> prefixes;
//    public Trie() {
//        words = new HashSet<>();
//        prefixes = new HashSet<>();
//    }
//
//    public void insert(String word) {
//        words.add(word);
//        if (this.prefixes.contains(word)) {
//            return;
//        }
//        prefixes.add(word);
//        for (int i = 1; i < word.length(); i++) {
//            prefixes.add(word.substring(0, i));
//        }
//    }
//
//    public boolean search(String word) {
//        return words.contains(word);
//    }
//
//    public boolean startsWith(String prefix) {
//        return prefixes.contains(prefix);
//    }
//
//    public static void main(String[] args) {
//        Trie trie = new Trie();
//        trie.insert("apple");
//        System.out.println(trie.search("apple"));
//        System.out.println(trie.search("app"));
//        System.out.println(trie.startsWith("app"));
//        System.out.println(trie.startsWith("apple"));
//        trie.insert("app");
//        System.out.println(trie.search("app"));
//
//
//    }
//}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */