public class PartitionArrayAccordingToGivenPivot {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int ans[] = new int[n];
        int j = 0;
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
                ans[j]=nums[i];
                j++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]==pivot){
                ans[j]=nums[i];
                j++;
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]>pivot){
                ans[j]=nums[i];
                j++;
            }
        }
        return ans;
    }
}
