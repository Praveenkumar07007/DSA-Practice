```
class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int n = nums.size();
        // find pivot index where dip is coming
        int idx =-1;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx =i;
                break;
            }
        }

        // if we will not find any idx then this is greatest pemutation we have to return
        // first element or reverse that only;
        if(idx==-1){
            reverse(nums.begin(),nums.end());
            return;
        }
        reverse(nums.begin()+idx+1,nums.end());
        // ab swap karna hai pivot element aur just greater element ko
        int j=-1;
        for(int i=idx+1;i<n;i++){
            if(nums[i]>nums[idx]){
                j=i;
                break;
            }
        }
        int temp = nums[idx];
        nums[idx]=nums[j];
        nums[j]=temp;
        return;
    }
};
```
