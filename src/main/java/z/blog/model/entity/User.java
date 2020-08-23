package z.blog.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private Integer uid;
    private String username;
    private String password;
    private String email;
    private String created;
    private Integer loginTime;
}