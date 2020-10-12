package z.blog.route;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import org.jooq.JSON;
import spark.Route;
import z.blog.kit.PageInfo;
import z.blog.kit.R;
import z.blog.model.entity.Article;
import z.blog.model.entity.Meta;

import java.util.List;
import java.util.Optional;

import static z.blog.Application.contentService;
import static z.blog.Application.metaService;

@Slf4j
public class Admin extends Base {
    private static final String layout = "layout";
    public static Route template = (a, b) -> {
        String page = a.params(":template");
        log.info("-> template: {}", page);
        return a(data("template", page), layout);
    };
    //文章分页
    public static Route getArticlePage = (a, b) -> {
        int               pagNum   = Optional.ofNullable(a.queryParams("pageNum")).map(Integer::parseInt).orElse(1);
        String            type     = a.queryParams("type");
        String            title    = a.queryParams("title");
        String            status   = a.queryParams("status");
        String            category = a.queryParams("category");
        Article           article  = new Article().setType(type).setTitle(title).setStatus(status).setCategory(category);
        PageInfo<Article> r        = contentService.getArticle(article, pagNum, 20);
        return R.s().setData(r);
    };
    //Meta列表
    public static Route getMetaList = (a, b) -> {
        String     type  = a.queryParams("type");
        String     title = a.queryParams("title");
        Meta       meta  = new Meta().setType(type).setTitle(title);
        List<Meta> r     = metaService.getMeta(meta);
        return R.s().setData(r);
    };
    //Meta详情
    public static Route getMeta = (a, b) -> {
        int  mid  = Optional.ofNullable(a.params(":mid")).map(Integer::parseInt).orElse(0);
        Meta meta = new Meta().setMid(mid);
        meta = metaService.getMeta(meta).stream().findFirst().orElse(meta);
        return R.s().setData(meta);
    };
    //修改/添加Meta
    public static Route saveMeta = (a, b) -> {
        int    mid   = Optional.ofNullable(a.queryParams("mid")).map(Integer::parseInt).orElse(0);
        String flag  = a.queryParams("flag");
        String title = a.queryParams("title");
        String type  = a.queryParams("type");
        String desc  = a.queryParams("description");
        // String count = a.queryParams("count");
        Meta meta = new Meta().setMid(mid).setFlag(flag).setTitle(title).setType(type).setDescription(desc);
        metaService.saveMeta(meta);
        return R.s().setData(meta);
    };
    //删除Meta
    public static Route delMeta = (a, b) -> {
        int mid = Optional.ofNullable(a.params(":mid")).map(Integer::parseInt).orElse(0);
        metaService.delMeta(mid);
        return R.s().setData(mid);
    };
}