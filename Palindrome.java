/** Checks if a given string is a palindrome. */
public class Palindrome {

    public static void main(String[] args) {
        // שימי לב: הרצת התוכנית דורשת העברת ארגומנטים (למשל דרך ה-Terminal)
        // java Palindrome madam -> יחזיר true
        // java Palindrome hello -> יחזיר false
        if (args.length > 0) {
            System.out.println(isPalindrome(args[0]));
        }
    }
    
    /** Checks if the given string is a palindrome. */
    public static boolean isPalindrome(String s) {
        // תנאי עצירה: מחרוזת ריקה או בעלת תו אחד היא תמיד פולינדרום
        if (s.length() <= 1) {
            return true;
        }
        
        // בדיקה: האם התו הראשון והתו האחרון שונים?
        if (s.charAt(0) != s.charAt(s.length() - 1)) {
            return false;
        }
        
        // הצעד הרקורסיבי: נבדוק את המחרוזת הפנימית (בלי התו הראשון והאחרון)
        // הפונקציה substring(1, length-1) מחזירה בדיוק את החלק הזה
        return isPalindrome(s.substring(1, s.length() - 1));
    }
}