
import kotlin.math.abs

class Solution {

    fun minimizeXor(firstInput: Int, secondInput: Int): Int {
        val numberOfBitsSetToOneInFirstInput = countNumberOfBitsSetToOne(firstInput)
        val numberOfBitsSetToOneInSecondInput = countNumberOfBitsSetToOne(secondInput)

        if (numberOfBitsSetToOneInFirstInput == numberOfBitsSetToOneInSecondInput) {
            return firstInput
        }

        val surplusBits = abs(numberOfBitsSetToOneInSecondInput - numberOfBitsSetToOneInFirstInput)
        val greaterNumberOfBitsSetToOneInFirstInput =
            numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput

        val compare = if (greaterNumberOfBitsSetToOneInFirstInput) { x: Int -> x == 0 } else { x: Int -> x != 0 }
        return findMinXOR(firstInput, surplusBits, compare)
    }

    private fun findMinXOR(firstInput: Int, surplusBits: Int, compare: (Int) -> Boolean): Int {
        var bitsEqualizer = 1
        var minXor = firstInput
        var surplusBits = surplusBits

        while (surplusBits > 0) {
            if (compare(bitsEqualizer and minXor)) {
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
