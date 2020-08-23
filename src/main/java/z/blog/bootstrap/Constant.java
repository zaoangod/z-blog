package z.blog.bootstrap;

import java.io.File;

import static java.io.File.separator;

/**
 * 常量存储
 */
public class Constant {
    //CLASSPATH
    public static String CLASSPATH = new File(Constant.class.getResource("/").getPath()).getPath();
    //系统安装锁文件位置
    public static String INSTALL_LOCK = CLASSPATH + separator + "install.lock";
    ///数据库名
    public static String DB_NAME = "blog.db";
    //数据库正式环境位置
    public static String PROD_DB_PATH = CLASSPATH + separator + DB_NAME;
    //数据库开发环境位置
    public static String DEV_DB_PATH = System.getProperty("user.dir") + separator + DB_NAME;
    //数据库链接
    public static String DB_SRC;
    //是否已经初始化过系统
    public static Boolean INSTALLED = false;

    /**
     * 存储key
     */
    //网站标题
    public static final String OPT_SITE_TITLE = "site_title";
    //网站子标题
    public static final String OPT_SITE_SUBTITLE = "site_subtitle";
    //网站url
    public static final String OPT_SITE_URL = "site_url";
    //网站关键字
    public static final String OPT_SITE_KEYWORD = "site_keyword";
    //网站描述
    public static final String OPT_SITE_DESCRIPTION = "site_description";
    //主题名称
    public static final String OPT_SITE_THEME = "site_theme";
    //主题名称
    public static final String SITE_PAGE_LIMIT = "site_page_limit";
    //主题名称
    public static final String SITE_INSTALL = "site_install";
    //主题名称
    public static final String SITE_COMMENT_AUDIT = "site_comment_audit";

    /**
     * 文件夹名称
     */
    //默认主题
    public static final String DEFAULT_THEME = "default";
    //默认
    public static final String DEFAULT = "default";
    //模板文件夹
    public static final String TEMPLATES = "templates";
    //管理页面文件夹
    public static final String ADMIN = "admin";
    //主题文件夹
    public static final String THEME = "theme";
    //静态资源文件夹
    public static final String STATIC = "static";

    /**
     * url前缀
     */
    //文章访问路径前缀
    public static final String URL_PREFIX_ARTICLE = "article";

    //最大获取文章条数
    public static final int SYS_MAX_POST = 9999;

    //###############################################################################
    //###############################################################################
    //###############################################################################
    //###############################################################################
    //###############################################################################
    //###############################################################################
    //###############################################################################
    //###############################################################################

    /**
     * 存储key
     */
    //附件存放的URL，默认为网站地址，如集成第三方则为第三方CDN域名
    public static final String OPT_ATTACH_URL = "attach_url";
    //分页每页数量
    public static final String OPT_PAGE_LIMIT = "site_page_limit";
    //是否允许安装
    public static final String OPT_ALLOW_INSTALL = "allow_install";
    public static final String OPT_ALLOW_COMMENT_AUDIT = "allow_comment_audit";
    public static final String OPT_SAFE_REMEMBER_ME = "safe_remember_me";

    //首页地址
    public static final String PATH_PREFIX_INDEX = "/";
    //归档地址
    public static final String PATH_PREFIX_ARCHIVE = "archive";
    //分类地址
    public static final String PATH_PREFIX_CATEGORY = "category";
    //标签地址
    public static final String PATH_PREFIX_TAG = "tag";

    //分页最大页码
    public static final int SYS_MAX_PAGE = 999;
    //上传附件默认最大限制
    public static final int SYS_MAX_FILE_SIZE = 20480;
    //安装锁
    //public static String SYS_INSTALL_LOCK = "install.lock";
    //

    public static final String SQL_QUERY_METAS = "select a.*, count(b.cid) as count from t_metas a left join `t_relationships` b on a.mid = b.mid " + "where a.type = ? and a.name = ? group by a.mid";

