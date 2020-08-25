package z.blog.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import org.jooq.Record;
import org.jooq.SelectConditionStep;
import spark.utils.StringUtils;
import z.blog.kit.BlogKit;
import z.blog.kit.PageInfo;
import z.blog.mapping.tables.records.ArticleRecord;
import z.blog.model.dto.Type;
import z.blog.model.entity.Article;
import z.blog.model.param.ArticleParam;
import z.blog.model.param.MetaParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.jooq.impl.DSL.*;
import static z.blog.bootstrap.JooqConfig.dsl;
import static z.blog.mapping.tables.ARTICLE.T_ARTICLE;
import static z.blog.mapping.tables.RELATIONSHIP.T_RELATIONSHIP;
import static z.blog.model.dto.Type.*;

/**
 * 文章Service
 */
@Slf4j
public class ContentService {

    /**
     * 保存或修改文章
     *
     * @param param 要保存的内容
     */
    public void insArticle(Article param) {
        ArticleRecord article = dsl.newRecord(T_ARTICLE);

        article.setTitle(param.getTitle());
        article.setFlag(param.getFlag());
        article.setContent(param.getContent());
        article.setType(param.getType());
        article.setFormat(param.getFormat());
        article.setTag(param.getTag());
        article.setCategory(param.getCategory());
        article.setHistory(param.getHistory());
        article.setComment(param.getComment());
        article.setAllowComment(param.getAllowComment());
        article.setCreateTime(param.getCreateTime());
        article.setUpdateTime(param.getUpdateTime());
        article.setStatus(param.getStatus());
        article.setSort(param.getSort());
        article.setAid(param.getAid());

        if (param.getAid() != null && param.getAid() > 0) {
            log.info("-> 修改文章");
            article.update();
        } else {
            log.info("-> 添加文章");
            article.insert();
        }
    }

    /**
     * 删除文章
     *
     * @param param 参数
     */
    public void delArticle(Article param) {
        log.info("-> 删除文章");
        dsl.deleteFrom(T_ARTICLE).where(T_ARTICLE.AID.eq(param.getAid())).execute();
    }

    /**
     * 获取文章
     */
    public Article getArticle(String id) {
        log.info("-> 获取文章");
        Condition condition;
        if (BlogKit.isArticleId(id)) {
            condition = T_ARTICLE.AID.eq(Integer.valueOf(id));
        } else {
            condition = T_ARTICLE.FLAG.eq(id);
        }
        return dsl.select().from(T_ARTICLE).where(condition).fetchOneInto(Article.class);
    }

    /**
     * 分页获取文件列表
     *
     * @param param 参数
     * @return 分页结果
     */
    public PageInfo<Article> getArticle(ArticleParam param) {
        //参数处理
        param = Optional.ofNullable(param).orElse(new ArticleParam());
        int pageNum = Optional.of(param.getPageNum()).filter(i -> (i > 0 && i < 999)).orElse(1);
        int pageSize = Optional.of(param.getPageSize()).filter(i -> (i > 0 && i < 9999)).orElse(20);
        //查询条件
        List<Condition> where = new ArrayList<>();
        //文章标题
        if (StringUtils.isNotEmpty(param.getTitle())) {
            where.add(T_ARTICLE.TITLE.like("%" + trim(param.getTitle()) + "%"));
        }
        //文章类型(post|page)
        if (StringUtils.isNotEmpty(param.getType())) {
            where.add(T_ARTICLE.TYPE.eq(trim(param.getType())));
        }
        //文章内容类型
        if (StringUtils.isNotEmpty(param.getFormat())) {
            where.add(T_ARTICLE.FORMAT.eq(trim(param.getFormat())));
        }
        //文章状态
        if (StringUtils.isNotEmpty(param.getStatus())) {
            where.add(T_ARTICLE.STATUS.eq(trim(param.getStatus())));
        }
        //查询SQL
        SelectConditionStep<Record> query = dsl.select().from(T_ARTICLE).where(where);
        //分页数据
        List<Article> list = query.orderBy(T_ARTICLE.SORT.desc(), T_ARTICLE.CREATE_TIME.desc()).limit((pageNum - 1) * pageSize, pageSize).fetchInto(Article.class);
        //统计总数
        Integer total = dsl.selectCount().from(query).fetchOneInto(Integer.class);
        //分页对象
        PageInfo<Article> pageInfo = new PageInfo<>(list, total, pageNum, pageSize);
        log.info("-> {}", pageInfo.toString());
        return pageInfo;
    }

