package z.blog.route;

import lombok.extern.slf4j.Slf4j;
import spark.ModelAndView;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static java.io.File.separator;
import static z.blog.Application.view;
import static z.blog.bootstrap.Constant.*;

@Slf4j
public class Base {
    /**
     * 跳转到主题页面
     */
    public static String t(String templatePath) {
        return t(null, templatePath);
    }

    public static String t(Map<String, Object> data, String templatePath) {
        data = Optional.ofNullable(data).orElse(Collections.emptyMap());
        templatePath = THEME + "/" + DEFAULT_THEME + "/" + templatePath;
        return view.render(new ModelAndView(data, templatePath));
    }

    /**
     * 跳转到后台页面
     */
    public static String a(String templatePath) {
        return a(null, templatePath);
    }

    public static String a(Map<String, Object> data, String templatePath) {
        data = Optional.ofNullable(data).orElse(Collections.emptyMap());
        templatePath = ADMIN + separator + templatePath;
        return view.render(new ModelAndView(data, templatePath));
    }

    public static Map<String, Object> data(String k, Object v) {
        Map<String, Object> param = new HashMap<>();
        param.put(k, v);
        return param;
    }

}