
import kotlin.math.abs

class Solution {

    fun minimizeXor(firstInput: Int, secondInput: Int): Int {
        val numberOfBitsSetToOneInFirstInput = countNumberOfBitsSetToOne(firstInput)
        val numberOfBitsSetToOneInSecondInput = countNumberOfBitsSetToOne(secondInput)

        if (numberOfBitsSetToOneInFirstInput == numberOfBitsSetToOneInSecondInput) {
            return firstInput
        }

        var bitsEqualizer = 1
        var minXor = firstInput
        var surplusBits = abs(numberOfBitsSetToOneInSecondInput - numberOfBitsSetToOneInFirstInput)
        val greaterNumberOfBitsSetToOneInFirstInput = numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput

        while (surplusBits > 0) {
            if (greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer and minXor) == 0) {
                minXor = minXor xor bitsEqualizer
                --surplusBits
            } else if (!greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer and minXor) != 0) {
                minXor = minXor xor bitsEqualizer
                --surplusBits
            }
            bitsEqualizer = bitsEqualizer shl 1
        }
        return minXor
    }

    private fun countNumberOfBitsSetToOne(value: Int): Int {
        var numberOfBitsSetToOne = 0
        var value = value
        while (value > 0) {
            numberOfBitsSetToOne += value and 1
            value = value shr 1
        }
        return numberOfBitsSetToOne
    }
}
