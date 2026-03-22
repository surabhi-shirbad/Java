public class Firstmissingno {

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};

        Firstmissingno obj = new Firstmissingno();
        int result = obj.firstMissingPositive(nums);

        System.out.println("First Missing Positive: " + result);
    }

    public int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Place numbers at correct index
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        // Step 2: Find missing number
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        // Step 3: If all present
        return n + 1;
    }
}