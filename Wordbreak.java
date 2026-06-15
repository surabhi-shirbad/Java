public class Wordbreak {

    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
    }

    static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String key) {
        Node curr = root;

        for (int i = 0; i < key.length(); i++) {
            int idx = key.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public static boolean wordBreak(String key) {
        if (key.length() == 0) {
            return true;
        }

        for (int i = 1; i <= key.length(); i++) {
            String first = key.substring(0, i);

            if (search(first) && wordBreak(key.substring(i))) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        String words[] = {
            "i", "like", "sam", "samsung", "mobile"
        };

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        String key = "ilikesamsungmobile";

        System.out.println(wordBreak(key));
    }
}