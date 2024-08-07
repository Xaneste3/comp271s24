public class Sorting271 {

    public static void main(String[] args) {
        //Arrays that will be used for testing purposes 
        int[] a = {1, 2, 8, 9};
        int[] b = {0, 5, 6, 7};
        //This will print the arrays that are merged
        int[] arraysMerged = merge(a, b);
        System.out.printf("Arrays Merged: " + java.util.Arrays.toString(arraysMerged));

        //Test array to ensure that sort will work correctly and 
        //use sort for this array and print results
        int [] unsortedTestArray = {9, 7, 6, 8, 4, 2, 3, 1};
        int[] arraysSorted = sort(unsortedTestArray);
        System.out.printf("Arrays Sorted: " + java.util.Arrays.toString(arraysSorted));
    }

    public static int[] merge(int[] left, int[] right) {
        //this array will will be able to hold all of the data that is joined together
        int[] result = new int[left.length + right.length];
        
        //All of these index are pointers for there respective array
        int resultIndex = 0; int leftIndex = 0; int rightIndex = 0;

        // Merge the data from all arrays until one of them no longer has data to give
        while (leftIndex < left.length && rightIndex < right.length) {
            result[resultIndex++] = (left[leftIndex] <= right[rightIndex]) ? left[leftIndex++] : right[rightIndex++];
        }
        // Copy the rest of the data from the right array
        while (rightIndex < right.length) {
            result[resultIndex++] = right[rightIndex++];
        }
        // Copy the rest of the data from the left array
        while (leftIndex < left.length) {
            result[resultIndex++] = left[leftIndex++];
        }

        return result;
    }

    public static int[] sort(int[] array) {
        int[] sortedArray;

        if (array.length <= 1) {
            sortedArray = array;
        } else {
            int mid = array.length / 2;

            // Make subarrays for right and left halves that 
            int[] left = createSubArray(array, 0, mid);
            int[] right = createSubArray(array, mid, array.length);

            // Sort both halves recursively which will then be merged
            left = sort(left);
            right = sort(right);

            sortedArray = merge(left, right);
        }

        return sortedArray;
        }

        // Method to help create subarrays from the first array
    private static int[] createSubArray(int[] array, int start, int end) {
        int[] subArray = new int[end - start];
        for (int i = 0; i < subArray.length; i++) {
            subArray[i] = array[start + i];
        }
        return subArray;
    }

    }

