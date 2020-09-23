package z.blog.kit;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BlogKit {

    static final Pattern numberPattern = Pattern.compile("^[0-9]*$");

    /**
     * 是否为数字
     *
     * @param str 字符串
     * @return 结果
     */
    public static boolean isNumber(String str) {
        if (str != null) {
            return numberPattern.matcher(str).matches();
        } else {
            return false;
        }
    }

    public static int getInstant() {
        return (int) LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
    }

}