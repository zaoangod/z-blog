package z.blog.controller;

import lombok.extern.slf4j.Slf4j;
import spark.Request;
import spark.Response;
import spark.Route;
import z.blog.model.dto.Type;
import z.blog.model.entity.Article;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static z.blog.Application.contentService;

/**
 * @author zaoangod
 */
@Slf4j
public class Content extends Base {

    /**
     * 文章页
     */
    /*public String post(Request request, @PathParam String cid) {
        Contents contents = contentsService.getContents(cid);
        if (null == contents) {
            return this.render_404();
        }
        if (Types.DRAFT.equals(contents.getStatus())) {
            return this.render_404();
        }
        request.attribute("article", contents);
        request.attribute("is_post", true);
        if (contents.getAllowComment()) {
            int cp = request.queryInt("cp", 1);
            request.attribute("cp", cp);
        }
        Contents temp = new Contents();
        temp.setHits(contents.getHits() + 1);
        temp.updateById(contents.getCid());
        return this.render("post");
    }*/

    /**
     * 文章页面/自定义页面
     */
    public static Route post = (Request a, Response b) -> {
        Article article = contentService.getArticle(a.params(":aid"));
        if (null == article) {
            //b.redirect("/404");
            return t("404");
        }
        //若果状态是草稿
        if (Type.DRAFT.equals(article.getStatus())) {
            return t("404");
        }
        Map<String, Object> data = new HashMap<>();
        //处理评论页
        if (article.getAllowComment() == 1) {
            int cp = Optional.ofNullable(a.queryParams("cp")).map(Integer::parseInt).orElse(1);
            data.put("cp", cp);
        }
        data.put("article", article);
        data.put("isArticle", true);
        return t(data, "article");
    };
}
