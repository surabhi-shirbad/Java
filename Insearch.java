public class Insearch {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 5;

        Insearch obj = new Insearch(); 
        int result = obj.searchInsert(nums, target);

        System.out.println("Index: " + result);
    }

    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                return i;
            }
        }
        return nums.length;
    }
}