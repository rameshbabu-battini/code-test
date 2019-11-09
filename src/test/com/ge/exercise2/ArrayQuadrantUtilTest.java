package com.ge.exercise2;

import static org.junit.Assert.assertArrayEquals;

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
    public void getQuadrantValuesTest2() {
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
    
}