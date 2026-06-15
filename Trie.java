

public class Trie {
    static class Node{
        Node childern[];
        boolean oew;
        Node(){
            childern= new Node[26];// ato z
            for(int i=0; i<26; i++){
                childern[i]=null;
            }
            oew=false;
        }
    }
    static Node root= new Node();  
    public static void insert(String word){
        Node curr= root;
        // word = word.toLowerCase();
        for ( int i =0; i<word.length();i++){
           int  idx=word.charAt(i)-'a';
            if (root.childern[i]== null){
                //create new node
               root.childern[idx]=new Node();
            }
            // if length are equal
            if (i == word.length()-1){   
                root.childern[idx].oew= true;
            }
            root=root.childern[idx];// update root vaule
        }
    } 
    public static boolean  serach(String key){
   Node curr= root;
        for( int i=0; i<key.length(); i++ ){
            int idx=key.charAt(i)-'a'; 
            Node node=root.childern[idx];
            if (node== null){
               return false;
            }   
            if(i==key.length()-1 && node.oew==false){
                return false;
            }   
            root=root.childern[idx];    
        }
        return true;

    }
    public static void main(String[] args){
        String words[]={"the", "a","there","their","any"};
        for(int i=0; i<words.length; i++){
          insert(words[i]);
        }
        System.out.println(serach("thier"));
        System.out.println(serach("thor"));
        System.out.println(serach("any"));
    }
    
}
