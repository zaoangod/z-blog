package z.blog.extension;

import jetbrick.template.JetAnnotations;
import jetbrick.template.runtime.InterpretContext;
import jetbrick.template.runtime.ValueStack;
import lombok.extern.slf4j.Slf4j;
import spark.utils.StringUtils;
import z.blog.kit.MdUtil;
import z.blog.kit.PageInfo;
import z.blog.kit.StrKit;
import z.blog.model.dto.Type;
import z.blog.model.entity.Article;
import z.blog.model.param.ArticleParam;

import java.util.Optional;

import static z.blog.Application.CACHE;
import static z.blog.Application.contentService;
import static z.blog.bootstrap.Constant.OPT_PAGE_LIMIT;
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
public final class Content {

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
     * 当前文章的链接
     *
     * @return 文章链接
     */
    public static String permalink() {
        Article article = article();
        return Optional.ofNullable(article).map(Content::permalink).orElse("");
    }

    /**
     * 文章的链接
     *
     * @param article 文章对象
     * @return 文章链接
     */
    public static String permalink(Article article) {
        return permalink(article.getAid(), article.getFlag());
    }

    /**
     * 文章链接
     *
     * @param cid  文章ID
     * @param slug 文章标签
     * @return 文章链接
     */
    public static String permalink(Integer cid, String slug) {
        return "/" + URL_PREFIX_ARTICLE + "/" + (StrKit.nBlank(slug) ? slug : cid);
    }

    /**
     * 获取文章分页
     */
    public static PageInfo<Article> articles() {
        ValueStack vs = InterpretContext.current().getValueStack();
        log.info("{}", vs.getValue("pageNum"));
        log.info("{}", vs.getValue("pageSize"));
        //分页相关参数
        int pageNum = Optional.ofNullable(vs.getValue("pageNum")).map(String::valueOf).map(Integer::valueOf).orElse(1);
        int pageSize = Optional.ofNullable(vs.getValue("pageSize")).map(String::valueOf).map(Integer::valueOf).orElse((Integer) CACHE.get(OPT_PAGE_LIMIT));
        //构建查询参数
        ArticleParam param = new ArticleParam();
        param.setType(POST);
        param.setStatus(PUBLISH);
        param.setPageNum(pageNum);
        param.setPageSize(pageSize);
        //分页查询
        PageInfo<Article> pageInfo = contentService.getArticle(param);
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
     * 分类/标签的文章分页
     *
     * @return 分类/标签的文章分页
     */
    /*public static PageInfo<Article> articles(Integer mid, Integer limit) {
        ValueStack v = InterpretContext.current().getValueStack();
        //分页相关参数
        Integer pageNum = Optional.ofNullable((Integer) v.getValue("pageNum")).orElse(1);
        Integer pageSize = Optional.ofNullable(limit).orElse((Integer) ENV.get(OPT_PAGE_LIMIT));
        //分页查询
        PageInfo<Article> pageInfo = contentService.getArticle(mid, pageNum, pageSize);
        v.setLocal("pageNum", pageNum);
        return pageInfo;
    }*/

    /**
     * 获取当前文章/页面的评论
     *
     * @return 评论分页
     */
    /*public static PageInfo<Comments> comments() {
        //当前文章对象
        Article content = article();
        if (null == content) {
            return new PageInfo<>();
        }
        return comments(content.getAid(), (Integer) ENV.get(OPT_PAGE_LIMIT));
    }*/

    /**
     * 获取当前文章/页面的评论
     *
     * @param aid      文章ID
     * @param pageSize 数量
     * @return 评论分页
     */
    /*public static PageInfo<Comments> comments(Integer aid, Integer pageSize) {
        Object cPage = InterpretContext.current().getValueStack().getValue("cp");
        int pageNum = 1;
        if (null != cPage) {
            pageNum = (int) cPage;
        }
        return commentService.getComment(aid, pageNum, pageSize);
    }*/

    /**
     * 获取当前文章/页面的评论数量
     *
     * @return 评论数量
     */
    /*public static Integer commentCount() {
        //当前文章对象
        Article content = article();
        if (null == content) {
            return 0;
        }
        return commentCount(content);
    }*/

    /**
     * 获取文章/页面的评论数量
     *
     * @param content 文章
     * @return 评论数量
     */
    /*public static Integer commentCount(Article content) {
        return commentService.getCommentCount(content.getAid());
    }*/

    /**
     * 获取当前上下文文章的标签
     *
     * @return 当前文章的标签
     */
    /*public static List<String> tags() {
        Article article = article();
        if (null == article || StrUtil.isBlank(article.getTag())) {
            return Collections.emptyList();
        }
        return tags(article);
    }*/

    /**
     * 获取文章的标签
     *
     * @param article 文章对象
     * @return 当前文章的标签列表
     */
    /*public static List<String> tags(Article article) {
        if (null == article || StrUtil.isBlank(article.getTag())) {
            return Collections.emptyList();
        }
        return Arrays.asList(article.getTag().split(StrUtil.COMMA));
    }*/
}