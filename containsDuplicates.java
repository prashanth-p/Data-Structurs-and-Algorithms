class Solution {
    public void printArr(int[] nums, int len) {
        for(int i = 0; i<len; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    public void printArr2(int[] nums,int start, int end) {
        for(int i = start; i<end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
    // 2-Way merging Algorithm
    public void merge(int[] nums, int low, int mid, int high) {
        
        // Find sizes of Sub arrays
        int n1 = mid - low + 1;
        int n2 = high - mid;
        
        // Create a duplicate array to store the data
        int R[] = new int [n1];
        int L[] = new int [n2];
        
        // Copy data to duplicate array
        for(int i=0; i<n1; i++){
            R[i] = nums[low + i];
        }
        
        for(int j=0; j<n2; j++) {
            L[j] = nums[mid + 1 + j];
        }
        // System.out.print("R[]: ");
        // printArr(R, R.length);
        // System.out.print("L[]: ");
        // printArr(L, L.length);
        
        
        // Merge the two temp arrays
        int i=0; int j=0;
        int k = low;
        while(i<n1 && j<n2){
            if(R[i]<L[j]){
                nums[k++] = R[i++];
            } else if(L[j]<R[i]) {
                nums[k++] = L[j++];
            } else if (R[i] == L[j]) {
                nums[k++] = R[i];
                nums[k++] = R[i];
                i++;
                j++;
            }
        }
        for(;i<n1;i++){
            nums[k++] = R[i];
        }
        for(;j<n2; j++){
            nums[k++] = L[j];
        }
        // System.out.print("Merged: ");
        // printArr2(nums, low, k);
    }
    
    public void mergeSort(int[] nums, int low, int high){
        int mid =(int) Math.floor(low + (high-low)/2);
        if(low < high){
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums,low,mid,high);
        }
    }
    
    public boolean containsDuplicate(int[] nums) {
        if((nums == null) || (nums.length == 0)) {
            return false;
        }
        
        int len = nums.length;
        printArr(nums, len);
        mergeSort(nums, 0, len-1);
        printArr(nums, len);
        
        for(int i=0; i<len-1; i++){
            if(nums[i]==nums[i+1])
                return true;
        }
        return false;
    }
}
