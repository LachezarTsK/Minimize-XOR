
/**
 * @param {number} firstInput
 * @param {number} secondInput
 * @return {number}
 */
var minimizeXor = function (firstInput, secondInput) {
    const numberOfBitsSetToOneInFirstInput = countNumberOfBitsSetToOne(firstInput);
    const numberOfBitsSetToOneInSecondInput = countNumberOfBitsSetToOne(secondInput);

    if (numberOfBitsSetToOneInFirstInput === numberOfBitsSetToOneInSecondInput) {
        return firstInput;
    }

    let surplusBits = Math.abs(numberOfBitsSetToOneInSecondInput - numberOfBitsSetToOneInFirstInput);
    const greaterNumberOfBitsSetToOneInFirstInput = numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput;

    const compare = greaterNumberOfBitsSetToOneInFirstInput ? (x) => x === 0 : (x) => x !== 0;
    return findMinXOR(firstInput, surplusBits, compare);
};

/**
 * @param {number} firstInput
 * @param {number} surplusBits
 * @param {(number) => boolean} compare
 * @return {number}
 */
function findMinXOR(firstInput, surplusBits, compare) {
    let bitsEqualizer = 1;
    let minXor = firstInput;

    while (surplusBits > 0) {
        if (compare(bitsEqualizer & minXor)) {
            minXor ^= bitsEqualizer;
            --surplusBits;
        }
        bitsEqualizer <<= 1;
    }
    return minXor;
}

/**
 * @param {number} value
 * @return {number}
 */
function countNumberOfBitsSetToOne(value) {
    let numberOfBitsSetToOne = 0;
    while (value > 0) {
        numberOfBitsSetToOne += value & 1;
        value >>= 1;
    }
    return numberOfBitsSetToOne;
}
