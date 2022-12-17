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
        // First iterate through matrix's rows.
        for(int i = 0; i < matrix.length; i++) {
            // If the object is greater than the last element in the row, continue.
            if((int)matrix[i][matrix[i].length - 1] < (int)what) {
                continue;
            }
            // If the object is less than the first element in the row, return -1.
            if((int)matrix[i][0] > (int)what) {
                return -1;
            }
            // Iterate through the row.
            for(int j = 0; j < matrix[i].length; j++) {
                // If the object is equal to the current element, return the index.
                if(matrix[i][j] == what) {
                    return i * matrix[i].length + j;
                }
            }
        }
        return -1;
    }
}
