public class Bstrangesum {
 static class Node{
    
     int data;
     Node right;
      Node left;

      Node(int data){
        this.data=data;
       
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

 public static int rangeSum(Node root, int low, int high){
    if (root== null){
        return 0;
    }
    int sum = 0;
    if(root.data>=low && root.data<=high){
    sum+=root.data;
}
    sum+=rangeSum(root.left,low ,high);
    sum+=rangeSum(root.right,low,high);
    return sum;
 }
 public static void inorder(Node root){
    if( root== null){
        return;
    }
     inorder(root.left);
     System.out.println(root.data+"");
     inorder(root.right);
 }
 public static void main (String[] args){
    int values[]={10,5,3,7,15,18};
    Node root= null;
    for(int i=0; i<values.length;i++){
        root= insert(root, values[i]);
    }
    inorder(root);
    System.out.println();

    int sum=rangeSum(root,7,15);
    System.out.println("sum="+sum);

 }

}
