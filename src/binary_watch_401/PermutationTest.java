package binary_watch_401;

import org.junit.Test;

public class PermutationTest {

    private Permutation permutation = new Permutation();

    @Test
    public void test1() {
        permutation.permutate(new int[]{1,1,1,0,0,0});
    }

}

class Backtracking {

    int[] A;

    void Binary(int n){
        if(n<1){
            for(int i : A)
            System.out.print(i);
            System.out.println();
        }else{
            A[n-1] = 0;
            Binary(n-1);
            A[n-1] = 1;
            Binary(n-1);
        }
    }
    public static void main(String[] args) {
        // n is number of bits
        int n = 8;

        Backtracking backtracking = new Backtracking();
        backtracking.A = new int[n];
        backtracking.Binary(n);
    }
}