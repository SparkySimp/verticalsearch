package dev.sparkysimp.verticalsearch;
import java.math.*;

/**
 * A class that contains methods for searching in arrays using Öztürk's algorithm.
 */

public class OzturkSearcher {
    /**
     * Generates a pair of numbers that are the closest to the square root of the array length. 
     * @param array The array to get the size of.
     * @return A pair of numbers that are the closest to the square root of the array length.
     */
    public ArraySizePair getArraySizePair(Object[] array) {

        return new ArraySizePair((int)Math.floor((int)Math.sqrt(array.length)), (int)Math.ceil((int)Math.sqrt(array.length)));
    }
    /**
     * Transforms a 1D array into a 2D array.
     * @param array The array to transform.
     * @return The transformed array.
     */

    public Object[][] ozturkTransform(Object[] array) {
        // Get the pair of numbers that are the closest to the square root of the array length.
        ArraySizePair pair = getArraySizePair(array);
        // Create a 2D array with the pair's numbers as the dimensions.
        Object[][] matrix = new Object[pair.height()][pair.width()];
        // Iterate through the array.
        for(int i = 0; i < array.length; i++) {
            // Set the current element in the 2D array to the current element in the 1D array.
            matrix[i / pair.height()][i % pair.height()] = array[i];
        }
        return matrix;
    }
    /**
     * Searches for an object in an array using Öztürk's algorithm.
     * @param array The array to search in.
     * @param what The object to search for.
     * @return The index of the object in the array, or -1 if it was not found.
     */
    public int ozturkSearch(Object[] array, Object what) {
        // Transform the array into a 2D array.
        Object[][] matrix = ozturkTransform(array);
        // Iterate through matrix's columns. (matrix indices are organised as [row][column] rather than [column][row])
        for(int i = 0; i < matrix[0].length; i++) {
            // If the current element in the column is equal to the object we're searching for, return the index of the element.
            if(matrix[0][i].equals(what)) {
                return i;
            }
            // If the current element in the column is greater than the object we're searching for, iterate through the column.
            if(matrix[0][i].hashCode() > what.hashCode()) {
                for(int j = 0; j < matrix.length; j++) {
                    // If the current element in the column is equal to the object we're searching for, return the index of the element.
                    if(matrix[j][i].equals(what)) {
                        return i * matrix.length + j;
                    }
                }
            }
        }
        // If the object was not found, return -1.
        return -1;
    }
}
