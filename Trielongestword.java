public class Trielongestperffirx {

    static class Node {
        Node children[];
        boolean oew;

        Node() {
            children = new Node[26];
            oew = false;
        }
    }

    static Node root = new Node();

    public static void insert(String word) {
        word = word.toLowerCase(); // convert to lowercase

        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];

            if (i == word.length() - 1) {
                curr.oew = true;
            }
        }
    }

    public static String ans = "";

    public static void longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null && root.children[i].oew) {

                temp.append((char) (i + 'a'));

                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                longestWord(root.children[i], temp);

                temp.deleteCharAt(temp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {

        String words[] = {"banana","a","ap","app","appl","apple","apply"};

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        longestWord(root, new StringBuilder());

        System.out.println( ans);
    }
}