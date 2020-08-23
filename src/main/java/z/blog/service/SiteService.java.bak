package z.blog.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.SelectJoinStep;
import z.blog.kit.PageInfo;
import z.blog.kit.StrKit;
import z.blog.model.dto.Statistic;
import z.blog.model.entity.Attach;
import z.blog.model.entity.Option;
import z.blog.model.entity.User;

import java.util.List;
import java.util.Optional;

import static org.jooq.tools.StringUtils.isBlank;
import static z.blog.Application.CACHE;
import static z.blog.bootstrap.JooqConfig.dslContext;
import static z.blog.mapping.tables.ARTICLE.T_ARTICLE;
import static z.blog.mapping.tables.ATTACH.T_ATTACH;
import static z.blog.mapping.tables.COMMENT.T_COMMENT;
import static z.blog.mapping.tables.META.T_META;
import static z.blog.mapping.tables.OPTION.T_OPTION;
import static z.blog.mapping.tables.USER.T_USER;
import static z.blog.model.dto.Type.*;

/**
 * @author zaoangod
 */
@Slf4j
public class SiteService {

    /**
     * 初始化用户
     *
     * @param user 用户
     */
    public void initSiteUser(User user) {
        dslContext().insertInto(T_USER)
                .set(T_USER.USERNAME, user.getUsername())
                .set(T_USER.PASSWORD, "123")
                .execute();
    }

    /**
     * 获取系统设置列表
     */
    public List<Option> getOption(Option option) {
        log.info("-> 查询选项");
        option = Optional.ofNullable(option).orElse(new Option());
        SelectJoinStep<Record> select = dslContext().select().from(T_OPTION);
        if (StrKit.nBlank(option.getName())) {
            select.where(T_OPTION.NAME.eq(option.getName()));
        }
        if (StrKit.nBlank(option.getValue())) {
            select.where(T_OPTION.VALUE.eq(option.getValue()));
        }
        select.orderBy(T_OPTION.NAME);
        return select.fetch().into(Option.class);
    }

    /**
     * 保存选项
     */
    public void insOption(Option option) {
        log.info("-> 保存选项");
        List<Option> list = getOption(new Option().setName(option.getName()));
        if (list.size() == 0) {
            dslContext().insertInto(T_OPTION)
                    .set(T_OPTION.NAME, option.getName())
                    .set(T_OPTION.VALUE, option.getValue())
                    .execute();
        }
    }

    /**
     * 修改选项
     */
    public void updOption(Option option) {
        log.info("-> 修改选项");
        dslContext().update(T_OPTION)
                .set(T_OPTION.VALUE, option.getValue())
                .where(T_OPTION.NAME.eq(option.getName()))
                .execute();
    }

    /**
     * 删除选项
     */
    public void delOption(Option option) {
        log.info("-> 删除选项");
        dslContext().delete(T_OPTION).where(T_OPTION.NAME.eq(option.getName())).execute();
    }

