import java.util.*;
public class UnionSet {
    public static int  union(int arr1[], int arr2[]){
        HashSet <Integer> set= new HashSet<>();
                for(int i=0; i<arr1.length; i++){
                    set.add(arr1[i]);
                }
                for(int j=0; j<arr2.length; j++){
                    set.add(arr2[j]);
                } 
                System.out.print(set);
                return set.size();   
            }
    public static void main(String[] args){
        int arr1[]={1,2,3,4};
        int arr2[]={1,2,3,5,6,7,8};
        System.out.println(union(arr1,arr2));
    }        
    
}
