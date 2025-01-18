
#include <cmath>
using namespace std;

class Solution {

public:
    int minimizeXor(int firstInput, int secondInput) const {
        int numberOfBitsSetToOneInFirstInput = countNumberOfBitsSetToOne(firstInput);
        int numberOfBitsSetToOneInSecondInput = countNumberOfBitsSetToOne(secondInput);

        if (numberOfBitsSetToOneInFirstInput == numberOfBitsSetToOneInSecondInput) {
            return firstInput;
        }

        int bitsEqualizer = 1;
        int minXor = firstInput;
        int surplusBits = abs(numberOfBitsSetToOneInSecondInput - numberOfBitsSetToOneInFirstInput);
        bool greaterNumberOfBitsSetToOneInFirstInput = numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput;

        while (surplusBits > 0) {
            if (greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer & minXor) == 0) {
                minXor ^= bitsEqualizer;
                --surplusBits;
            }
            else if (!greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer & minXor) != 0) {
                minXor ^= bitsEqualizer;
                --surplusBits;
            }
            bitsEqualizer <<= 1;
        }
        return minXor;
    }

private:
    int countNumberOfBitsSetToOne(int value) const {
        int numberOfBitsSetToOne = 0;
        while (value > 0) {
            numberOfBitsSetToOne += value & 1;
            value >>= 1;
        }
        return numberOfBitsSetToOne;
    }
};
