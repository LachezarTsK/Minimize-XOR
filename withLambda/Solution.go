
package main

import "math"

func minimizeXor(firstInput int, secondInput int) int {
    numberOfBitsSetToOneInFirstInput := countNumberOfBitsSetToOne(firstInput)
    numberOfBitsSetToOneInSecondInput := countNumberOfBitsSetToOne(secondInput)

    if numberOfBitsSetToOneInFirstInput == numberOfBitsSetToOneInSecondInput {
        return firstInput
    }

    surplusBits := int(math.Abs(float64(numberOfBitsSetToOneInSecondInput) - float64(numberOfBitsSetToOneInFirstInput)))
    greaterNumberOfBitsSetToOneInFirstInput := numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput

    var compare func(int) bool
    if greaterNumberOfBitsSetToOneInFirstInput {
        compare = func(x int) bool { return x == 0 }
    } else {
        compare = func(x int) bool { return x != 0 }
    }

    return findMinXOR(firstInput, surplusBits, compare)
}

func findMinXOR(firstInput int, surplusBits int, compare func(int) bool) int {
    bitsEqualizer := 1
    minXor := firstInput

    for surplusBits > 0 {
        if compare(bitsEqualizer & minXor) {
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
