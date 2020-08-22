package z.blog.bootstrap;

import jetbrick.template.JetConfig;
import jetbrick.template.JetContext;
import jetbrick.template.JetEngine;
import jetbrick.template.JetTemplate;
import lombok.extern.slf4j.Slf4j;
import spark.ModelAndView;
import spark.TemplateEngine;

import java.io.StringWriter;
import java.util.Map;
import java.util.Properties;

/**
 * 视图配置
 */
@Slf4j
public class ViewConfig extends TemplateEngine {

    private static JetEngine jetEngine;
    private static final String SUFFIX = ".html";
    private static final Properties config = new Properties();

    public ViewConfig() {
        if (jetEngine == null) {
            synchronized (ViewConfig.class) {
                //模板的扫描路径
                config.put(JetConfig.TEMPLATE_LOADERS, "$classpathLoader");
                config.put("$classpathLoader", "jetbrick.template.loader.ClasspathResourceLoader");
                config.put("$classpathLoader.root", "/templates/");
                config.put("$classpathLoader.reloadable", "true");
                //模板后缀
                config.put(JetConfig.TEMPLATE_SUFFIX, SUFFIX);
                //扫描扩展方法
                config.put(JetConfig.AUTOSCAN_PACKAGES, "z.blog.extension");
                //启用注释指令
                config.put(JetConfig.TRIM_DIRECTIVE_COMMENTS, "true");
                jetEngine = JetEngine.create(config);
            }
        }
    }

    @Override
    public String render(ModelAndView modelAndView) {
        String templateName = modelAndView.getViewName() + SUFFIX;
        JetTemplate template = jetEngine.getTemplate(templateName);
        Object model = modelAndView.getModel();
        if (model instanceof Map) {
            Map<String, Object> modelMap = (Map<String, Object>) model;
            JetContext context = new JetContext(modelMap.size());
            context.putAll(modelMap);
            StringWriter writer = new StringWriter();
            template.render(context, writer);
            return writer.toString();
        } else {
            throw new IllegalArgumentException("modelAndView.getModel() must return a java.util.Map");
        }
    }
}