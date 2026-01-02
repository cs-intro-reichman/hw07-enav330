/** Computes the binomial(n,k) function. */
public class Binomial {	
    public static void main(String[] args) {
        // דוגמה לבדיקה: 5 מעל 2 צריך לצאת 10
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);

        System.out.println(binomial1(n, k));
        System.out.println(binomial(n, k));
    }

    // Computes the Binomial function, basic version.
    public static int binomial1(int n, int k) {
        // תנאי עצירה: אם k גדול מ-n, אין דרך לבחור
        if (k > n) return 0;
        // תנאי עצירה: בחירה של 0 איברים או בחירה של כל האיברים נותנת אפשרות אחת
        if (k == 0 || k == n) return 1;
        
        // הנוסחה הרקורסיבית (משולש פסקל)
        return binomial1(n - 1, k - 1) + binomial1(n - 1, k);
    }

    // Computes the Binomial function, efficiently
    public static int binomial(int n, int k) {
        // אופטימיזציה קטנה: אם הקלט לא חוקי בסיסית, נחזיר 0 מיד
        if (k > n) return 0;

        // יצירת מערך הזיכרון בגודל המתאים
        int[][] memo = new int[n + 1][k + 1];

        // אתחול המערך בערך -1 (שמסמן "טרם חושב")
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                memo[i][j] = -1;
            }
        }

        // קריאה לפונקציית העזר שמבצעת את העבודה
        return binomial(n, k, memo);
    }

    // פונקציית העזר (כבר הייתה לך בקוד, הוספתי שיפור קטן לתנאי העצירה)
    private static int binomial(int n, int k, int[][] memo) {
        // בדיקה האם הערך כבר חושב בעבר
        if (memo[n][k] != -1) {
            return memo[n][k];
        }

        // תנאי עצירה
        if (k > n) {
            return 0;
        }
        if (k == 0 || k == n) { // שים לב: k==n הוא גם תנאי עצירה חשוב שמחזיר 1
            memo[n][k] = 1;
            return 1;
        }

        // חישוב רקורסיבי ושמירה במערך הזיכרון
        memo[n][k] = binomial(n - 1, k, memo) + binomial(n - 1, k - 1, memo);
        return memo[n][k];
    }
}
