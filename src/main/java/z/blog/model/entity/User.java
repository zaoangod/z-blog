package z.blog.model.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
    private String uid;
    private String username;
    private String password;
    private String email;
    private String home_url;
    private String screen_name;
    private String created;
    private String activated;
    private String logged;
    private String group_name;
}