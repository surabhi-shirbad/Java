public class BSTPRINTINRANGE {
    static class Node {
        int data;
        Node right;
        Node left;
        Node(int data) {
            this.data = data;
        }
    }
    public static Node insert(Node root, int val) {

        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static  void printInrange(Node root ,int X,int Y){
       if (root==null){
        return ;
       }
        if(root.data>=X && root.data<=Y){
            printInrange(root.left,X,Y);
            System.out.println(root.data+"");
            printInrange(root.right,X,Y);
        }
        else if (root.data>=Y){
            printInrange(root.left,X,Y);
        }else{
            printInrange(root.right,X,Y);
        }
    }

     public static void  inorder( Node root){
        if(root == null){
            return ;
        }
        inorder(root.left);
        System.out.print(root.data +"");
        inorder(root.right);
     }

public static void main (String[] args ){
    int values[]={3,5,7,6,8,5,88,56,10,4};
    Node root=null;

    for ( int i=0; i<values.length;i++){
        root = insert(root, values[i]);
    }
      inorder(root);
      System .out.print("");
       printInrange(root,3,8);
}
}
