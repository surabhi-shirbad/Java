public class Merge {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}; // extra space for nums2
        int m = 3;

        int[] nums2 = {2, 5, 6};
        int n = 3;

        Merge obj = new Merge();
        obj.merge(nums1, m, nums2, n);

        // print result
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }

        while (j >= 0) {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}