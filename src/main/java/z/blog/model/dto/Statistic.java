package z.blog.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Statistic {
    //文章
    private Integer post = 0;
    //页面
    private Integer page = 0;
    //评论
    private Integer comment = 0;
    //分类
    private Integer category = 0;
    //标签
    private Integer tag = 0;
    //附件
    private Integer attach = 0;
}