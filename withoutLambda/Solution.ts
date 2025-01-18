
function minimizeXor(firstInput: number, secondInput: number): number {
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

function countNumberOfBitsSetToOne(value: number): number {
    let numberOfBitsSetToOne = 0;
    while (value > 0) {
        numberOfBitsSetToOne += value & 1;
        value >>= 1;
    }
    return numberOfBitsSetToOne;
}
