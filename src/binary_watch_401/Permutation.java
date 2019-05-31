package binary_watch_401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<int[]> permutate(int[] elems) {
        List<int[]> solution = new ArrayList<>();
        print(elems, 0, solution);
        return solution;
    }

    private void print(int[] elements, int index, List<int[]> results) {
        if (index == elements.length - 1) {
            System.out.println(Arrays.toString(elements));
            results.add(elements);
        } else
            for (int j = index; j < elements.length; j++) {
                swap(elements, index, j);
                print(elements, index + 1, results);
                swap(elements, index, j);
            }
    }

    private void swap(int[] elements, int i, int j) {
        int temp = elements[i];
        elements[i] = elements[j];
        elements[j] = temp;
    }
}
