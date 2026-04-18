class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        }

        int m = sum / 2;

        boolean[][] t = new boolean[n + 1][m + 1];

        // Base cases
        for (int i = 0; i <= n; i++) {
            t[i][0] = true; // sum = 0 is always possible
        }

        for (int j = 1; j <= m; j++) {
            t[0][j] = false; // no elements, sum > 0 impossible
        }

        // DP logic
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] || t[i - 1][j - nums[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][m];
    }
}