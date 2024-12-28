public class BackTracking1 {
    public static void main(String[] args) {
        int nums[]={0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};int k=3;
        int count0=0,count1=0,max=0;
        int i=0,start,end;
        while(i<nums.length){
            if(nums[i]==1){
                start=i;
                while(i<nums.length && (nums[i]==1 || (count0<k&&nums[i]==0))){
                    if(nums[i]==0)
                        count0++;
                    else
                        count1++;
                    i++;
                }
                end=i;
                i=start-1;
                while(count0<k && i>=0 && nums[i]==0){
                    count0++;i--;
                }
                i=end+1;
                while(count0<k && i<nums.length && nums[i]==0){
                    count0++;i++;
                }
                i--;
            }
            if(count1+count0>max){
                max=count1+count0;
            }
            count1=0;count0=0;i++;
        }
       System.out.println(max);
    }
}
