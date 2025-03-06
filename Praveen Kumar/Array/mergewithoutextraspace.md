# Merge Two Sorted Arrays Without Extra Space

## Problem Statement
Given two sorted arrays `A` and `B` of sizes `N` and `M` respectively, merge them into sorted order **without using extra space**.

---

## Solution 1: Shell Sort (Gap Method)

### **Approach**
- Use a **gap** (initially `ceil((N + M) / 2)`) to compare and swap elements across both arrays.
- Reduce the gap in each iteration using `gap = ceil(gap / 2)`.
- Continue until the gap reduces to 1 and all elements are in sorted order.

### **Code Implementation**
```cpp
void swapifgreater(vector<int>& arr1, vector<int>& arr2, int idx1, int idx2) {
    if (arr1[idx1] > arr2[idx2]) {
        swap(arr1[idx1], arr2[idx2]);
    }
}

void mergeArrays(vector<int>& a, vector<int>& b) {
    int n = a.size();
    int m = b.size();
    int len = n + m;
    int gap = (len / 2) + (len % 2); // Ceil value of len/2

    while (gap > 0) {
        int left = 0;
        int right = left + gap;

        while (right < len) {
            // Case 1: Comparing elements in 'a' and 'b'
            if (left < n && right >= n) {
                swapifgreater(a, b, left, right - n);
            }
            // Case 2: Comparing elements in 'b' itself
            else if (left >= n) {
                swapifgreater(b, b, left - n, right - n);
            }
            // Case 3: Comparing elements in 'a' itself
            else {
                swapifgreater(a, a, left, right);
            }
            left++;
            right++;
        }

        if (gap == 1) break;
        gap = (gap / 2) + (gap % 2); // Reduce the gap
    }
}
```

### **Time Complexity**
- **O((N+M) log(N+M))**: The gap reduces approximately by half in each iteration, leading to a logarithmic complexity.
- Each iteration does **O(N+M)** comparisons/swaps.

### **Space Complexity**
- **O(1)**: The merging is done in place, requiring no extra space.

---

## Solution 2: Two-Pointer + Sorting

### **Approach**
1. Start with two pointers, one at the end of `A` and one at the start of `B`.
2. Swap elements if `A[i] > B[j]`, ensuring smaller elements move left.
3. Finally, sort both arrays to maintain order.

### **Code Implementation**
```cpp
class Solution {
  public:
    void mergeArrays(vector<int>& a, vector<int>& b) {
        int n = a.size();
        int m = b.size();
        int left = n - 1;
        int right = 0;

        while (left >= 0 && right < m) {
            if (a[left] > b[right]) {
                swap(a[left], b[right]);
                left--, right++;
            } else {
                break;
            }
        }

        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
    }
};
```

### **Time Complexity**
- **O(N + M + (N log N) + (M log M))**
- The first loop runs in **O(min(N, M))**.
- Sorting both arrays adds **O(N log N + M log M)**.

### **Space Complexity**
- **O(1)**: Only in-place swapping and sorting are used.

---
