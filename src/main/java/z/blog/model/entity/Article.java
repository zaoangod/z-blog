package z.blog.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Article {
    private Integer aid;
    private String title;
    private String flag;
    private String content;
    private String type;
    private String format;
    private String tag;
    private String category;
    private Integer history;
    private Integer comment;
    private Integer allowComment;
    private Integer createTime;
    private Integer updateTime;
    private String status;
    private Integer sort;
}