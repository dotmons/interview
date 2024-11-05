package leetcode;

class Trie {
    public Trie[] trie;
    public boolean flag;

    public Trie() {
        trie = new Trie[26];
        flag = false;
    }

    public void insert(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int ind = c - 'a';
            if (node.trie[ind] == null) {
                node.trie[ind] = new Trie();
            }
            node = node.trie[ind];
        }
        node.flag = true;
    }


    public boolean search(String word) {
        Trie node = this;
        for (int i = 0; i < word.length(); i++) {
            int ind = word.charAt(i) - 'a';
            if (node.trie[ind] == null) {
                return false;
            }
            node = node.trie[ind];
        }
        return node.flag;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        for (int i = 0; i < prefix.length(); i++) {
            int ind = prefix.charAt(i) - 'a';
            if (node.trie[ind] == null) {
                return false;
            }
            node = node.trie[ind];
        }
        return true;
    }


    public static void main(String[] args) {
        //"apple"],["apple"],["app"],["app"],["app"],["app"]]
        //"insert","search","search","startsWith","insert","search"
        Trie trie = new Trie();
        trie.insert("apple");
        //System.out.println(trie.search("apple"));
//        System.out.println(trie.search("app"));
//        System.out.println(trie.startsWith("apple"));
//        trie.insert("app");
//        System.out.println(trie.search("app"));

    }
}



