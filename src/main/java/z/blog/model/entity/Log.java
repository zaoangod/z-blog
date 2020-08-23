package z.blog.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Log {
    private Integer lid;
    private String action;
    private String data;
    private String ip;
    private Integer create_time;
}