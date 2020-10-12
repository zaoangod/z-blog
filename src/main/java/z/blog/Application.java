package z.blog;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import spark.Spark;
import z.blog.bootstrap.Bootstrap;
import z.blog.bootstrap.ViewConfig;
import z.blog.kit.CacheKit;
import z.blog.route.Admin;
import z.blog.route.Content;
import z.blog.route.Home;
import z.blog.service.CommentService;
import z.blog.service.ContentService;
import z.blog.service.MetaService;
import z.blog.service.SiteService;

import static z.blog.bootstrap.Constant.TEMPLATES;
import static z.blog.model.dto.Type.json;

@Slf4j
public class Application {

    //模板引擎
    public final static ViewConfig view = new ViewConfig();
    //缓存
    public final static CacheKit CACHE = CacheKit.cache();
    //站点Service
    public final static SiteService siteService = new SiteService();
    //MetaService
    public final static MetaService metaService = new MetaService();
    //内容Service
    public final static ContentService contentService = new ContentService();
    //评论Service
    public final static CommentService commentService = new CommentService();

    public static void main(String[] args) {
        //系统初始化
        Bootstrap.init();
        //静态资源加载路径前缀
        Spark.staticFiles.location("/" + TEMPLATES);
        //静态资源过期时间
        Spark.staticFiles.expireTime(3600);
        //设置端口
        Spark.port(9876);
        //路由-开始
        Spark.before("*", (a, b) -> {
            // log.info("=> 请求地址: {}", a.url());
            // Map<String, String> cookies = a.cookies();
            // log.info("=> {}", new Gson().toJson(cookies));
            // log.info("=> {}", new Gson().toJson(a.headers("Referer")));
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

        //admin
        Spark.path("/a", () -> {
            Spark.get("/:template", Admin.template);
            Spark.get("/i/article", json, Admin.getArticlePage, new Gson()::toJson);
            Spark.path("/i", () -> {
                Spark.get("/meta", json, Admin.getMetaList, new Gson()::toJson);
                Spark.post("/meta", json, Admin.saveMeta, new Gson()::toJson);
                Spark.get("/meta/:mid", json, Admin.getMeta, new Gson()::toJson);
                Spark.delete("/meta/:mid", Admin.delMeta, new Gson()::toJson);
            });
        });

        //首页
        Spark.get("/", Home.index);
        Spark.get("/index/:pageNum", Home.index);
        //文章内容页面
        Spark.get("/article/:aid", Content.content);
        //归档
        Spark.get("/archive", Home.archive);
        Spark.get("/archive/:pageNum", Home.archive);
        //分类
        Spark.get("/category", Home.category);
        //标签
        Spark.get("/tag", Home.tag);
        //
        Spark.path("/meta", () -> {
            Spark.get("/:mid", Home.metaInfo);
            Spark.get("/:mid/:pageNum", Home.metaInfo);
        });
        //自定义页面
        Spark.get("/page/:aid", Content.content);
        //启用gzip
        Spark.after((a, b) -> b.header("Content-Encoding", "gzip"));
        log.info("http://127.0.0.1:{}", Spark.port());
    }
}