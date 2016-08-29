public class Solution {
    
    HashSet<String> resSet = new HashSet<String>();
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word: words) {
            trie.insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for(int j=0; j<board[0].length; j++) {
                dfs(board, visited, i, j, trie, "");
            }
        }
        
        List<String> res = new ArrayList<String>();
        for(String word:resSet)
            res.add(word);
        return res;
    }
    
    public void dfs(char[][]board, boolean[][] visited, int i, int j, Trie trie, String word) {
        if(i<0 || i>=board.length || j<0 || j>=board[0].length)
            return;
            
        if(visited[i][j])
            return;
            
        word+=board[i][j];
        
        if (!trie.startsWith(word)) 
            return;
        
        if(trie.search(word))
            resSet.add(word);
        
        visited[i][j] = true;
        dfs(board, visited, i-1, j, trie, word);
        dfs(board, visited, i, j-1, trie, word);
        dfs(board, visited, i+1, j, trie, word);
        dfs(board, visited, i, j+1, trie, word);
        visited[i][j] = false;
    }
    
    class TrieNode {
        TrieNode[] branch;
        boolean isWord;
        public TrieNode() {
            branch = new TrieNode[26];
        }
    }
    
    public class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode cur = root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(cur.branch[c-'a']==null)
                    cur.branch[c-'a'] = new TrieNode();
                cur = cur.branch[c-'a'];
            }
            cur.isWord = true;
        }
        
        public boolean search(String word) {
            TrieNode cur = root;
            for(int i=0; i<word.length(); i++) {
                char c = word.charAt(i);
                if(cur.branch[c-'a']==null) return false;
                cur=cur.branch[c-'a'];
            }
            return cur.isWord==true;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for(int i=0; i<prefix.length(); i++) {
                char c = prefix.charAt(i);
                if(cur.branch[c-'a'] == null)
                    return false;
                cur= cur.branch[c-'a'];
            }
            return true;
        }
    }
}