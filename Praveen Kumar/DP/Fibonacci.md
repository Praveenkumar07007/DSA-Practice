# Fibonacci Number Implementation

1. **Top-Down Approach (Recursion with Memoization - Dynamic Programming)**
2. **Bottom-Up Approach (Tabulation - Dynamic Programming)**
3. **Optimized Iterative Approach (Constant Space Complexity)**

## Code Explanation

### 1. Top-Down Approach (Recursion with Memoization)
This approach uses recursion with a memoization table to store previously computed Fibonacci values.
```cpp
int solve(int n, vector<int>& dp) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (dp[n] != -1) return dp[n];
    return dp[n] = solve(n-1, dp) + solve(n-2, dp);
}

int fib(int n) {
    vector<int> dp(n+1, -1);
    return solve(n, dp);
}
```
- **Time Complexity:** O(n) (Each Fibonacci number is computed only once)
- **Space Complexity:** O(n) (Due to recursion stack and memoization array)

### 2. Bottom-Up Approach (Tabulation)
This approach builds the Fibonacci sequence from the base cases iteratively.
```cpp
int fib(int n) {
    if (n <= 1) return n;
    vector<int> dp(n+1, -1);
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i <= n; i++) {
        dp[i] = dp[i-1] + dp[i-2];
    }
    return dp[n];
}
```
- **Time Complexity:** O(n) (Linear iteration)
- **Space Complexity:** O(n) (Due to the `dp` array storing results)

### 3. Optimized Iterative Approach (Constant Space)
This approach reduces space complexity to O(1) by using only variables to store previous Fibonacci numbers.
```cpp
int fib(int n) {
    if (n < 2) return n;
    int a = 0, b = 1, c;
    for (int i = 1; i < n; i++) {
        c = a + b;
        a = b;
        b = c;
    }
    return c;
}
```
- **Time Complexity:** O(n) (Linear iteration)
- **Space Complexity:** O(1) (Only a few integer variables used)
