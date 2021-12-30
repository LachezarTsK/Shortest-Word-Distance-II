
/**
 * @param {string[]} wordsDict
 */
var WordDistance = function (wordsDict) {

    this.positions = new Map();
    let size = wordsDict.length;
    for (let i = 0; i < size; i++) {
        if (!this.positions.has(wordsDict[i])) {
            this.positions.set(wordsDict[i], []);
        }
        this.positions.get(wordsDict[i]).push(i);
    }
};

/** 
 * @param {string} word1 
 * @param {string} word2
 * @return {number}
 */
WordDistance.prototype.shortest = function (word1, word2) {
    let shortestDistance = 3 * Math.pow(10, 4) + 1;
    const positions_word1 = this.positions.get(word1);
    const positions_word2 = this.positions.get(word2);

    let size_word1 = positions_word1.length;
    let size_word2 = positions_word2.length;
    let index_word1 = 0;
    let index_word2 = 0;

    while (index_word1 < size_word1 && index_word2 < size_word2) {

        let first = positions_word1[index_word1];
        let second = positions_word2[index_word2];

        shortestDistance = Math.min(shortestDistance, Math.abs(first - second));

        if (first < second) {
            index_word1++;
        } else {
            index_word2++;
        }
    }
    return shortestDistance;
};
