package z.blog.model.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import z.blog.model.entity.Article;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
public class ArticleParam extends Article {
    private Integer pageNum;
    private Integer pageSize;
}