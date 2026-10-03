class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int i = 0;
        int j = 1;
        while (j <= n / 2) {
            if (n % j == 0) {
                boolean match = true;
                for (int k = j; k < n; k++) {
                    if (s.charAt(k) != s.charAt(k % j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
            j++;
        }
        return false;
    }
}