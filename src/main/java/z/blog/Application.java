package z.blog;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import spark.Spark;
import z.blog.bootstrap.Bootstrap;
import z.blog.controller.Content;
import z.blog.controller.Home;
import z.blog.kit.CacheKit;
import z.blog.service.CommentService;
import z.blog.service.ContentService;
import z.blog.service.MetaService;
import z.blog.service.SiteService;

import java.util.Map;

import static z.blog.bootstrap.Constant.TEMPLATES;

@Slf4j
public class Application {

    public static CacheKit CACHE;
    public static SiteService siteService;
    public static MetaService metaService;
    public static ContentService contentService;
    public static CommentService commentService;

    static {
        //缓存
        CACHE = CacheKit.cache();
        siteService = new SiteService();
        metaService = new MetaService();
        contentService = new ContentService();
        commentService = new CommentService();
    }

    public static void main(String[] args) {
        //系统初始化
        Bootstrap.init();
        //静态资源加载路径前缀
        Spark.staticFiles.location("/" + TEMPLATES);
        Spark.staticFiles.expireTime(3600);
        //设置端口
        Spark.port(9876);

        //路由-开始

        /*路由*/
        Spark.before("*", (a, b) -> {
            log.info("=> 请求地址: {}", a.url());
            Map<String, String> cookies = a.cookies();
            log.info("=> {}", new Gson().toJson(cookies));
            log.info("=> {}", new Gson().toJson(a.headers("Referer")));
            /*boolean installUrl = a.url().endsWith("/install");
            boolean installLock = Files.exists(Paths.get(INSTALL_LOCK));
            if (installUrl && !installLock) {
                log.info("初始化系统");
                // b.redirect("/install");
            }*/
        });
        Spark.options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            log.info("=> Access-Control-Request-Headers: {}", accessControlRequestHeaders);
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            log.info("=> Access-Control-Request-Method: {}", accessControlRequestMethod);
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        Spark.before((request, response) -> {
            response.header("Content-Type", "text/html; charset=UTF-8");
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.header("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
            //response.type("application/json");
        });
        //
        Spark.get("/", Home.index);
        //index
        Spark.get("/index/:pageNum", Home.index);
        //文章内容页面
        Spark.get("/article/:aid", Content.post);
        //归档
        Spark.get("/archive", Home.archive);
        Spark.get("/archive/:pageNum", Home.archive);
        //分类
        Spark.get("/category", Home.category);
        Spark.get("/category/:mid/:pageNum", Home.category);

        //启用gzip
        Spark.after((a, b) -> b.header("Content-Encoding", "gzip"));
        log.info("http://127.0.0.1:{}", Spark.port());

        contentService.getArchive(1, 20);
    }
}