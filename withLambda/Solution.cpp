
#include <cmath>
#include <functional>
using namespace std;

class Solution {

public:
    int minimizeXor(int firstInput, int secondInput) const {
        int numberOfBitsSetToOneInFirstInput = countNumberOfBitsSetToOne(firstInput);
        int numberOfBitsSetToOneInSecondInput = countNumberOfBitsSetToOne(secondInput);

        if (numberOfBitsSetToOneInFirstInput == numberOfBitsSetToOneInSecondInput) {
            return firstInput;
        }

        int surplusBits = abs(numberOfBitsSetToOneInSecondInput - numberOfBitsSetToOneInFirstInput);
        bool greaterNumberOfBitsSetToOneInFirstInput = numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput;

        auto compare = greaterNumberOfBitsSetToOneInFirstInput ? [](int x){return x == 0;} : [](int x){return x != 0;};
        return findMinXOR(firstInput, surplusBits, compare);
    }

private:
    int findMinXOR(int firstInput, int surplusBits, function<bool(int)> compare) const {
        int bitsEqualizer = 1;
        int minXor = firstInput;

        while (surplusBits > 0) {
            if (compare(bitsEqualizer & minXor)) {
                minXor ^= bitsEqualizer;
                --surplusBits;
            }
            bitsEqualizer <<= 1;
        }
        return minXor;
    }

    int countNumberOfBitsSetToOne(int value) const {
        int numberOfBitsSetToOne = 0;
        while (value > 0) {
            numberOfBitsSetToOne += value & 1;
            value >>= 1;
        }
        return numberOfBitsSetToOne;
    }
};
