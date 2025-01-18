
import java.util.function.Function;

public class Solution {

    public int minimizeXor(int firstInput, int secondInput) {
        int numberOfBitsSetToOneInFirstInput = countNumberOfBitsSetToOne(firstInput);
        int numberOfBitsSetToOneInSecondInput = countNumberOfBitsSetToOne(secondInput);

        if (numberOfBitsSetToOneInFirstInput == numberOfBitsSetToOneInSecondInput) {
            return firstInput;
        }

        int surplusBits = Math.abs(numberOfBitsSetToOneInSecondInput - numberOfBitsSetToOneInFirstInput);
        boolean greaterNumberOfBitsSetToOneInFirstInput = numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput;

        Function<Integer, Boolean> compare = greaterNumberOfBitsSetToOneInFirstInput ? (x) -> x == 0 : (x) -> x != 0;
        return findMinXOR(firstInput, surplusBits, compare);
    }

    private int findMinXOR(int firstInput, int surplusBits, Function<Integer, Boolean> compare) {
        int bitsEqualizer = 1;
        int minXor = firstInput;

        while (surplusBits > 0) {
            if (compare.apply(bitsEqualizer & minXor)) {
                minXor ^= bitsEqualizer;
                --surplusBits;
            }
            bitsEqualizer <<= 1;
        }
        return minXor;
    }

    private int countNumberOfBitsSetToOne(int value) {
        int numberOfBitsSetToOne = 0;
        while (value > 0) {
            numberOfBitsSetToOne += value & 1;
            value >>= 1;
        }
        return numberOfBitsSetToOne;
    }
}
