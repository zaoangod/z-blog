package z.blog.model.dto;

import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SelectJoinStep;

public interface Type {

    /**
     * 文章类型
     */
    //文章
    String POST = "post";
    //页面
    String PAGE = "page";

    /**
     * 文章状态
     */
    //发布
    String PUBLISH = "publish";
    //草稿
    String DRAFT = "draft";

    /**
     * 上一个, 下一个
     */
    String NEXT = "next";
    String PREV = "prev";

    String TAG = "tag";
    String CATEGORY = "category";

    /**
     * 文章格式
     */
    String TEXT = "text";
    String HTML = "html";
    String MD = "markdown";

    /**
     * 评论相关
     * COMMENT_APPROVED: 已审核
     * COMMENT_NO_AUDIT: 未审核
     * COMMENT_PARENT: 评论父级ID
     */
    String COMMENT_APPROVED = "approved";
    String COMMENT_NO_AUDIT = "no_audit";
    Integer COMMENT_PARENT = 0;

}