    public static final String SQL_QUERY_ARTICLES = "select a.* from t_contents a left join t_relationships b on a.cid = b.cid " + "where b.mid = ? and a.status = 'publish' and a.type = 'post' order by a.created desc";

    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    //
    /*public static final String CLASSPATH = BladeKit.getCurrentClassPath();

    public static final String PATH_TEMPLATES = "templates";
    public static final String PATH_PLUGINS = "plugins";
    public static final String PATH_THEMES = "themes";
    public static final String PATH_STATIC = "static";

    public static final String DEFAULT_THEME = "default";

    public static Environment OPTIONS = Environment.of(new HashMap<>());

    public static Environment BCONF = null;

    public static final String REMEMBER_IN_COOKIE = "remember_me";
    public static final String LOGIN_ERROR_COUNT = "login_error_count";
    public static final String LOGIN_SESSION_KEY = "login_user";
    public static String REMEMBER_TOKEN = "";


    *//**
     * 设置对每个文章*秒可以评论一次
     * <p>单位秒</p>
     *//*
    public static final int COMMENT_FREQUENCY_SECOND_30 = 30;



    *//**
     * 文章最多可以输入的文字数
     *//*
    public static final int MAX_TEXT_COUNT = 200000;

    *//**
     * 文章标题最多可以输入的文字个数
     *//*
    public static final int MAX_TITLE_COUNT = 200;

    *//**
     * 插件菜单
     *//*
    public static final List<PluginMenu> PLUGIN_MENUS = new ArrayList<>(10);

    *//**
     * 插件菜单 Attribute Name
     *//*
    public static final String PLUGINS_MENU_NAME = "plugin_menus";

    *//**
     * 上传文件最大20M
     *//*
    public static Integer MAX_FILE_SIZE = 204800;

    *//**
     * 要过滤的ip列表
     *//*
    public static final Set<String> BLOCK_IPS = new HashSet<>(16);





    //静态资源URI
    public static final String STATIC_URI = "/static";
    //安装页面URI
    public static final String INSTALL_URI = "/install";
    //后台URI前缀
    public static final String ADMIN_URI = "/admin";
    //后台登录地址
    public static final String LOGIN_URI = "/admin/login";
    //文章地址前缀
    public static final String ARTICLE_URL = "/article";

    public static final String ENV_SUPPORT_163_MUSIC = "app.support_163_music";
    public static final String ENV_SUPPORT_GIST = "app.support_gist";
    public static final String MP3_PREFIX = "[mp3:";
    public static final String MUSIC_IFRAME = "<iframe frameborder=\"no\" border=\"0\" marginwidth=\"0\" marginheight=\"0\" width=350 height=106 src=\"//music.163.com/outchain/player?type=2&id=$1&auto=0&height=88\"></iframe>";
    public static final String MUSIC_REG_PATTERN = "\\[mp3:(\\d+)\\]";
    public static final String GIST_PREFIX_URL = "https://gist.github.com/";
    public static final String GIST_REG_PATTERN = "&lt;script src=\"https://gist.github.com/(\\w+)/(\\w+)\\.js\">&lt;/script>";
    public static final String GIST_REPLATE_PATTERN = "<script src=\"https://gist.github.com/$1/$2\\.js\"></script>";

    public static final String SQL_QUERY_METAS = "select a.*, count(b.cid) as count from t_metas a left join `t_relationships` b on a.mid = b.mid " +
            "where a.type = ? and a.name = ? group by a.mid";

    public static final String SQL_QUERY_ARTICLES = "select a.* from t_contents a left join t_relationships b on a.cid = b.cid " +
            "where b.mid = ? and a.status = 'publish' and a.type = 'post' order by a.created desc";


    public static final String COMMENT_APPROVED = "approved";
    public static final String COMMENT_NO_AUDIT = "no_audit";
    public static final Integer COMMENT_PARENT = 0;


    public static final String OPTION_SITE_THEME = "site_theme";
    public static final String OPTION_ALLOW_INSTALL = "allow_install";
    public static final String OPTION_ALLOW_COMMENT_AUDIT = "allow_comment_audit";
    public static final String OPTION_SAFE_REMEMBER_ME = "safe_remember_me";
*/
}