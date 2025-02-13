
## Climbing Stairs Problem


1. **Top-Down Approach (Recursion with Memoization - Dynamic Programming)**
2. **Bottom-Up Approach (Tabulation - Dynamic Programming)**
3. **Optimized Iterative Approach (Constant Space Complexity)**

### Code Explanation

#### 1. Top-Down Approach (Recursion with Memoization)
This approach uses recursion with a memoization table to store previously computed results.
```cpp
int solve(int n, vector<int>& dp) {
    if (n <= 2) return n;
    if (dp[n] != -1) return dp[n];
    return dp[n] = solve(n-1, dp) + solve(n-2, dp);
}

int climbStairs(int n) {
    vector<int> dp(n+1, -1);
    return solve(n, dp);
}
```
- **Time Complexity:** O(n) (Each step is computed once)
- **Space Complexity:** O(n) (Due to recursion stack and memoization array)

#### 2. Bottom-Up Approach (Tabulation)
This approach builds the solution iteratively using a `dp` array.
```cpp
int climbStairs(int n) {
    if (n == 1) return 1;
    if (n == 2) return 2;
    vector<int> dp(n+1, -1);
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}
```
- **Time Complexity:** O(n) (Linear iteration)
- **Space Complexity:** O(n) (Due to the `dp` array storing results)

#### 3. Optimized Iterative Approach (Constant Space)
This approach reduces space complexity to O(1) by using only a few integer variables.
```cpp
int climbStairs(int n) {
    if (n <= 2) return n;
    int a = 1;
    int b = 2;
    int c = 0;
    for (int i = 3; i < n + 1; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return c;
}
```
- **Time Complexity:** O(n) (Linear iteration)
- **Space Complexity:** O(1) (Only a few integer variables used)
