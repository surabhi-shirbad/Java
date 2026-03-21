public class Solution {

    public static void main(String[] args) {
        int[] nums1 = {3,4,6,5};
        int[] nums2 = {9,1,2,5,8,3};
        int k = 5;

        Solution obj = new Solution();
        int[] result = obj.maxNumber(nums1, nums2, k);

        // print result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];

        for (int i = 0; i <= k; i++) {
            if (i <= nums1.length && (k - i) <= nums2.length) {
                
                int[] a = getMax(nums1, i);
                int[] b = getMax(nums2, k - i);
                int[] merged = merge(a, b);

                if (greater(merged, ans)) {
                    ans = merged;
                }
            }
        }
        return ans;
    }

    private int[] getMax(int[] nums, int k) {
        int[] res = new int[k];
        int top = -1;
        int remove = nums.length - k;

        for (int num : nums) {
            while (top >= 0 && res[top] < num && remove > 0) {
                top--;
                remove--;
            }
            if (top + 1 < k) {
                res[++top] = num;
            } else {
                remove--;
            }
        }
        return res;
    }

    private int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0, j = 0, r = 0;

        while (i < a.length || j < b.length) {
            if (compare(a, i, b, j)) {
                res[r++] = a[i++];
            } else {
                res[r++] = b[j++];
            }
        }
        return res;
    }

    private boolean compare(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) return true;
            if (a[i] < b[j]) return false;
            i++;
            j++;
        }
        return i != a.length;
    }

    private boolean greater(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i]) return true;
            if (a[i] < b[i]) return false;
        }
        return false;
    }
}