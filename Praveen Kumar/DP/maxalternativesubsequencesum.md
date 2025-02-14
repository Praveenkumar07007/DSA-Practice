# Maximum Alternating Subsequence Sum

## Approach 1: Recursive DP (Memoization)

### Solution:
```cpp
class Solution {
public:
    long long solve(int idx, vector<int>& nums, bool flag, vector<vector<long long>>& dp) {
        if (idx >= nums.size()) return 0;
        if (dp[idx][flag] != -1) return dp[idx][flag];

        // Skip current index
        long long skip = solve(idx + 1, nums, flag, dp);

        // Take current index
        long long val = nums[idx];
        if (!flag) val = -val;
        long long take = val + solve(idx + 1, nums, !flag, dp);

        return dp[idx][flag] = max(skip, take);
    }

    long long maxAlternatingSum(vector<int>& nums) {
        int n = nums.size();
        vector<vector<long long>> dp(n, vector<long long>(2, -1));
        return solve(0, nums, true, dp);
    }
};
```

### Time Complexity:
- **O(n)** (Each state is computed once)

### Space Complexity:
- **O(n)** (Due to recursion stack and DP table)

---

## Approach 2: Iterative DP (Optimized Space)

### Solution:
```cpp
class Solution {
public:
    long long maxAlternatingSum(vector<int>& nums) {
        long long evenSum = 0, oddSum = 0;

        for (int num : nums) {
            long long newEvenSum = max(evenSum, oddSum + num);// jab subsequence even length ka hoga to add hoga [4(+),2(-)]+(this will always added)
            long long newOddSum = max(oddSum, evenSum - num);
            evenSum = newEvenSum;
            oddSum = newOddSum;
        }

        return evenSum;
    }
};
```

### Time Complexity:
- **O(n)** (Single pass through the array)

### Space Complexity:
- **O(1)** (Only a few variables used)
