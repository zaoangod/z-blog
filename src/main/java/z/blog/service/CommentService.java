package z.blog.service;

import lombok.extern.slf4j.Slf4j;
import org.jooq.Condition;
import z.blog.kit.PageInfo;
import z.blog.model.dto.Comments;
import z.blog.model.entity.Comment;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static z.blog.Application.CACHE;
import static z.blog.bootstrap.Constant.SITE_COMMENT_AUDIT;
import static z.blog.bootstrap.JooqConfig.dsl;
import static z.blog.mapping.tables.COMMENT.T_COMMENT;
import static z.blog.model.dto.Type.*;

/**
 * 评论Service
 *
 * @author zaoangod
 */
@Slf4j
public class CommentService {

    /**
     * 添加评论
     *
     * @param param 评论参数
     */
    public void insComment(Comment param) {
        try {
            //评论是否需要审核后才显示
            boolean b = Boolean.parseBoolean(CACHE.get(SITE_COMMENT_AUDIT).toString());
            dsl.insertInto(T_COMMENT)
                    .set(T_COMMENT.AID, param.getAid())
                    .set(T_COMMENT.CREATE_TIME, 9527000)
                    .set(T_COMMENT.AUTHOR, param.getAuthor())
                    .set(T_COMMENT.MAIL, param.getMail())
                    .set(T_COMMENT.URL, param.getUrl())
                    .set(T_COMMENT.IP, param.getIp())
                    .set(T_COMMENT.IP, param.getIp())
                    .set(T_COMMENT.AGENT, param.getAgent())
                    .set(T_COMMENT.CONTENT, param.getContent())
                    .set(T_COMMENT.TYPE, param.getType())
                    .set(T_COMMENT.STATUS, b ? COMMENT_NO_AUDIT : COMMENT_APPROVED)
                    .set(T_COMMENT.PARENT, param.getParent())
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取评论分页
     *
     * @param param 参数
     * @return 分页对象
     */
    public PageInfo<Comment> getComment(Comment param, int pageNum, int pageSize) {
        param = Optional.ofNullable(param).orElse(Comment.get());
        pageNum = Optional.of(pageNum).filter(i -> (i > 0 && i < 9999)).orElse(1);
        pageSize = Optional.of(pageSize).filter(i -> (i > 0 && i < 1000)).orElse(10);
        log.info("-> 获取评论分页[pageNum: {} ,pageSize: {}]", pageNum, pageSize);

        List<Condition> where = new ArrayList<>();
        if (param.getAid() != null) {
            where.add(T_COMMENT.AID.eq(param.getAid()));
        }
        if (param.getStatus() != null) {
            where.add(T_COMMENT.STATUS.eq(param.getStatus()));
        }
        if (param.getType() != null) {
            where.add(T_COMMENT.TYPE.eq(param.getType()));
        }
        if (param.getParent() != null) {
            where.add(T_COMMENT.PARENT.eq(param.getParent()));
        }
        //统计总数
        Integer total = dsl.selectCount().from(T_COMMENT).where(where).fetchOneInto(Integer.class);
        //分页数据
        List<Comment> list = dsl.select().from(T_COMMENT)
                .where(where)
                .orderBy(T_COMMENT.CREATE_TIME.desc())
                .limit((pageNum - 1) * pageSize, pageSize)
                .fetchInto(Comment.class);
        //分页对象
        PageInfo<Comment> pageInfo = new PageInfo<>(list, total, pageNum, pageSize);
        log.info("-> {}", pageInfo.toString());
        return pageInfo;
    }

    /**
     * 获取指定文章/页面评论分页
     *
     * @param aid      文章ID
     * @param pageNum  评论分页
     * @param pageSize 每页数量
     * @return 文章评论分页
     */
    public PageInfo<Comments> getComment(int aid, int pageNum, int pageSize) {
        pageNum = Optional.of(pageNum).filter(i -> (i > 0 && i < 9999)).orElse(1);
        pageSize = Optional.of(pageSize).filter(i -> (i > 0 && i < 1000)).orElse(10);
        log.info("-> 获取评论分页[pageNum: {} ,pageSize: {}]", pageNum, pageSize);

        List<Condition> where = new ArrayList<>();
        where.add(T_COMMENT.AID.eq(aid));
        where.add(T_COMMENT.STATUS.eq(COMMENT_APPROVED));
        where.add(T_COMMENT.PARENT.eq(COMMENT_PARENT));

        //统计总数
        Integer total = dsl.selectCount().from(T_COMMENT).where(where).fetchOneInto(Integer.class);
        //分页数据
        List<Comments> list = dsl.select().from(T_COMMENT)
                .where(where)
                .orderBy(T_COMMENT.CREATE_TIME.desc())
                .limit((pageNum - 1) * pageSize, pageSize)
                .fetchInto(Comments.class);
        //分页对象
        PageInfo<Comments> r = new PageInfo<>(list, total, pageNum, pageSize);

        //父级评论列表
        List<Comments> parentList = r.getList();
        //获取父级评论ID
        String aidSql = parentList.stream().map(Comment::getCid).map(String::valueOf).collect(Collectors.joining(","));
        //子评论
        List<Comments> childList = this.getChild(aidSql);
        //处理父评论的的子评论
        List<Comments> finalList = parentList.stream().map(i -> {
            Comments c = new Comments(i).setLevel(COMMENT_PARENT);
            this.handleChild(c, childList);
            return c;
        }).collect(toList());
        //
        return r.setList(finalList);
    }

    /**
     * 获取该评论下的追加评论
     *
     * @param cid 父节点ID
     */
    private List<Comments> getChild(String cid) {
        StringJoiner sql = new StringJoiner(" ");
        sql.add("with recursive cte as (");
        sql.add("select a.* from t_comment a");
        sql.add("where parent in(" + cid + ") ");
        sql.add("union all");
        sql.add("select t_comment.* from cte");
        sql.add("join t_comment on cte.cid = t_comment.parent)");
        sql.add("select * from cte order by parent, create_time desc");
        return dsl.fetch(sql.toString()).into(Comments.class);
    }

    /**
     * 构建评论树结构
     *
     * @param list   当前评论的所有子评论
     * @param parent 父评论对象
     */
    private void handleChild(Comments parent, List<Comments> list) {
        Set<Comments> childList = new HashSet<>();
        for (Comment c : list) {
            if (c.getParent().equals(parent.getCid())) {
                Comments cs = new Comments(c).setLevel(parent.getLevel() + 1);
                childList.add(cs);
                handleChild(cs, list);
            }
        }
        parent.setList(childList);
    }

    /**
     * 获取文章/页面下的评论统计
     *
     * @param aid 文章唯一标识
     */
    public Integer getCommentCount(Integer aid) {
        log.info("-> 获取文章/页面[{}]下的评论统计", aid);
        if (null == aid) {
            return 0;
        }
        return dsl.selectCount().from(T_COMMENT).where(T_COMMENT.AID.eq(aid)).and(T_COMMENT.STATUS.eq(COMMENT_APPROVED)).fetchOneInto(Integer.class);
    }
}