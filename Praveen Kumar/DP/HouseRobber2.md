```
class Solution {
public:
    int solve(vector<int>& dp, vector<int>& nums, int i, int n) {
        if (i > n) return 0;
        if (dp[i] != -1) return dp[i];

        int steal = nums[i] + solve(dp, nums, i + 2, n);
        int skip = solve(dp, nums, i + 1, n);

        return dp[i] = max(steal, skip);
    }

    int rob(vector<int>& nums) {
        int n = nums.size();
        if (n == 1) return nums[0];
        if (n == 2) return max(nums[0], nums[1]);

        vector<int> dp1(n, -1);
        vector<int> dp2(n, -1);

        int take0thhouse = solve(dp1, nums, 0, n - 2);
        int take1sthouse = solve(dp2, nums, 1, n - 1);

        return max(take0thhouse, take1sthouse);
    }
};

```
