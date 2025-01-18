
/**
 * @param {number} firstInput
 * @param {number} secondInput
 * @return {number}
 */
var minimizeXor = function (firstInput, secondInput) {
    let numberOfBitsSetToOneInFirstInput = countNumberOfBitsSetToOne(firstInput);
    let numberOfBitsSetToOneInSecondInput = countNumberOfBitsSetToOne(secondInput);

    if (numberOfBitsSetToOneInFirstInput === numberOfBitsSetToOneInSecondInput) {
        return firstInput;
    }

    let bitsEqualizer = 1;
    let minXor = firstInput;
    let surplusBits = Math.abs(numberOfBitsSetToOneInSecondInput - numberOfBitsSetToOneInFirstInput);
    const greaterNumberOfBitsSetToOneInFirstInput = numberOfBitsSetToOneInFirstInput < numberOfBitsSetToOneInSecondInput;

    while (surplusBits > 0) {
        if (greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer & minXor) === 0) {
            minXor ^= bitsEqualizer;
            --surplusBits;
        } else if (!greaterNumberOfBitsSetToOneInFirstInput && (bitsEqualizer & minXor) !== 0) {
            minXor ^= bitsEqualizer;
            --surplusBits;
        }
        bitsEqualizer <<= 1;
    }
    return minXor;
};

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
