package z.blog.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Comment {
    private Integer cid;
    private Integer aid;
    private Integer parent;
    private String author;
    private String mail;
    private String url;
    private String ip;
    private String agent;
    private String content;
    private String type;
    private Integer status;
    private Integer createTime;
}