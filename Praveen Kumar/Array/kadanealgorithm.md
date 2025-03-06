# Maximum Subarray Problem

## Problem Statement
Given an integer array `nums`, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

## Approach 1: Kadane's Algorithm (O(N) Solution)
This approach is an optimal solution using **Kadane's Algorithm**.

### **Code:**
```cpp
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0;
        int maxi = nums[0];
        for(int i=0; i<nums.size(); i++) {
            sum += nums[i];
            maxi = max(maxi, sum);
            if(sum < 0) sum = 0;
        }
        return maxi;
    }
};
```

### **Time Complexity:** O(N)
- We iterate through the array once, updating `sum` and `maxi`.
- Each operation is O(1), leading to an overall O(N) complexity.

### **Space Complexity:** O(1)
- We use only a few integer variables, making the space complexity constant.

---

## Approach 2: Brute Force (O(N²) Solution)
This approach considers all possible subarrays and calculates their sums.

### **Code:**
```cpp
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int maxi = nums[0];
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = i; j < n; j++) {
                sum += nums[j];
                maxi = max(maxi, sum);
            }
        }
        return maxi;
    }
};
```

### **Time Complexity:** O(N²)
- Two nested loops iterate through all possible subarrays.
- The inner loop sums up elements, leading to **O(N²)** complexity.

### **Space Complexity:** O(1)
- No extra data structures are used, just a few integer variables.

---

## Approach 3: Brute Force (O(N³) Solution)
This approach checks all possible subarrays, but with an additional loop to compute their sum separately.

### **Code:**
```cpp
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        int maxi = nums[0];
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int sum = 0;
                for(int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxi = max(maxi, sum);
            }
        }
        return maxi;
    }
};
```

### **Time Complexity:** O(N³)
- Three nested loops iterate through all possible subarrays and sum their elements separately.
- This results in **O(N³)** complexity, which is inefficient for large inputs.

### **Space Complexity:** O(1)
- Uses only integer variables, no extra space required.
