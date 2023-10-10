import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class concatinate_word_problem {
    class Trie{
        Trie[] children;
        boolean isWord;

        public Trie(){
            children = new Trie[26];
            isWord = false;
        }
    }
    Trie root = new Trie();

    private void buildTrie(String word){
        Trie trie = root;

        for(char c : word.toCharArray()){
            if(trie.children[c-'a'] == null){
                trie.children[c-'a'] = new Trie();
            }
            trie = trie.children[c-'a'];
        }
        trie.isWord = true;
    }

    private boolean searchWord(String words, int count){
        Trie node = root;
        for(int i=0; i< words.length(); i++){
            char c = words.charAt(i);
            if(node.children[c-'a'] == null) return false;
            node = node.children[c-'a'];
            if(node.isWord && searchWord(words.substring(i+1),count+1)) return true;
        }
        count++;
        return (count >1 && node.isWord) ? true : false;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a, b)-> a.length()-b.length());
        ArrayList<String> result = new ArrayList<>();

        for(String word : words){
            if(searchWord(word, 0)){
                result.add(word);
            }
            else buildTrie(word);
        }
        return result;
    }
}
