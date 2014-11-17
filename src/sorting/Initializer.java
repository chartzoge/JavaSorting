/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorting;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Chase
 */
public class Initializer {
    
    private ArrayList<int[]> testData = new ArrayList<>();
    
    public Initializer()
    {
        // create a 10*n linkedList
        for (int index = 100; index <= 1000; index += 100) {
            testData.add(generateArray(index));
        }
    }
    
    // method to return testData
    public ArrayList<int[]> getTestDataSet()
    {
        return testData;
    }
    
    // generate a random array of numbers, given a size
    private int[] generateArray(int size) {
        Random random = new Random();
        int[] newArray = new int[size];
        
        for (int index = 0; index < size; index++) {
            newArray[index] = random.nextInt();
        }
        
        return newArray;
    }
}
