
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class WordDistance {

    Map<String, List<Integer>> positions;

    public WordDistance(String[] wordsDict) {

        positions = new HashMap<>();
        int size = wordsDict.length;
        for (int i = 0; i < size; i++) {
            positions.putIfAbsent(wordsDict[i], new ArrayList<>());
            positions.get(wordsDict[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {

        int shortestDistance = 3 * (int) Math.pow(10, 4) + 1;
        List<Integer> positions_word1 = positions.get(word1);
        List<Integer> positions_word2 = positions.get(word2);

        int size_word1 = positions_word1.size();
        int size_word2 = positions_word2.size();
        int index_word1 = 0;
        int index_word2 = 0;

        while (index_word1 < size_word1 && index_word2 < size_word2) {

            int first = positions_word1.get(index_word1);
            int second = positions_word2.get(index_word2);

            shortestDistance = Math.min(shortestDistance, Math.abs(first - second));

            if (first < second) {
                index_word1++;
            } else {
                index_word2++;
            }
        }
        return shortestDistance;
    }
}
