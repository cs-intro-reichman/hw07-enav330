public class IsSorted {

    // Public function: called by the user
    public static boolean isSorted(int[] a) {
        return isSorted(a, 0);
    }

    // Helper recursive function
    private static boolean isSorted(int[] a, int i) {
        // תנאי עצירה: אם הגענו לאיבר האחרון (או שהמערך ריק/בעל איבר אחד), סיימנו בהצלחה
        if (i >= a.length - 1) {
            return true;
        }
        
        // בדיקת הזוג הנוכחי: אם האיבר הנוכחי גדול מהבא אחריו -> המערך לא ממוין
        if (a[i] > a[i+1]) {
            return false;
        }
        
        // הצעד הרקורסיבי: הכל בסדר בינתיים, בוא נבדוק את הזוג הבא
        return isSorted(a, i + 1);
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 5};
        System.out.println(isSorted(a)); // true

        int[] b = {1, 3, 2};
        System.out.println(isSorted(b)); // false
        
        int[] c = {5};
        System.out.println(isSorted(c)); // true (מקרה קצה של איבר בודד)
    }
}
