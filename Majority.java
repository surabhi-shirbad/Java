import java.util.Arrays;

public class Majority {
    public static void main(String[] args) {
        int[] nums = {1,2,2,2,3,4,4,4,4,4,4};
        
        Arrays.sort(nums);
        
        int majority = nums[nums.length / 2];
        
        System.out.println("Majority element: " + majority);
    }
}