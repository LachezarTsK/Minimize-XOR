
function minimizeXor(firstInput: number, secondInput: number): number {
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

function findMinXOR(firstInput: number, surplusBits: number, compare: (number) => boolean) {
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

function countNumberOfBitsSetToOne(value: number): number {
    let numberOfBitsSetToOne = 0;
    while (value > 0) {
        numberOfBitsSetToOne += value & 1;
        value >>= 1;
    }
    return numberOfBitsSetToOne;
}
