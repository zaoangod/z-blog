package z.blog.controller;

import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;
import spark.Route;
import z.blog.kit.PageInfo;
import z.blog.model.dto.Type;
import z.blog.model.entity.Article;
import z.blog.model.entity.Meta;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static z.blog.bootstrap.Constant.OPT_PAGE_LIMIT;
import static z.blog.bootstrap.Constant.OPT_SITE_TITLE;

/**
 * @author zaoangod
 */
@Slf4j
public class Home extends Base {

    /**
     * 首页
     */
    public static Route index = (Request a, Response b) -> {
        //当前页码
        Integer pageNum = Optional.ofNullable(a.params(":pageNum")).map(Integer::valueOf).orElse(1);
        Map<String, Object> data = new HashMap<>();
        data.put("title", "首页 - 第" + pageNum + "页");
        data.put("pageNum", pageNum);
        data.put("isIndex", true);
        data.put("urlPrefix", "/index");
        return t(data, "index");
    };

    /**
     * 归档
     */
    /*public static Route archive = (Request a, Response b) -> {
        //当前页码
        Integer pageNum = Optional.ofNullable(a.params(":pageNum")).map(Integer::valueOf).orElse(1);
        Map<String, Object> data = new HashMap<>();
        data.put("title", "归档 - 第" + pageNum + "页");
        data.put("pageNum", pageNum);
        data.put("isArchive", true);
        data.put("urlPrefix", "/archive");
        return t(data, "archive");
    };*/

    /**
     * 分类列表页
     */
    /*public static Route category = (Request a, Response b) -> {
        Meta meta = new Meta().setType(Type.CATEGORY);
        List<Meta> list = metaService.getMetaList(meta);
        Map<String, Object> data = new HashMap<>();
        data.put("title", "分类 - " + ENV.get(OPT_SITE_TITLE));
        data.put("categories", list);
        data.put("isCategory", true);
        return theme(data, "category");
    };*/

    /**
     * 分类文章页
     */
    /*public static Route categoryInfo = (Request a, Response b) -> {
        //分页相关参数
        Integer mid = Optional.ofNullable(a.params(":mid")).map(Integer::valueOf).orElse(0);
        Integer pageNum = Optional.ofNullable(a.params(":pageNum")).map(Integer::valueOf).orElse(1);
        Integer pageSize = Optional.ofNullable((String) ENV.get(OPT_PAGE_LIMIT)).map(Integer::valueOf).orElse(20);
        //
        Meta meta = new Meta().setMid(mid).setType(Type.CATEGORY);
        meta = metaService.getMetaList(meta).stream().findFirst().orElse(meta);
        //文章分页
        PageInfo<Article> pageInfo = contentService.getArticle(mid, pageNum, pageSize);
        //
        Map<String, Object> data = new HashMap<>();
        data.put("title", "分类 - " + (mid == 0 ? ENV.get(OPT_SITE_TITLE) : meta.getName()));
        data.put("category", meta);
        data.put("pageInfo", pageInfo);
        data.put("isCategory", true);
        data.put("urlPrefix", "/category");
        return theme(data, "category");
    };*/

    /**
     * 标签列表页
     */
    /*public static Route tag = (Request a, Response b) -> {
        Meta meta = new Meta().setType(Type.TAG);
        List<Meta> list = metaService.getMetaList(meta);
        Map<String, Object> data = new HashMap<>();
        data.put("title", "标签 - " + ENV.get(OPT_SITE_TITLE));
        data.put("tags", list);
        data.put("isTag", true);
        return theme(data, "tag");
    };*/

    /**
     * 标签文章页
     */
    /*public static Route tagInfo = (Request a, Response b) -> {
        //分页相关参数
        Integer mid = Optional.ofNullable(a.params(":mid")).map(Integer::valueOf).orElse(0);
        Integer pageNum = Optional.ofNullable(a.params(":pageNum")).map(Integer::valueOf).orElse(1);
        Integer pageSize = Optional.ofNullable((String) ENV.get(OPT_PAGE_LIMIT)).map(Integer::valueOf).orElse(20);
        //
        Meta meta = new Meta().setMid(mid).setType(Type.TAG);
        meta = metaService.getMetaList(meta).stream().findFirst().orElse(meta);
        //文章分页
        PageInfo<Article> pageInfo = contentService.getArticle(mid, pageNum, pageSize);
        //
        Map<String, Object> data = new HashMap<>();
        data.put("title", "标签 - " + (mid == 0 ? ENV.get(OPT_SITE_TITLE) : meta.getName()));
        data.put("tag", meta);
        data.put("pageInfo", pageInfo);
        data.put("isTag", true);
        data.put("urlPrefix", "/tag");
        return theme(data, "tag");
    };*/
}