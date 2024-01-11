class Solution {
    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        Map<Character, String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        generateCombinations(digits, 0, new StringBuilder(), digitToLetters, result);
        return result;
    }

    private static void generateCombinations(String digits, int index, StringBuilder current,
    Map<Character, String> digitToLetters, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        char digit = digits.charAt(index);
        String letters = digitToLetters.get(digit);

        for (char letter : letters.toCharArray()) {
            current.append(letter);
            generateCombinations(digits, index + 1, current, digitToLetters, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}