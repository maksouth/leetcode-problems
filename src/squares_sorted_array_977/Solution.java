package squares_sorted_array_977;

class Solution {
    public int[] sortedSquares(int[] input) {
        int[] result = new int[input.length];

        int i = 0;
        int j = input.length - 1;
        int k = 0;

        while (i <= j)
            if (Math.abs(input[i]) > Math.abs(input[j]))
                result[k++] = input[i++];
            else result[k++] = input[j++];

        return result;
    }
}