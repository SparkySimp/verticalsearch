/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dev.sparkysimp.verticalsearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void transformationIsCorrect() {
        Object[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        OzturkSearcher lib = new OzturkSearcher();
        Object[][] matrix = lib.ozturkTransform(array);
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                assertEquals(array[i * matrix[i].length + j], matrix[i][j]);
            }
        }
    }

    @Test void searchIsCorrect() {
        Object[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        OzturkSearcher lib = new OzturkSearcher();

        assertEquals(0, lib.ozturkSearch(array, 0));
        assertEquals(1, lib.ozturkSearch(array, 1));
        assertEquals(2, lib.ozturkSearch(array, 2));
        assertEquals(3, lib.ozturkSearch(array, 3));
        assertEquals(4, lib.ozturkSearch(array, 4));
        assertEquals(5, lib.ozturkSearch(array, 5));
        assertEquals(6, lib.ozturkSearch(array, 6));
        assertEquals(7, lib.ozturkSearch(array, 7));
        assertEquals(8, lib.ozturkSearch(array, 8));
        assertEquals(9, lib.ozturkSearch(array, 9));
        assertEquals(10, lib.ozturkSearch(array, 10));
        assertEquals(11, lib.ozturkSearch(array, 11));
        assertEquals(12, lib.ozturkSearch(array, 12));
        assertEquals(13, lib.ozturkSearch(array, 13));
        assertEquals(14, lib.ozturkSearch(array, 14));
    }
}
