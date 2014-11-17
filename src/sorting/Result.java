package sorting;

/**
 *
 * @author Chase
 */
public class Result {

    private final String sortType;
    private final int arraySize;
    private int assignments = 0;
    private int comparisons = 0;

    public Result(int arraySize, String sortType) {
        this.sortType = sortType;
        this.arraySize = arraySize;
    }
    
    public void addAssignment() {
        this.assignments++;
    }
    
    public void addAssignment(int numberOfAssignmentsToAdd) {
        this.assignments += numberOfAssignmentsToAdd;
    }

    public void addComparisons() {
        this.comparisons++;
    }
    
    public int getArraySize() {
        return this.arraySize;
    }

    public int getAssignments() {
        return this.assignments;
    }

    public int getComparisons() {
        return this.comparisons;
    }

    public int getOverall() {
        return this.comparisons + this.assignments;
    }
}
