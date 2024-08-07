// https://leetcode.com/problems/check-if-all-characters-have-equal-number-of-occurrences

class OccurrencesEqual {
    public boolean areOccurrencesEqual(String str) {
     Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }
        int firstFrequency = frequencyMap.values().iterator().next();
        for (int frequency : frequencyMap.values()) {
            if (frequency != firstFrequency) {
                return false;
            }
        }

        return true;
    }
}