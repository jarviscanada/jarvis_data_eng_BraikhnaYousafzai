package ca.jrvs.practice.codingChallenges;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Two Sum Coding Challenge: Find the indices of two elements in an array that have their sum equal some target
 * https://www.notion.so/jarvisdev/Two-Sum-9ffeb5b9a3ac40c5960e7ee0c2e88c8e
 */
public class TwoSum {

    /**
     * O(n^2) time complexity as this solution has nested for loops
     *
     * @param nums - integer array for searching
     * @param target - a target number
     * @return - indices of two numbers in the input array equaling the target
     */
    public static int[] twoSumNaive(int[] nums, int target){
        int [] twoSum = new int[2];

        for (int i =0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    twoSum[0] = i;
                    twoSum[1] = j;
                    return twoSum;
                }
            }
        }
        return twoSum;
    }

    /**
     * Hash map solution
     * O(n) - iterating over the for loop will take O(n) at worst.
     * All hashmap operation complete in constant time
     *
     * @param nums - integer array to search
     * @param target - target number
     * @return - an array with indices of two numbers in the input array summing to the target
     */
    public static int[] twoSumMap(int[] nums, int target){
        int [] twoSum = new int[2];
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if (numMap.containsKey(complement)){
                twoSum[0] = numMap.get(complement);
                twoSum[1] = i;
                return twoSum;
            }
            numMap.put(nums[i], i);
        }
        return twoSum;
    }

    public static void main(String[] args) {
        int [] nums = {1, 2, 5, 3, 19, 7};
        int [] solution = twoSumNaive(nums, 20);
        int [] solution1 = twoSumMap(nums, 20);
        System.out.println(Arrays.toString(solution));
        System.out.println(Arrays.toString(solution));
    }

}
