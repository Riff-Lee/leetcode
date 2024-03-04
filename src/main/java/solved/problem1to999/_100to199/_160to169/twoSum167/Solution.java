package solved.problem1to999._100to199._160to169.twoSum167;


public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n= numbers.length;// length of given array
        int i=0;//to point left index
        int j=n-1;//to point right index
        int mid=0;//to find mid
        int ans[]=new int[2];//to store result
        while(i < j) {//loop will run till left <right
            mid = (i+j)/2;//find the mid
            int sum = numbers[i] + numbers[j];//to store the addition of left and right element
            if(sum == target) {//if target is equal to sum than return index
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }
            else if(sum<target)  //if target is greater than sum than
            {
                if(numbers[j]+numbers[mid]<target)//cheak if right and mid element sum is less than target
                {
                    i=mid+1;//than i incraese to mid+1
                }
                else{
                    i++;// else increase i by 1
                }

            }
            else{
                if(numbers[i]+numbers[mid]>target)//else sum is greater than target than cheak if  left element and mid element than set right  j to mid-1
                {
                    j=mid-1;
                }
                else{
                    j--;//else decrease j by 1
                }
            }

        }
        return ans;// return ans
    }

    public int[] twoSum1(int[] numbers, int target) {
        int left=0;
        int right;
        for (;left<numbers.length;left++) {
            for (right = left+1;right<numbers.length;right++) {
                if (numbers[left]+numbers[right]==target) {
                    return new int[]{left+1, right+1};
                }
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.twoSum(new int[] {1,3,4,4}, 8));
    }
}
