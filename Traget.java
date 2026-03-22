public class Traget{
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        int target=6;
        for (int i=0; i<nums.length; i++){
            if(nums[i]>=target){
             System.out.println("index="+i);;
             return;
            }
        }
        System.out.println(nums.length);
        

        }
    }
