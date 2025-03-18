public class FindUniqueOne {
    public static void main(String[] args) {
        int nums[]={2,1,3,4,5,2,4,3,5};
        int result=nums[0];
        for(int i=1;i<nums.length;i++)
            result^=nums[i];
        System.out.println(result);
    }
}
