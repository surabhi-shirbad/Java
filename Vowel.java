public class Vowel {
    public static void main(String[] args){
     int[] nums={1,2,3,4,5,6,7,8};
     int even=0;
     int odd= 0;

     for(int i=0; i<=nums.length;i++){
        if(i%2==0){
           even+=1;
        }
        else{
            odd+=1;
        }
        
     }
      System.out.println("even="+even);
        System.out.println("odd="+odd);
     }
    }
    

