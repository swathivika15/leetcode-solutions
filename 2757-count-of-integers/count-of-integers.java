class Solution {
    static final int MOD = 1_000_000_007;
    static int minSum, maxSum;
    static int[] digits;
    static long[][][] dp;
    static boolean[][][] visited;
    static long countUpTo(String limit) {
        digits = new int[limit.length()];
        for (int i = 0; i < limit.length(); i++) {
            digits[i] = limit.charAt(i) - '0';
        }
        dp = new long[digits.length][maxSum + 1][2];
        visited = new boolean[digits.length][maxSum + 1][2];
        return digitDP(0, 0, 1);
    }
    static long digitDP(int position, int currentSum, int tight) {
        if (currentSum > maxSum) {
            return 0;
        }
        if (position == digits.length) {
            return (currentSum >= minSum && currentSum <= maxSum) ? 1 : 0;
        }
        if (visited[position][currentSum][tight]) {
            return dp[position][currentSum][tight];
        }
        visited[position][currentSum][tight] = true;
        long ways = 0;
        int maximumDigit = (tight == 1) ? digits[position] : 9;
        for (int chosenDigit = 0; chosenDigit <= maximumDigit; chosenDigit++) {
            int newSum = currentSum + chosenDigit;
            if (newSum > maxSum) {
                continue;
            }
            int newTight = 0;
            if (tight == 1 && chosenDigit == digits[position]) {
                newTight = 1;
            }
            ways += digitDP(position + 1,newSum,newTight);
            ways %= MOD;
        }
        dp[position][currentSum][tight] = ways;
        return ways;
    }
    public int count( String num1,String num2,int min_sum,int max_sum) {
        minSum = min_sum;
        maxSum = max_sum;
        long right = countUpTo(num2);
        String num1MinusOne = subtractOne(num1);
        long left = countUpTo(num1MinusOne);
        return (int)((right - left + MOD) % MOD);
    }
    static String subtractOne(String number) {
        char[] digitsArray = number.toCharArray();
        int index = digitsArray.length - 1;
        while (digitsArray[index] == '0') {
            digitsArray[index] = '9';
            index--;
        }
        digitsArray[index]--;
        if (digitsArray.length > 1 && digitsArray[0] == '0') {
            return new String(digitsArray,1,digitsArray.length - 1);
        }
        return new String(digitsArray);
    }
}