    /**
     * 查询分类/标签下的文章分页
     *
     * @param param 参数
     * @return 分页对象
     */
    public PageInfo<Article> getArticle(MetaParam param) {
        log.info("-> 查询分类/标签下的文章分页");
        //参数处理
        param = Optional.ofNullable(param).orElse(new MetaParam());
        int pageNum = Optional.ofNullable(param.getPageNum()).filter(i -> (i > 0 && i < 999)).orElse(1);
        int pageSize = Optional.ofNullable(param.getPageSize()).filter(i -> (i > 0 && i < 9999)).orElse(20);
        //查询SQL

        SelectConditionStep<Record> query = dsl.select().from(T_RELATIONSHIP)
                .leftJoin(T_ARTICLE).on(T_RELATIONSHIP.AID.eq(T_ARTICLE.AID))
                .where(T_RELATIONSHIP.MID.eq(param.getMid()))
                .and(T_ARTICLE.STATUS.eq(Type.PUBLISH));
        //统计总数
        Integer total = selectCount().from(query).fetchOneInto(Integer.class);
        //分页数据
        List<Article> list = query.limit((pageNum - 1) * pageSize, pageSize).fetchInto(Article.class);
        //分页对象
        PageInfo<Article> pageInfo = new PageInfo<>(list, total, pageNum, pageSize);
        log.info("-> {}", pageInfo.toString());
        return pageInfo;
    }

    /**
     * 获取相邻的文章
     *
     * @param param 参数
     * @param type  上一篇: prev | 下一篇: next
     * @return 文章
     */
    public Article getArticle(Article param, String type) {
        log.info("-> 获取相邻的文章");
        Condition condition;
        if (PREV.equalsIgnoreCase(type)) {
            log.info("-> 上一篇文章");
            condition = T_ARTICLE.CREATE_TIME.gt(param.getCreateTime());
        } else if (NEXT.equalsIgnoreCase(type)) {
            log.info("-> 下一篇文章");
            condition = T_ARTICLE.CREATE_TIME.lt(param.getCreateTime());
        } else {
            return null;
        }
        //
        condition.and(T_ARTICLE.TYPE.eq(POST)).and(T_ARTICLE.STATUS.eq(Type.PUBLISH));
        //查询
        return dsl.select().from(T_ARTICLE)
                .where(
                        T_ARTICLE.AID.eq(
                                dsl.select(max(T_ARTICLE.AID)).from(T_ARTICLE).where(condition)
                        )
                ).fetchOneInto(Article.class);
    }

    /**
     * 获取文章归档分页
     *
     * @return 文章归档列表
     */
    /*public PageInfo<Archive> getArchive(int pageNum, int pageSize) {
        log.info("-> 获取文章归档分页[pageNum: {} ,pageSize: {}]", pageNum, pageSize);
        //数据SQL
        SelectSeekStep1<Record5<Integer, String, String, String, Integer>, Integer> data =
                getDSLContext().select(T_ARTICLE.AID, T_ARTICLE.TITLE, T_ARTICLE.SLUG, T_ARTICLE.TYPE, T_ARTICLE.CREATED)
                        .from(T_ARTICLE).where(T_ARTICLE.TYPE.eq(POST)).and(T_ARTICLE.STATUS.eq(PUBLISH))
                        .orderBy(T_ARTICLE.CREATED.desc());
        //获取总数
        Integer total = getDSLContext().select(count()).from(data).fetchOne(count());
        //构建分页参数
        data.limit((pageNum - 1) * pageSize, pageSize);
        //查询分页数据
        List<Archive> list = getDSLContext().select(
                DSL.field("StrFTime('%Y-%m', datetime(created, 'unixepoch'))").as("title"),
                count().as("count")
        ).from(data).groupBy(DSL.field("title")).orderBy(1).fetchInto(Archive.class)
                .stream().map(this::parseArchive).collect(Collectors.toList());
        //分页数据
        PageInfo<Archive> pageInfo = new PageInfo<>(list, total, pageNum, pageSize);
        log.info("-> {}", pageInfo.toString());
        return pageInfo;
    }

    private Archive parseArchive(Archive archive) {
        String dateTitle = archive.getTitle();

        YearMonth startM = YearMonth.parse(dateTitle);
        LocalDate startDate = LocalDate.of(startM.getYear(), startM.getMonth(), 1);
        LocalDate endDate = startDate.with(TemporalAdjusters.lastDayOfMonth());
        LocalDateTime startLDT = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), 0, 0, 0);
        LocalDateTime endLDT = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), 23, 59, 59);

        List<Article> list = getDSLContext().selectFrom(T_ARTICLE)
                .where(T_ARTICLE.TYPE.eq(POST))
                .and(T_ARTICLE.STATUS.eq(PUBLISH))
                .and(T_ARTICLE.CREATED.ge((int) startLDT.toEpochSecond(ZoneOffset.of("+8"))))
                .and(T_ARTICLE.CREATED.le((int) endLDT.toEpochSecond(ZoneOffset.of("+8"))))
                .fetchInto(Article.class);
        archive.setList(list);
        return archive;
    }*/

    /*private Contents mapContent(Content content) {
        Contents temp = new Contents();
        if (StringKit.isNotEmpty(content.getSlug())) {
            String url = "/" + content.getSlug();
            temp.setUrl(url.replaceAll("[/]+", "/"));
        } else {
            temp.setUrl("/article/" + content.getCid());
        }
        String text = content.getContent();
        if (StringKit.isNotEmpty(text)) {
            text = text.replaceAll("\\\\\"", "\\\"");
            temp.setContent(text);
        }
        return temp;
    }*/
}
