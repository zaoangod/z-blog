package z.blog.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Meta {
    private Integer mid;
    private String title;
    private String flag;
    private String type;
    private String description;
    private Integer count;
}