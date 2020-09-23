package z.blog.route;

import lombok.extern.slf4j.Slf4j;
import spark.Route;
import z.blog.model.entity.Meta;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static z.blog.Application.metaService;
import static z.blog.model.dto.Type.CATEGORY;
import static z.blog.model.dto.Type.TAG;

/**
 * @author zaoangod
 */
@Slf4j
public class Home extends Base {

    /**
     * 首页
     */
    public static Route index = (a, b) -> {
        //当前页码
        Integer pageNum = Optional.ofNullable(a.params(":pageNum")).map(Integer::valueOf).orElse(1);
        Map<String, Object> data = new HashMap<>();
        data.put("title", "首页 - 第" + pageNum + "页");
        data.put("pageNum", pageNum);
        data.put("isIndex", true);
        data.put("url", "/index");
        return t(data, "index");
    };

    /**
     * 归档
     */
    public static Route archive = (a, b) -> {
        //当前页码
        Integer pageNum = Optional.ofNullable(a.params(":pageNum")).map(Integer::valueOf).orElse(1);
        Map<String, Object> data = new HashMap<>();
        data.put("title", "归档 - 第" + pageNum + "页");
        data.put("pageNum", pageNum);
        data.put("isArchive", true);
        data.put("url", "/archive");
        log.info("-> url: {}", data.get("url"));
        return t(data, "archive");
    };

    /**
     * 分类列表页
     */
    public static Route category = (a, b) -> {
        Map<String, Object> data = new HashMap<>();
        data.put("title", "分类");
        data.put("isCategory", true);
        data.put("url", "/category");
        return t(data, "category");
    };

    /**
     * 标签列表页
     */
    public static Route tag = (a, b) -> {
        Map<String, Object> data = new HashMap<>();
        data.put("title", "标签");
        data.put("isTag", true);
        data.put("url", "/tag");
        return t(data, "tag");
    };

    /**
     * 分类/标签的文章页
     */
    public static Route metaInfo = (a, b) -> {
        Map<String, Object> data = new HashMap<>();
        //分页相关参数
        Integer pageNum = Optional.ofNullable(a.params(":pageNum")).map(Integer::valueOf).orElse(1);
        Integer mid = Optional.ofNullable(a.params(":mid")).map(Integer::valueOf).orElse(0);
        Meta meta = new Meta().setMid(mid);
        meta = metaService.getMeta(meta).stream().findFirst().orElse(meta);
        String t = meta.getType();
        if (TAG.equals(t)) {
            data.put("title", "标签 - " + (meta.getTitle() == null ? "" : meta.getTitle()));
            data.put("isTag", true);
            data.put("tag", meta);
            data.put("pageNum", pageNum);
            data.put("url", "/tag");
            return t(data, "tag");
        } else if (CATEGORY.equals(t)) {
            data.put("title", "分类 - " + (meta.getTitle() == null ? "" : meta.getTitle()));
            data.put("isCategory", true);
            data.put("category", meta);
            data.put("pageNum", pageNum);
            data.put("url", "/category");
            return t(data, "category");
        } else {
            return t(data, "404");
        }
    };
}