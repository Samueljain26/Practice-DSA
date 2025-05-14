class FirstPositive{
    public int firstMissingPositive(int[] nums) {
//           Arrays.sort(nums);
//         int x = 1;
//         for (int i = 0; i < nums.length; i++) {
//     if (nums[i] == x) {
//         x++;
//     }
// }
//         return x;
//     }
// }

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {

                int index = nums[i] - 1;
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }
}