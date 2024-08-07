// https://leetcode.com/problems/valid-palindrome

class ValidPalindrome {
    public boolean isPalindrome(String str) {
        String newStr = str.replaceAll("[^a-zA-Z0-9]","");
        newStr = newStr.toLowerCase();
        int i, low = 0, high = newStr.length() - 1;
        while (low < high) {
            if (newStr.charAt(low) != newStr.charAt(high))
                return false;

            low++;
            high--;
        }
        return true;
        
    }
}