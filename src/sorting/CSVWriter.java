/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Chase
 */
public class CSVWriter {
    // simple wrapper method to write a CSV file so we can easily create our charts
    public static void createReport(ArrayList<Result> selectionResults, ArrayList<Result> insertionResults, ArrayList<Result> quickSortResults) {
        writeCSV(selectionResults, "SelectionResults");
        writeCSV(insertionResults, "InsertionResults");
        writeCSV(quickSortResults, "QuickSortResults");
    }
    
    private static void writeCSV(ArrayList<Result> results, String fileName)  {
        
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".csv", true)))) {
            out.append("size,assignments,comparisons,overall\n");
            
             results.forEach((currentResult) -> { // for each result, append it to the corresponding csv
                 // format our output
                 String output = String.format("%s,%s,%s,%s\n", currentResult.getArraySize(), currentResult.getAssignments(), currentResult.getComparisons(), currentResult.getOverall());
                 out.append(output);
            });
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
