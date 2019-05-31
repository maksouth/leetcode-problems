package rotate_image_48;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void test1() {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        solution.rotate(matrix);
    }

    @Test
    public void test2() {
        int[][] matrix = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };

        solution.rotate(matrix);
        print(matrix);
    }

    @Test
    public void test3() {
        int[][] matrix = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}
        };

        solution.rotate(matrix);
        print(matrix);
    }

    private void print(int[][] matrix) {
        for (int[] row: matrix)
            System.out.println(Arrays.toString(row));
    }

}