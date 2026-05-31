class BST {

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

   
    public static boolean search(Node root, int key) {

        if (root == null) { 
            return false;
        }

        if (root.data > key) {
            return search(root.left, key);

        } else if (root.data == key) {
            return true;

        } else {
            return search(root.right, key);
        }
    }
    
     public static  Node delete (Node root, int val ){
        if(root.data>val){
            root.left=delete(root.left,val);
        }else if(root.data<val){
            root.right=delete(root.right,val);
        }else { //case 1
            if(root.left==null && root.right==null){
            return null;
        }//case 2
        if(root.left==null){
            return root.right;
        }else if(root.right==null){
            return root.left;
        }
        //case 3
           Node IS=inorderSuccessor(root.right);
            root.data=IS.data;
            root.right=delete(root.right,IS.data);
           }  
           return root;
     }
     
   public static Node inorderSuccessor(Node root){
    while(root.left!=null){
       root=root.left;
    }
    return root;
   }

    public static void inorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void postorder(Node root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        inorder(root.right);
        System.out.print(root.data + " ");
    }

    public static void preorder(Node root) {

        if (root == null) {
            return;
        }
 System.out.print(root.data + " ");
        inorder(root.left);
        inorder(root.right);
    }


    public static void main(String[] args) {

        int values[] = {1, 7, 4, 5, 8, 0};

        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        if (search(root, 1)) {
            System.out.println("Found");
        } else {
            System.out.println("Not Found");
        }
        delete(root,1);
        inorder(root);

        System.out.print("inoder=");
        inorder(root);

          System.out.print("postoder=");
        postorder(root);

          System.out.print("inoder=");
        preorder(root);
    }
}