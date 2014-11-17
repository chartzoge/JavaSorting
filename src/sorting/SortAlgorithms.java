/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

/**
 *
 * @author Chase
 */
public class SortAlgorithms {

    // copied from module; modified to only sort ints for testing purposes
    public static void SelectionSort(int[] arrayToSort, Result result) {
        int outerIndex;
        for (outerIndex = 0; outerIndex < arrayToSort.length; outerIndex++) {
            int minIndex = outerIndex;

            for (int innerIndex = outerIndex + 1; innerIndex < arrayToSort.length; innerIndex++) {

                result.addComparisons();
                if (arrayToSort[innerIndex] < arrayToSort[minIndex]) {
                    minIndex = innerIndex;
                }
            }

            Swap(arrayToSort, minIndex, outerIndex);
            // 3 assignments for swap
            result.addAssignment(3);
        }
    }

    // copied from module; modified to only sort ints for testing purposes
    public static void InsertionSort(int[] arrayToSort, Result result) {
        for (int outerIndex = 1; outerIndex < arrayToSort.length; outerIndex++) {

            result.addAssignment(); // count of comparable assignment

            Comparable currentElement = arrayToSort[outerIndex];
            int innerIndex = outerIndex - 1;

            result.addComparisons();
            while ((innerIndex >= 0) && currentElement.compareTo(arrayToSort[innerIndex]) < 0) {
                result.addComparisons();
                result.addAssignment();

                arrayToSort[innerIndex + 1] = arrayToSort[innerIndex];
                innerIndex--;
            }

            arrayToSort[innerIndex + 1] = (int) currentElement;
            result.addAssignment();
        }
    }

    public static void QuickSort(int[] array, int left, int right, Result result) {
        result.addComparisons();
        if (left < right) {

            result.addAssignment();
            int pivot = FindPivot(array, left, right, result);

            QuickSort(array, left, pivot - 1, result);
            QuickSort(array, pivot + 1, right, result);
        }
    }

    private static int FindPivot(int[] array, int left, int right, Result result) {

        result.addAssignment();
        int first = left++;

        result.addComparisons();
        while (left <= right) {
            result.addComparisons();

            result.addComparisons();
            while (left <= right && (array[first] > array[left])) {
                result.addAssignment();
                result.addComparisons();
                left++;
            }

            result.addComparisons();
            while (left <= right && (array[first] < array[right])) {
                result.addAssignment();
                result.addComparisons();
                right--;
            }

            result.addComparisons();
            if (left < right) {
                result.addAssignment(3);
                Swap(array, left++, right--);
            }
        }

        result.addAssignment(3);
        Swap(array, first, right);

        return right;
    }

    // method to output an array
    public static void OutputSortResults(int[] sortedArray, String sortName) {
        System.out.println("------------------ " + sortName + " ------------------");

        for (int index = 0; index < sortedArray.length; index++) {
            System.out.println(sortedArray[index]);
        }
    }

    // small helper method to swap two elements in an array
    private static void Swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

}
