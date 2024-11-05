package leetcode;

public class RotatedArray {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = 0;

        while (left<=right){
            mid = (left+right)/2;
            //4,5,6,7,0,1,2

            if (nums[mid]==target){
                return mid;
            }
            // Means the left side is sorted
            if ((nums[left] <= nums[mid])) {
                if ((nums[left]<=target) && (target<nums[mid])){
                    System.out.println("1. start: " + left + " mid: " + mid + " last: " + right );
                    right = mid - 1;
                }
                else{
                    System.out.println("2. start: " + left + " mid: " + mid + " last: " + right );
                    left = mid + 1;
                }
            }
            // Means the right side is sorted
            else{
                if ((nums[mid]<target) && (target<=nums[right])){
                    left = mid + 1;
                }
                else{
                    right = mid - 1;
                }
            }

        }

        return -1;
    }
    public static void main(String[] args) {
        RotatedArray rotatedArray = new RotatedArray();
        System.out.println(rotatedArray.search(new int[]{4,5,6,7,0,1,2}, 0));
    }
}
