package src.Google_Topic.Onsite;

import java.util.*;

/**
 * Created by stameying on 3/30/16.
 */
public class p212_WordSearch2 {



    public class Solution {
        public List<String> findWords(char[][] board, String[] words) {
            List<String> list = new ArrayList<>();
            Trie trie = new Trie();
            for (String word : words) {
                trie.insertWord(word);
            }

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    dfs(board, i, j, trie.root, "", list);
                }
            }

            return list;
        }

        public void dfs(char[][] board, int x, int y, TrieNode node, String curWord, List<String> list) {
            char ch = board[x][y];
            if (!validPos(x, y, board) || board[x][y] == '#' || node.next[ch-'a'] == null) return;
            node = node.next[ch-'a'];
            curWord += ch;
            if (node.isLeaf) {
                list.add(curWord);
            }
            board[x][y] = '#';
            if (x > 0) dfs(board, x - 1, y, node, curWord, list);
            if (y > 0) dfs(board, x, y - 1, node, curWord, list);
            if (x < board.length - 1) dfs(board, x + 1, y, node, curWord, list);
            if (y < board[0].length - 1) dfs(board, x, y + 1, node, curWord, list);
            board[x][y] = ch;
        }


        public boolean validPos(int x, int y, char[][] board) {
            if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
            return true;
        }

        // private class TrieNode {
        //     protected char ch;
        //     protected Map<Character, TrieNode> neighbors;
        //     protected boolean isWord;

        //     public TrieNode() {
        //         this.neighbors = new HashMap<>();
        //         this.isWord = false;
        //     }

        //     public TrieNode(char ch) {
        //         this.ch = ch;
        //         this.neighbors = new HashMap<>();
        //         this.isWord = false;
        //     }


        //     public void setChar(char ch) {
        //         this.ch = ch;
        //     }

        //     public char getChar() {
        //         return this.ch;
        //     }

        //     public Map<Character, TrieNode> getNeighbors() {
        //         return this.neighbors;
        //     }

        //     public boolean isWord() {
        //         return this.isWord;
        //     }

        // }

        // private class Trie {
        //     TrieNode root;

        //     public Trie() {
        //         root = new TrieNode();
        //     }

        //     public void insertWord(String word) {
        //         TrieNode cur = root;
        //         for (int i = 0; i < word.length(); i++) {
        //             char ch = word.charAt(i);
        //             if (cur.neighbors.containsKey(ch)) {
        //                 cur = cur.neighbors.get(ch);
        //             } else {
        //                 TrieNode node = new TrieNode(ch);
        //                 cur.neighbors.put(ch, node);
        //                 cur = node;
        //             }
        //         }
        //         cur.isWord = true;
        //     }

        // }
    }



    class TrieNode {
        // Initialize your data structure here.
        public char ch;
        public TrieNode[] next;
        public boolean isLeaf;
        public TrieNode() {
            this.next = new TrieNode[26];
            this.isLeaf = false;
        }

        public TrieNode(char ch) {
            this.ch = ch;
            this.next = new TrieNode[26];
            this.isLeaf = false;
        }
    }

    class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insertWord(String word) {
            TrieNode cur = root;
            char[] charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; i++){
                char ch = charArr[i];
                if (cur.next[ch-'a'] == null){
                    TrieNode next = new TrieNode(ch);
                    cur.next[ch-'a'] = next;
                    cur = next;
                }else{
                    cur = cur.next[ch-'a'];
                }
            }
            cur.isLeaf = true;
            return;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode cur = root;
            char[] charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; i++){
                char ch = charArr[i];
                if (cur.next[ch-'a'] == null){
                    return false;
                }else{
                    cur = cur.next[ch-'a'];
                }
            }
            if (cur.isLeaf){
                cur.isLeaf = false;
                return true;
            }
            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public String startsWith(String word) {
            TrieNode cur = root;
            char[] charArr = word.toCharArray();
            for (int i = 0; i < charArr.length; i++){
                char ch = charArr[i];
                if (cur.next[ch-'a'] == null){
                    return null;
                }else{
                    cur = cur.next[ch-'a'];
                }
            }
            if (cur.isLeaf){
                cur.isLeaf = false;
                return word;
            }else return "";
        }
    }



//    public List<String> findWords(char[][] board, String[] words) {
//        List<String> list = new ArrayList<>();
//        Trie trie = new Trie();
//        for (String word : words) {
//            trie.insertWord(word);
//        }
//
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[0].length; j++) {
//                dfs(board, i, j, trie.root, "", list);
//            }
//        }
//
//        return list;
//    }
//
//    public void dfs(char[][] board, int x, int y, TrieNode node, String curWord, List<String> list) {
//        char ch = board[x][y];
//        if (!validPos(x, y, board) || board[x][y] == '#' || !node.neighbors.containsKey(ch)) return;
//        node = node.neighbors.get(ch);
//        curWord += ch;
//        if (node.isWord) {
//            list.add(curWord);
//        }
//        board[x][y] = '#';
//        if (x > 0) dfs(board, x - 1, y, node, curWord, list);
//        if (y > 0) dfs(board, x, y - 1, node, curWord, list);
//        if (x < board.length - 1) dfs(board, x + 1, y, node, curWord, list);
//        if (y < board[0].length - 1) dfs(board, x, y + 1, node, curWord, list);
//        board[x][y] = ch;
//    }
//
//
//    public boolean validPos(int x, int y, char[][] board) {
//        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) return false;
//        return true;
//    }
//
//    private class TrieNode {
//        protected char ch;
//        protected Map<Character, TrieNode> neighbors;
//        protected boolean isWord;
//
//        public TrieNode() {
//            this.neighbors = new HashMap<>();
//            this.isWord = false;
//        }
//
//        public TrieNode(char ch) {
//            this.ch = ch;
//            this.neighbors = new HashMap<>();
//            this.isWord = false;
//        }
//
//
//        public void setChar(char ch) {
//            this.ch = ch;
//        }
//
//        public char getChar() {
//            return this.ch;
//        }
//
//        public Map<Character, TrieNode> getNeighbors() {
//            return this.neighbors;
//        }
//
//        public boolean isWord() {
//            return this.isWord;
//        }
//
//    }
//
//    private class Trie {
//        TrieNode root;
//
//        public Trie() {
//            root = new TrieNode();
//        }
//
//        public void insertWord(String word) {
//            TrieNode cur = root;
//            for (int i = 0; i < word.length(); i++) {
//                char ch = word.charAt(i);
//                if (cur.neighbors.containsKey(ch)) {
//                    cur = cur.neighbors.get(ch);
//                } else {
//                    TrieNode node = new TrieNode(ch);
//                    cur.neighbors.put(ch, node);
//                    cur = node;
//                }
//            }
//            cur.isWord = true;
//        }
//
//    }
//
}
