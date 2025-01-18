
public class Solution {

    public int minimizeXor(int firstInput, int secondInput) {
        int numberOfBitsSetToOneInFirstInput = countNumberOfBitsSetToOne(firstInput);
        int numberOfBitsSetToOneInSecondInput = countNumberOfBitsSetToOne(secondInput);

        if (numberOfBitsSetToOneInFirstInput == numberOfBitsSetToOneInSecondInput) {
            return firstInput;
        }

        int bitsEqualizer = 1;
        int minXor = firstInput;
        int surplusBits = Math.abs(numberOfBitsSetToOneInSecondInput - numberOfBitsSetToOneInFirstInput);
        boolean greaterNumberOfBitsSetToOneInFirstInput = numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput;

        while (surplusBits > 0) {
            if (greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer & minXor) == 0) {
                minXor ^= bitsEqualizer;
                --surplusBits;
            } else if (!greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer & minXor) != 0) {
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
