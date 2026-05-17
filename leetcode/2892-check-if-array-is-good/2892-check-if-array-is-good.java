class Solution {
    public boolean isGood(int[] nums) {
        int n = 0;

        for (int x : nums) {
            n = Math.max(n, x);
        }

        // valid array size must be n + 1
        if (nums.length != n + 1) {
            return false;
        }

        int[] freq = new int[201];

        for (int x : nums) {
            freq[x]++;

            // numbers except n cannot repeat
            if (x != n && freq[x] > 1) {
                return false;
            }

            // n cannot appear more than twice
            if (x == n && freq[x] > 2) {
                return false;
            }
        }

        return freq[n] == 2;
    }
}