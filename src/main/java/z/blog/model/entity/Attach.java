package z.blog.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Attach {
    private Integer aid;
    private String name;
    private String type;
    private String key;
    private Integer createTime;
    private String url;
    private String status;
}