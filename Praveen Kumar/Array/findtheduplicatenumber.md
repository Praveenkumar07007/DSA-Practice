### By using cycle Sort
  but here i am modifying array .
```
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int len = nums.size();
        int i=0;
        while(i<len){
            int correctIdx = nums[i];
            if(nums[correctIdx]==nums[i]) return nums[i];
            else swap(nums[i],nums[correctIdx]);
        }
        return 1000;
    }

};
```
### By using Cycle Detection Method
Time Complexity : O(n)  
Space Complexity : O(1)
```
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
};

```
