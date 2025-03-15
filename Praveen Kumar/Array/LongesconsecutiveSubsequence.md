# Longest Consecutive Sequence

## Problem Statement
Given an unsorted array of integers `arr`, find the length of the longest sequence of consecutive integers. The sequence does not need to be contiguous in the array.

## Solution Code
```
int longestConsecutive(vector<int>& arr) {
    // Edge case: If the array is empty, return 0
    if (arr.empty()) return 0;

    // Create a set to store all elements for O(1) lookups
    unordered_set<int> st(arr.begin(), arr.end());

    int maxLength = 0; // To store the length of the longest consecutive subsequence

    // Iterate through each element in the array
    for (int num : arr) {
        // Check if the current number is the starting point of a sequence
        if (st.find(num - 1) == st.end()) {
            int currentNum = num;
            int currentLength = 1;

            // Find the length of the consecutive sequence starting from currentNum
            while (st.find(currentNum + 1) != st.end()) {
                currentNum++;
                currentLength++;
            }

            // Update the maximum length found so far
            maxLength = max(maxLength, currentLength);
        }
    }

    return maxLength;
}
```
## Time complexity
Inserting all elements into the set takes O(n) time.

The outer loop runs O(n) times, and the inner while loop runs only for starting points of sequences, ensuring that each element is processed at most twice.

Overall, the time complexity is linear.
## space complexity
The unordered_set uses O(n) space to store all elements of the array.
