package z.blog.controller;

import lombok.extern.slf4j.Slf4j;
import spark.ModelAndView;
import z.blog.bootstrap.ViewConfig;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static java.io.File.separator;
import static z.blog.bootstrap.Constant.*;

@Slf4j
public class Base {

    private final static ViewConfig view = new ViewConfig();

    public static String to(String templatePath) {
        return to(Collections.emptyMap(), templatePath);
    }

    public static String to(Map<String, Object> data, String templatePath) {
        Object model = Optional.ofNullable(data).orElse(Collections.emptyMap());
        return view.render(new ModelAndView(model, templatePath));
    }

    /**
     * 跳转到主题页面
     */
    public static String t(String templatePath) {
        return t(null, templatePath);
    }

    public static String theme(ModelAndView mv) {
        return t((Map<String, Object>) mv.getModel(), mv.getViewName());
    }

    public static String t(Map<String, Object> data, String templatePath) {
        data = Optional.ofNullable(data).orElse(Collections.emptyMap());
        templatePath = THEME + "/" + DEFAULT_THEME + "/" + templatePath;
        return view.render(new ModelAndView(data, templatePath));
    }

    /**
     * 跳转到后台页面
     */
    public static String admin(String templatePath) {
        return admin(null, templatePath);
    }

    public static String admin(ModelAndView mv) {
        return admin((Map<String, Object>) mv.getModel(), mv.getViewName());
    }

    public static String admin(Map<String, Object> data, String templatePath) {
        data = Optional.ofNullable(data).orElse(Collections.emptyMap());
        templatePath = ADMIN + separator + templatePath;
        return view.render(new ModelAndView(data, templatePath));
    }
}