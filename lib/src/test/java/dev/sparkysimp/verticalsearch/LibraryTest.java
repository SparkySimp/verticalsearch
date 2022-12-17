/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dev.sparkysimp.verticalsearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    @Test void transformationIsCorrect() {
        Object[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        Library lib = new Library();

        Object[][] transformedArray = lib.ozturkTransform(array);
        for(Object[] i: transformedArray)  {
            for(Object j: i) {
                System.out.print(j);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}