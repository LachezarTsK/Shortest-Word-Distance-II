
#include<unordered_map>
#include<vector>
using namespace std;

class WordDistance {
public:
    unordered_map<string, vector<int>> positions;

    WordDistance(vector<string>& wordsDict) {

        int size = wordsDict.size();
        for (int i = 0; i < size; i++) {
            if (positions.find(wordsDict[i]) == positions.end()) {
                vector<int> indexes{ i};
                positions[wordsDict[i]] = indexes;
            }
            positions[wordsDict[i]].push_back(i);
        }
    }

    int shortest(string word1, string word2) {
        int shortestDistance = 3 * pow(10, 4) + 1;
        vector<int> positions_word1 = positions[word1];
        vector<int> positions_word2 = positions[word2];

        size_t size_word1 = positions_word1.size();
        size_t size_word2 = positions_word2.size();
        int index_word1 = 0;
        int index_word2 = 0;

        while (index_word1 < size_word1 && index_word2 < size_word2) {

            int first = positions_word1[index_word1];
            int second = positions_word2[index_word2];

            shortestDistance = min(shortestDistance, abs(first - second));

            if (first < second) {
                index_word1++;
            } else {
                index_word2++;
            }
        }
        return shortestDistance;
    }
};
