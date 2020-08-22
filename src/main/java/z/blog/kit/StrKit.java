package z.blog.kit;

public class StrKit {

    public static boolean yBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean nBlank(CharSequence cs) {
        return !yBlank(cs);
    }
}
