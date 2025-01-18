
package main

import "math"

func minimizeXor(firstInput int, secondInput int) int {
    numberOfBitsSetToOneInFirstInput := countNumberOfBitsSetToOne(firstInput)
    numberOfBitsSetToOneInSecondInput := countNumberOfBitsSetToOne(secondInput)

    if numberOfBitsSetToOneInFirstInput == numberOfBitsSetToOneInSecondInput {
        return firstInput
    }

    bitsEqualizer := 1
    minXor := firstInput
    surplusBits := int(math.Abs(float64(numberOfBitsSetToOneInSecondInput) - float64(numberOfBitsSetToOneInFirstInput)))
    greaterNumberOfBitsSetToOneInFirstInput := numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput

    for surplusBits > 0 {
        if greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer & minXor) == 0 {
            minXor ^= bitsEqualizer
            surplusBits--
        } else if !greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer & minXor) != 0 {
            minXor ^= bitsEqualizer
            surplusBits--
        }
        bitsEqualizer <<= 1
    }
    return minXor
}

func countNumberOfBitsSetToOne(value int) int {
    numberOfBitsSetToOne := 0
    for value > 0 {
        numberOfBitsSetToOne += value & 1
        value >>= 1
    }
    return numberOfBitsSetToOne
}
