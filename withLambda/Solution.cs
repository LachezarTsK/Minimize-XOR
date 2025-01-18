
using System;
using System.Linq;

public class Solution
{
    public int MinimizeXor(int firstInput, int secondInput)
    {
        int numberOfBitsSetToOneInFirstInput = CountNumberOfBitsSetToOne(firstInput);
        int numberOfBitsSetToOneInSecondInput = CountNumberOfBitsSetToOne(secondInput);

        if (numberOfBitsSetToOneInFirstInput == numberOfBitsSetToOneInSecondInput)
        {
            return firstInput;
        }

        int surplusBits = Math.Abs(numberOfBitsSetToOneInSecondInput - numberOfBitsSetToOneInFirstInput);
        bool greaterNumberOfBitsSetToOneInFirstInput = numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput;

        Func<int, bool> compare = greaterNumberOfBitsSetToOneInFirstInput ? (x) => x == 0 : (x) => x != 0;
        return FindMinXOR(firstInput, surplusBits, compare);
    }

    private int FindMinXOR(int firstInput, int surplusBits, Func<int, bool> compare)
    {
        int bitsEqualizer = 1;
        int minXor = firstInput;

        while (surplusBits > 0)
        {
            if (compare(bitsEqualizer & minXor))
            {
                minXor ^= bitsEqualizer;
                --surplusBits;
            }
            bitsEqualizer <<= 1;
        }
        return minXor;
    }

    private int CountNumberOfBitsSetToOne(int value)
    {
        int numberOfBitsSetToOne = 0;
        while (value > 0)
        {
            numberOfBitsSetToOne += value & 1;
            value >>= 1;
        }
        return numberOfBitsSetToOne;
    }
}
