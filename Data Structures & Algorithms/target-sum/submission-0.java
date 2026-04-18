class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sumA = 0;
        for (int num : nums) {
            sumA += num;
        }

        // Edge cases
        if ((target + sumA) % 2 != 0 || Math.abs(target) > sumA) {
            return 0;
        }

        int sum1 = (target + sumA) / 2;

        return countOfSubset(nums, sum1);
    }

    public int countOfSubset(int[] arr, int target) {
        int n = arr.length;
        int[][] t = new int[n + 1][target + 1];

        // Initialization
        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for (int j = 1; j <= target; j++) {
            t[0][j] = 0;
        }

        // DP
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][target];
    }
}