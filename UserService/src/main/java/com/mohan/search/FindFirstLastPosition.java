package com.mohan.search;

public class FindFirstLastPosition {


    public int[] searchRange(int[] nums, int target) {
        int [] answer = {-1,-1};

      int start = searchFirst(nums,target,true);
      int end = searchFirst(nums,target,false);

        answer [0]= start;
        answer[1] = end;

        return answer;

    }


    int searchFirst(int[] nums,int target,boolean findFirst){

        int start=0;
        int end  = nums.length-1;
        int ans = -1;

        while (start<=end){

            int mid = start + (end-start)/2;

            if(target < nums[mid]){
                end=mid-1;
            }
            else if(target> nums[mid]){
                start=mid+1;
            }
            else {
                ans = mid;
                if(findFirst){
                    end = mid-1;
                }else{
                    start = mid+1;
                }
            }
        }

        return ans;
    }
}

