package z.blog.extension;

import jetbrick.template.JetAnnotations;
import jetbrick.template.runtime.InterpretContext;
import z.blog.model.dto.Statistic;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;
import java.util.regex.Pattern;

import static spark.utils.StringUtils.isBlank;
import static z.blog.Application.CACHE;
import static z.blog.Application.siteService;
import static z.blog.bootstrap.Constant.*;

/**
 * 公共函数
 *
 * @author zaoangod
 */
@JetAnnotations.Functions
public final class Common {

    private static final Pattern SRC_PATTERN = Pattern.compile("src\\s*=\\s*\'?\"?(.*?)(\'|\"|>|\\s+)");

    /**
     * 获取网站设置项
     *
     * @param key key
     * @return 结果
     */
    public static String siteOption(String key) {
        return siteOption(key, "");
    }

    /**
     * 获取网站设置项
     *
     * @param key          key
     * @param defaultValue 默认值
     * @return 结果
     */
    public static String siteOption(String key, String defaultValue) {
        if (isBlank(key)) {
            return defaultValue;
        }
        return Optional.ofNullable(CACHE.get(key)).map(Object::toString).orElse(defaultValue);
    }

    /**
     * 获取网站链接
     *
     * @return url 网站链接
     */
    public static String siteUrl() {
        return siteOption(OPT_SITE_URL);
    }

    /**
     * 获取当前主题名称
     *
     * @return 当前主题名称
     */
    public static String siteTheme() {
        return siteOption(OPT_SITE_THEME, DEFAULT_THEME);
    }

    /**
     * 获取网站标题
     *
     * @return 网站标题
     */
    public static String siteTitle() {
        return siteOption(OPT_SITE_TITLE);
    }

    /**
     * 获取网站子标题
     *
     * @return 网站子标题
     */
    public static String siteSubtitle() {
        return siteOption(OPT_SITE_SUBTITLE);
    }

    /**
     * 获取站点设置的描述信息
     *
     * @return 站点设置的描述信息
     */
    public static String siteDesc() {
        return siteOption(OPT_SITE_DESCRIPTION);
    }

    /**
     * 获取主题下的文件路径
     *
     * @return 主题下的文件路径
     */
    public static String themeUrl() {
        return "/" + THEME + "/" + DEFAULT_THEME + "/" + STATIC;
    }

    /**
     * 获取当前页面标题
     *
     * @return 当前页面标题
     */
    public static String pageTitle() {
        InterpretContext ctx = InterpretContext.current();
        Object value = ctx.getValueStack().getValue("title");
        if (null != value) {
            return String.valueOf(value);
        }
        return siteOption(OPT_SITE_TITLE, "博客");
    }

    /**
     * 获取当前网页关键字
     *
     * @return 网页关键字
     */
    public static String pageKeyword() {
        InterpretContext ctx = InterpretContext.current();
        Object value = ctx.getValueStack().getValue("keyword");
        if (null != value) {
            return value.toString();
        }
        return siteOption(OPT_SITE_KEYWORD);
    }

    /**
     * 获取当前网页描述
     *
     * @return 网页描述
     */
    public static String pageDesc() {
        InterpretContext ctx = InterpretContext.current();
        Object value = ctx.getValueStack().getValue("description");
        if (null != value) {
            return value.toString();
        }
        return siteOption(OPT_SITE_DESCRIPTION);
    }

    /**
     * 获取主题设置选项
     *
     * @param key key
     * @return 主题设置项
     */
    public static String themeOption(String key) {
        return themeOption(key, "");
    }

    /**
     * 返回主题设置选项
     *
     * @param key          key
     * @param defaultValue 默认值
     * @return 主题设置项
     */
    public static String themeOption(String key, String defaultValue) {
        if (isBlank(key)) {
            return defaultValue;
        }
        return Optional.ofNullable(CACHE.get(key)).map(String::valueOf).orElse(defaultValue);
    }

    /**
     * 获取附件存放的URL
     *
     * @return 附件存放的URL
     */
    public static String attachURL() {
        return siteOption(OPT_ATTACH_URL, siteUrl());
    }

    /**
     * 获取后台统计数据
     *
     * @return 后台统计数据
     */
    public static Statistic statistic() {
        return siteService.getStatistic();
    }

    /**
     * 根据邮箱地址获取头像
     *
     * @param email email
     * @return 头像地址
     */
    /*public static String avatar(String email) {
        String avatarUrl = "https://cn.gravatar.com/avatar/";
        if (isBlank(email)) {
            return avatarUrl;
        }
        return avatarUrl + GravatarMD5Util.MD5Hex(email);
    }*/

    /**
     * 格式化unix时间戳为日期字符串
     *
     * @param unixTime unix时间戳
     * @param patten   日期格式(patten = yyyy-MM-dd HH:mm:ss)
     * @return 格式化后的日期
     */
    public static String fmtDate(Integer unixTime, String patten) {
        if (unixTime == null || patten == null) {
            return "";
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(patten);
        Instant instant = Instant.ofEpochMilli(unixTime);
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault()).format(dtf);
    }

    /**
     * 在最小和最大范围内随机生成一个数字
     *
     * @param min 最小值
     * @param max 最大值
     * @return 随机生成一个数字
     */
    public static int random(int min, int max) {
        return new Random().nextInt(max) % (max - min + 1) + min;
    }

    /**
     * 转化emoji表情
     * <p>grinning:awesome :smiley:string &#128516;with a few :wink:emojis!</p>
     *
     * @param value 要转化的字符串
     * @return 转化后的emoji表情
     */
    /*public static String emoji(String value) {
        return EmojiParser.parseToUnicode(value);
    }*/
}