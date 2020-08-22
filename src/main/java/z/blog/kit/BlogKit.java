package z.blog.kit;

import java.util.regex.Pattern;

public class BlogKit {
    /**
     * 是否为数字
     *
     * @param str 字符串
     * @return 结果
     */
    public static boolean isArticleId(String str) {
        if (str != null) {
            return Pattern.compile("-?[0-9]+(\\.[0-9]+)?").matcher(str).matches();
        } else {
            return false;
        }
    }
}