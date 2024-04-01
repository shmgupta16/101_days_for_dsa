class Solution {
    public int singleNonDuplicate(int[] nums) {
        //Since the array is sorted , it is very intutive that for duplicacy of elements either the preceding or upcoming element will be same.If both preceding and upcoming are not same that means the element is unique
        int n = nums.length;
        //1st edge case
        if(n == 1){
            return nums[0];
        }

        //2nd edge case
        if(nums[0] != nums[1]){
            return nums[0];
        }

        //3rd edge case
        if(nums[n-1] != nums[n-2]){
            return nums[n-1];
        }

        int low = 1;
        int high = n-2;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1]){
                return nums[mid];
            }else if((mid % 2 == 0 && nums[mid] == nums[mid+1]) || (mid % 2 == 1 && nums[mid] == nums[mid-1])){
                //means we are on the left half , need to eliminate that half as our element will not be there
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return -1;

        
    }
}
