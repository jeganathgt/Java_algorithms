import java.util.*;
class Solution {
    void merge(int[] nums, int first_array, int second_array, int end){
        int i = first_array;
        int j = second_array;

        int i_end = second_array - 1;
        int j_end = end;

        int k = 0;
        int size = end - first_array + 1;
        
        int[] temp = new int[size];

        System.out.println("first :" + first_array + "Second : " + second_array + "end:" + end);
        while(i <= i_end && j <= j_end) {
            if (nums[i] < nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }
        
        while(i <= i_end) {
            temp[k++] = nums[i++];
        }
        
        while(j <= j_end) {
            temp[k++] = nums[j++];
        }

        System.arraycopy(temp, 0, nums, first_array, size);
        /*
        i = first_array;
        k = 0;
        while (i <= end) {
            nums[i++] = temp[k++];
        }
        */
        System.out.println(Arrays.toString(temp));
        System.out.println("nums : " + Arrays.toString(nums));
    }
    
    void merge_sort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = (end + start)/2;
            merge_sort(nums, start, mid);
            merge_sort(nums, mid+1, end);
            merge(nums, start, mid+1, end);
        }
    }
    
    public int[] sortArray(int[] nums) {
        merge_sort(nums, 0, nums.length-1);
        return nums;
    }

    public static void main(String[] args) {
        Solution soln = new Solution();

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the len:");
        int len = scan.nextInt();
        int[] nums = new int[len];
        System.out.println("Enter the array:");
        for (int i =0; i < len; i++) {
            nums[i] = scan.nextInt();
        }
        System.out.println("Result :" + Arrays.toString(soln.sortArray(nums)));
    }
}