    /**
     * 获取博客统计
     *
     * @return 博客统计
     */
    public Statistic getStatistic() {
        Statistic statistic = new Statistic();

        //发布的文章统计
        Integer post = (Integer) CACHE.get("KEY_SYS_STATISTIC_POST");
        if (null == post) {
            post = dslContext().selectCount().from(T_ARTICLE)
                    .where(T_ARTICLE.TYPE.eq(POST))
                    .and(T_ARTICLE.STATUS.eq(PUBLISH))
                    .fetchOne().into(Integer.class);
            CACHE.put("KEY_SYS_STATISTIC_POST", post, 3600);
        }

        //发布的页面统计
        Integer page = (Integer) CACHE.get("KEY_SYS_STATISTIC_PAGE");
        if (null == page) {
            page = dslContext().selectCount().from(T_ARTICLE)
                    .where(T_ARTICLE.TYPE.eq(PAGE))
                    .and(T_ARTICLE.STATUS.eq(PUBLISH))
                    .fetchOne().into(Integer.class);
            CACHE.put("KEY_SYS_STATISTIC_PAGE", page, 3600);
        }

        //评论数量统计
        Integer comment = (Integer) CACHE.get("KEY_SYS_STATISTIC_COMMENT");
        if (null == comment) {
            comment = dslContext().selectCount().from(T_COMMENT)
                    .fetchOne().into(Integer.class);
            CACHE.put("KEY_SYS_STATISTIC_COMMENT", comment, 3600);
        }

        //附件数量统计
        Integer attach = (Integer) CACHE.get("KEY_SYS_STATISTIC_ATTACH");
        if (null == attach) {
            attach = dslContext().selectCount().from(T_ATTACH)
                    .fetchOne().into(Integer.class);
            CACHE.put("KEY_SYS_STATISTIC_ATTACH", attach, 3600);
        }

        //标签数量统计
        Integer tag = (Integer) CACHE.get("KEY_SYS_STATISTIC_TAG");
        if (null == tag) {
            tag = dslContext().selectCount().from(T_META)
                    .where(T_META.TYPE.eq(TAG))
                    .fetchOne().into(Integer.class);
            CACHE.put("KEY_SYS_STATISTIC_TAG", tag, 3600);
        }

        //分类数量统计
        Integer category = (Integer) CACHE.get("KEY_SYS_STATISTIC_CATEGORY");
        if (null == category) {
            category = dslContext().selectCount().from(T_META)
                    .where(T_META.TYPE.eq(CATEGORY))
                    .fetchOne().into(Integer.class);
            CACHE.put("KEY_SYS_STATISTIC_CATEGORY", category, 3600);
        }

        statistic = new Statistic()
                .setAttach(attach)
                .setCategory(category)
                .setComment(comment)
                .setPost(post)
                .setPage(page)
                .setTag(tag);
        //保存到缓存里
        return statistic;
    }

    /**
     * 获取附件分页
     *
     * @param param 查询参数
     * @return 分页对象
     */
    public PageInfo<Attach> getAttach(Attach param, Integer pageNum, Integer pageSize) {
        //参数
        pageNum = Optional.ofNullable(pageNum).filter(i -> (i > 0 && i < 999)).orElse(1);
        pageSize = Optional.ofNullable(pageSize).filter(i -> i > 0 && i < 9999).orElse(20);
        log.info("-> 获取附件分页[pageNum: {} ,pageSize: {}]", pageNum, pageSize);
        //
        SelectJoinStep<Record1<Integer>> count = dslContext().selectCount().from(T_ATTACH);
        SelectJoinStep<Record> data = dslContext().select().from(T_ATTACH);
        //排序
        data.orderBy(T_ATTACH.CREATED);
        //查询条件
        if (param != null && !isBlank(param.getType())) {
            count.where(T_META.TYPE.eq(param.getType()));
            data.where(T_META.TYPE.eq(param.getType()));
        }
        if (param != null && !isBlank(param.getName())) {
            count.where(T_META.TYPE.like(param.getName()));
            data.where(T_META.TYPE.like(param.getName()));
        }
        //总数
        Integer total = count.fetchOne().into(Integer.class);
        //分页
        data.limit(Integer.valueOf((pageNum - 1) * pageSize), pageSize);
        //数据
        List<Attach> list = data.fetch().into(Attach.class);
        //分页数据
        PageInfo<Attach> pageInfo = new PageInfo<>(list, total, pageNum, pageSize);
        log.info("-> {}", pageInfo.toString());
        return pageInfo;
    }

    /**
     * 获取附件
     *
     * @param param 参数
     */
    public List<Attach> getAttach(Attach param) {
        log.info("-> 获取附件");
        SelectJoinStep<Record> query = dslContext().select().from(T_ATTACH);
        //查询条件
        if (param != null && !isBlank(param.getAid())) {
            query.where(T_META.TYPE.eq(param.getAid()));
        }
        if (param != null && !isBlank(param.getType())) {
            query.where(T_META.TYPE.eq(param.getType()));
        }
        if (param != null && !isBlank(param.getName())) {
            query.where(T_META.TYPE.like(param.getName()));
        }
        return query.fetch().into(Attach.class);
    }

    /**
     * 删除附件
     *
     * @param id id
     */
    public void delAttach(Integer id) {
        log.info("-> 删除附件");
        dslContext().deleteFrom(T_ATTACH).where(T_ATTACH.AID.eq(id)).execute();
    }

}