package z.blog.route;

import lombok.extern.slf4j.Slf4j;
import spark.Route;
import z.blog.model.entity.Article;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static z.blog.Application.contentService;
import static z.blog.model.dto.Type.*;

/**
 * @author zaoangod
 */
@Slf4j
public class Content extends Base {
    /**
     * 文章页面/内容页面
     */
    public static Route content = (a, b) -> {
        Article article = contentService.getArticle(a.params(":aid"));
        if (null == article || DRAFT.equals(article.getStatus())) {
            return t("404");
        }
        Map<String, Object> data = new HashMap<>();
        //处理评论页
        if (article.getAllowComment() == 1) {
            int cp = Optional.ofNullable(a.queryParams("cp")).map(Integer::parseInt).orElse(1);
            data.put("cp", cp);
        }
        data.put("article", article);
        //类型是页面
        if (PAGE.equals(article.getType())) {
            data.put("isPage", true);
            data.put("url", "/page");
            return t(data, "page");
        } else if (POST.equals(article.getType())) {
            data.put("isArticle", true);
            data.put("url", "/article");
            return t(data, "article");
        } else {
            return t("404");
        }
    };
    /**
     * 定义页面
     */
    /*public static Route page = (a, b) -> {
        String pageName = a.params(":page");
        boolean n = BlogKit.isNumber(pageName);
        Map<String, Object> data = new HashMap<>();
        data.put("isPage", true);
        return t(data, pageName);
    };*/
}