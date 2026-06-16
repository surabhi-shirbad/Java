public class Triewithstart {

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

   public static boolean withStart(String perfix){
    Node curr = root;
    for(int i=0; i<perfix.length(); i++){
        int idx= perfix.charAt(i)-'a';
        if( curr.children[idx]==null){
            return false;
            
        }
       curr= curr.children[idx];
    }
     return true;
   }
    public static void main(String[] args) {

        String words[] = {"i", "like", "sam", "samsung", "mobile"};
            String prefix="mob";

        for (int i = 0; i < words.length; i++) {
            insert(words[i]);
        }

        

        System.out.println(withStart(prefix));
    }
}
