package z.blog.extension;

import jetbrick.template.JetAnnotations;
import jetbrick.template.runtime.InterpretContext;
import jetbrick.template.runtime.ValueStack;
import lombok.extern.slf4j.Slf4j;
import spark.utils.StringUtils;
import z.blog.kit.MdUtil;
import z.blog.kit.PageInfo;
import z.blog.kit.StrKit;
import z.blog.model.dto.Comments;
import z.blog.model.dto.Statistic;
import z.blog.model.dto.Type;
import z.blog.model.entity.Article;
import z.blog.model.entity.Meta;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static z.blog.Application.*;
import static z.blog.bootstrap.Constant.URL_PREFIX_ARTICLE;
import static z.blog.model.dto.Type.POST;
import static z.blog.model.dto.Type.PUBLISH;

/**
 * 主题类函数
 *
 * @author zaoangod
 */
@Slf4j
@JetAnnotations.Functions
public final class Theme {

    /**
     * 获取当前上下文的文章对象
     */
    private static Article article() {
        InterpretContext ctx = InterpretContext.current();
        Object value = ctx.getValueStack().getValue("article");
        if (null != value) {
            return (Article) value;
        }
        return null;
    }

    /**
     * 获取当前文章的上一篇
     *
     * @return 当前文章的上一篇
     */
    public static Article prev() {
        Article content = article();
        if (content == null) {
            return null;
        }
        return prev(content);
    }

    /**
     * 获取当前文章的上一篇
     *
     * @param article 当前文章对象
     * @return 当前文章的上一篇
     */
    public static Article prev(Article article) {
        return contentService.getArticle(article, Type.PREV);
    }

    /**
     * 获取当前文章的下一篇
     *
     * @return 当前文章的下一篇
     */
    public static Article next() {
        Article article = article();
        if (article == null) {
            return null;
        }
        return next(article);
    }

    /**
     * 获取当前文章的下一篇
     *
     * @param article 当前文章对象
     * @return 当前文章的下一篇
     */
    public static Article next(Article article) {
        return contentService.getArticle(article, Type.NEXT);
    }

    /**
     * 获取文章分页
     */
    public static PageInfo<Article> articles() {
        ValueStack vs = InterpretContext.current().getValueStack();
        //分页相关参数
        int pageNum = Optional.ofNullable(vs.getValue("pageNum")).map(String::valueOf).map(Integer::valueOf).orElse(1);
        //int pageSize = Optional.ofNullable(vs.getValue("pageSize")).map(String::valueOf).map(Integer::valueOf).orElse(10);
        int pageSize = Optional.ofNullable(vs.getValue("pageSize")).map(String::valueOf).map(Integer::valueOf).orElse(2);
        //构建查询参数
        Article param = new Article().setType(POST).setStatus(PUBLISH);
        //分页查询
        PageInfo<Article> pageInfo = contentService.getArticle(param, pageNum, pageSize);
        //设置参数
        vs.setLocal("title", "首页 - 第" + pageNum + "页");
        vs.setLocal("pageNum", pageNum);
        vs.setLocal("pageSize", pageSize);
        return pageInfo;
    }

    /**
     * 获取文章摘要
     * <p>只对MD格式的文章有效, HTML返回原文</p>
     *
     * @param value   文章内容
     * @param fmtType 内容类型(markdown/html)
     * @return 当前文章摘要
     */
    public static String excerpt(String value, String fmtType) {
        if (StringUtils.isBlank(value) || StringUtils.isBlank(fmtType)) {
            return "";
        }
        if (Type.MD.equalsIgnoreCase(fmtType)) {
            int pos = value.indexOf("<!--more-->");
            if (pos != -1) {
                value = value.substring(0, pos);
            }
            return MdUtil.md2Html(value);
        } else if (Type.HTML.equalsIgnoreCase(fmtType)) {
            return value;
        }
        return "";
    }

    /**
     * 获取当前文章内容
     *
     * @param value   文章内容
     * @param fmtType 文章内容类型(markdown/html)
     * @return 文章内容(HTML)
     */
    public static String content(String value, String fmtType) {
        String content = "";
        if (StringUtils.isBlank(value) || StringUtils.isBlank(fmtType)) {
            return "";
        }
        if (Type.MD.equalsIgnoreCase(fmtType)) {
            value = value.replace("<!--more-->", "\r\n");
            content = MdUtil.md2Html(value);
        } else if (Type.HTML.equalsIgnoreCase(fmtType)) {
            content = value;
        }
        return content;
    }

    /**
     * 获取当前上下文文章的标签
     *
     * @return 当前文章的标签
     */
    public static List<String> tags() {
        Article a = article();
        return tags(a);
    }

    /**
     * 获取文章的标签
     *
     * @param article 文章对象
     * @return 当前文章的标签列表
     */
    public static List<String> tags(Article article) {
        if (article == null || article.getTag() == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(article.getTag().split(","));
    }

    /**
     * 获取当前文章/页面的评论
     *
     * @return 评论分页
     */
    public static PageInfo<Comments> comments() {
        //当前文章对象
        Article content = article();
        if (null == content) {
            return new PageInfo<>();
        }
        PageInfo<Comments> page = comments(content.getAid());
        log.info("{}", page.getList());
        return page;
    }

    /**
     * 获取当前文章/页面的评论
     *
     * @param aid 文章ID
     * @return 评论分页
     */
    public static PageInfo<Comments> comments(Integer aid) {
        Object cp = InterpretContext.current().getValueStack().getValue("CommentPage");
        int pageNum = 1;
        if (null != cp) {
            pageNum = Integer.parseInt(cp.toString());
        }
        return commentService.getComment(aid, pageNum, 20);
    }

    /**
     * 获取文章/页面的评论数量
     *
     * @param content 文章
     * @return 评论数量
     */
    public static Integer commentCount(Article content) {
        if (null == content) {
            return 0;
        }
        return commentService.getCommentCount(content.getAid());
    }

    /**
     * 获取当前文章/页面的评论数量
     *
     * @return 评论数量
     */
    public static Integer commentCount() {
        //当前文章对象
        Article content = article();
        return commentCount(content);
    }

    /**
     * 网站统计
     *
     * @return 统计结果
     */
    public static Statistic statistic() {
        return siteService.getStatistic();
    }

    /**
     * 获取分类/标签列表
     *
     * @return 分类/标签列表
     */
    public static List<Meta> meta(String type) {
        if (type != null && type.length() > 0) {
            type = type.toLowerCase();
            Meta meta = new Meta().setType(type);
            return metaService.getMeta(meta);
        } else {
            return Collections.emptyList();
        }
    }

    /**
     * 获取根据分类/标签查询的文章列表
     *
     * @return 根据分类/标签查询的文章列表
     */
    public static PageInfo<Article> meta(Integer mid) {
        mid = Optional.ofNullable(mid).orElse(1);
        ValueStack vs = InterpretContext.current().getValueStack();
        Integer pageNum = Optional.ofNullable((Integer) vs.getValue("pageNum")).orElse(1);
        return contentService.getArticle(mid, pageNum, 20);
    }

    /**
     * 获取根据分类/标签查询的文章列表
     *
     * @return 根据分类/标签查询的文章列表
     */
    public static PageInfo<Article> archive() {
        ValueStack vs = InterpretContext.current().getValueStack();
        Integer pageNum = Optional.ofNullable((Integer) vs.getValue("pageNum")).orElse(1);
        return contentService.getArchive(pageNum, 20);
    }
}