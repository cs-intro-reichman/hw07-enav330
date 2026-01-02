/** Returns the binary representation of a given integer. */
public class IntToBin {

    public static void main(String[] args) {
        // מומלץ להוסיף בדיקה שקיבלנו קלט
        if (args.length > 0) {
            int x = Integer.parseInt(args[0]);
            System.out.println("Binary representation of " + x + " is: " + toBinary(x));
        }
    }

    /** Returns the binary representation of the given integer, as a string of 0's and 1's.  */
    public static String toBinary(int x) {
        // תנאי עצירה: אם המספר הוא 0 או 1, הייצוג הבינארי הוא המספר עצמו
        // (במקרה של 0 מחזירים "0", במקרה של 1 מחזירים "1")
        if (x < 2) {
            return Integer.toString(x);
        }
        
        // הצעד הרקורסיבי:
        // 1. קוראים לפונקציה עבור חצי מהמספר (השלם) - זה ייתן את ההתחלה של המחרוזת
        // 2. משרשרים בסוף את השארית של החלוקה ב-2 (0 או 1)
        return toBinary(x / 2) + (x % 2);
    }    
 }