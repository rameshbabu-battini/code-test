package com.ge.exercise2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNull;

import org.junit.Assume;
import org.junit.Test;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesTest() {
        Character[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(data);
        Assume.assumeNotNull((Object[])util.getQuadrantValues(0, 0, 2));

        Character[] expectedResult = {'a', 'b', 'e', 'f'};
        assertArrayEquals(expectedResult, util.getQuadrantValues(0, 0, 2));
    }
    
    @Test
    public void getRowValuesTest() {
        Character[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(data);
        Assume.assumeNotNull((Object[])util.getRowValues(1));

        Character[] expectedResult = {'e', 'f', 'g', 'h'};
        assertArrayEquals(expectedResult, util.getRowValues(1));
    }
    
    @Test
    public void getColumnValuesTest() {
        Character[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(data);
        Assume.assumeNotNull((Object[])util.getColumnValues(2));

        Character[] expectedResult = {'c', 'g', 'k', 'o'};
        assertArrayEquals(expectedResult, util.getColumnValues(2));
    }
    
    @Test
    public void getQuadrantValuesWithPartitionSize2Test() {
        Integer[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(data);
        Assume.assumeNotNull((Object[])util.getQuadrantValues(1, 1, 2));

        Integer[] expectedResult = {6, 7, 10, 11};
        assertArrayEquals(expectedResult, util.getQuadrantValues(1, 1, 2));
    }
    
    @Test
    public void getQuadrantValuesWithParitionSize3Test() {
        Integer[][] data = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };

        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(data);
        Assume.assumeNotNull((Object[])util.getQuadrantValues(3, 2, 3));

        Integer[] expectedResult = {21, 22, 23, 27, 28, 29, 33, 34, 35};
        assertArrayEquals(expectedResult, util.getQuadrantValues(3, 2, 3));
    }
    
    @Test
    public void getQuadrantValuesWithInvalidParitionSizeTest() {
        Integer[][] data = {
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };

        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(data);
        assertNull((Object[])util.getQuadrantValues(4, 2, 3));
    }
    
}