public class Binomial { 
    public static void main(String[] args) {
        // ... code ...
    }

    public static int binomial1(int n, int k) { 
        // ... implementation of binomial1 ...
        return 0; // (Your implementation here)
     }
    
    // 1. שינינו את הערך המוחזר ל-long
    public static long binomial(int n, int k) {
        if (k > n) return 0;
        
        // 2. שינינו את המערך ל-long[][]
        long[][] memo = new long[n + 1][k + 1];
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }
        return binomial(n, k, memo);
    }

    // 3. שינינו את החתימה ל-long
    private static long binomial(int n, int k, long[][] memo) {
        if (memo[n][k] != -1) {
            return memo[n][k];
        }
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) {
            memo[n][k] = 1; 
            return 1;
        }
        
        // החישוב מתבצע ב-long ולכן לא תהיה גלישה
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}