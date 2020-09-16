package z.blog.model.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import z.blog.model.entity.Article;

import java.util.List;

@Data
@Accessors(chain = true)
public class Archive {
    private String name;
    private String count;
    private List<Article> list;
}