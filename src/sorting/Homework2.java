/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;

/**
 *
 * @author Chase
 */
public class Homework2 {

    // store results globally
    private static ArrayList<Result> selectionResults = new ArrayList<>();
    private static ArrayList<Result> insertionResults = new ArrayList<>();
    private static ArrayList<Result> quickSortResults = new ArrayList<>();

    public static void main(String[] args) {
        TestInsertionSort();
        TestSelectionSort();
        TestQuickSort();

        // write out results to CSV so we can easily create a report
        CSVWriter.createReport(selectionResults, insertionResults, quickSortResults);
    }

    // test insertion sort
    private static void TestInsertionSort() {
        Initializer insertionSortInitializer = new Initializer(); // 
        ArrayList<int[]> testDataForInsertionSort = insertionSortInitializer.getTestDataSet(); // generate a 10*n array to use for testing

        // for each test set (100, 200, etc) let's run the sort and record the results
        testDataForInsertionSort.forEach((currentTestData) -> {
            Result currentResult = new Result(currentTestData.length, "Insertion");

            SortAlgorithms.InsertionSort(currentTestData, currentResult);

            insertionResults.add(currentResult);
        });

        // output only the first sorted array; just to test to see if the array actually sorted
        SortAlgorithms.OutputSortResults(testDataForInsertionSort.get(0), "Insertion");
    }
    
    private static void TestQuickSort() {
        Initializer quickSortInitializer = new Initializer();
        
        ArrayList<int[]> testDataForQuickSort = quickSortInitializer.getTestDataSet();
        
        testDataForQuickSort.forEach((currentTestData) -> {
            Result currentResult = new Result(currentTestData.length, "QuickSort");
            
            
            SortAlgorithms.QuickSort(currentTestData, 0, currentTestData.length - 1, currentResult);
            quickSortResults.add(currentResult);
            
        });
        
        SortAlgorithms.OutputSortResults(testDataForQuickSort.get(0), "QuickSort");
    }

    private static void TestSelectionSort() {
        Initializer selectionSortInitializer = new Initializer();
        ArrayList<int[]> testDataForSelectionSort = selectionSortInitializer.getTestDataSet(); // generate a 10*n array to use for testing

        // for each test set (100, 200, etc) let's run the sort and record the results
        testDataForSelectionSort.forEach((currentTestData) -> {
            Result currentResult = new Result(currentTestData.length, "Selection");

            SortAlgorithms.InsertionSort(currentTestData, currentResult);

            selectionResults.add(currentResult);
        });

        // output only the first sorted array; just to test to see if the array actually sorted
        SortAlgorithms.OutputSortResults(testDataForSelectionSort.get(0), "Selection");
    }
}
