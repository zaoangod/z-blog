package z.blog.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Attach {
    private String aid;
    private String name;
    private String type;
    private String key;
    private String created;
    private String url;
}