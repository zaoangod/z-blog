package z.blog.route;

import lombok.extern.slf4j.Slf4j;
import spark.Route;

@Slf4j
public class Admin extends Base {
    public static Route index = (a, b) -> {
        return a("layout");
    };
}