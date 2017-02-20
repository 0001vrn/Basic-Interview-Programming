
public class Sorting {
    public static void main(String []args){

        int []a={3,4,1,0,-1,2};
        //new Sorting().quickSort(a,0,a.length-1);
        //new Sorting().mergeSort(a,0,a.length-1);
        //new Sorting().selectionSort(a);
        new Sorting().insertionSort(a);

        for(int i=0;i<a.length;i++)
        System.out.print(a[i] + " ");



    }

    private void insertionSort(int[] arr) {
        int len=arr.length;
        int i, key, j;
        for (i = 1; i < len; i++)
        {
            key = arr[i];
            j = i-1;

       /* Move elements of arr[0..i-1], that are
          greater than key, to one position ahead
          of their current position */
            while (j >= 0 && arr[j] > key)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }
            arr[j+1] = key;
        }
    }

    public void selectionSort(int a[]){
        int len=a.length;
        for(int i=0;i<len;i++){
            int min_idx=i;

            for(int j=i+1;j<len;j++)
                if(a[j]<a[min_idx])
                    min_idx=j;

            int tmp=a[min_idx];
            a[min_idx]=a[i];
            a[i]=tmp;

        }
    }
    public void mergeSort(int a[],int low,int high){
        if(low<high){
            int mid=low+(high-low)/2;
            mergeSort(a,low,mid);
            mergeSort(a,mid+1,high);
            merge(a,low,mid,high);
        }
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int i, j, k;
        int n1 = mid - low + 1;
        int n2 =  high - mid;

    /* create temp arrays */
        int []L = new int[n1];
        int []R = new int[n2];

    /* Copy data to temp arrays L[] and R[] */
        for (i = 0; i < n1; i++)
            L[i] = arr[low + i];
        for (j = 0; j < n2; j++)
            R[j] = arr[mid + 1+ j];

    /* Merge the temp arrays back into arr[l..r]*/
        i = 0; // Initial index of first subarray
        j = 0; // Initial index of second subarray
        k = low; // Initial index of merged subarray
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

    /* Copy the remaining elements of L[], if there
       are any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

    /* Copy the remaining elements of R[], if there
       are any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public void quickSort(int a[],int low,int high){
        if(low<high){
            int pi = partition(a,low,high);
            quickSort(a,low,pi-1);
            quickSort(a,pi,high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j <= high- 1; j++)
        {
            // If current element is smaller than or
            // equal to pivot
            if (arr[j] <= pivot)
            {
                i++;    // increment index of smaller element
                int tmp=arr[i];
                arr[i]=arr[j];
                arr[j]=tmp;
            }
        }
        int tmp=arr[i+1];
        arr[i+1]=arr[high];
        arr[high]=tmp;
        return (i + 1);

    }
}
