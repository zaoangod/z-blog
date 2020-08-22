package z.blog.generator;

import lombok.extern.slf4j.Slf4j;
import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

@Slf4j
public class AsInDatabaseStrategy extends DefaultGeneratorStrategy {

    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        String name = super.getJavaClassName(definition, mode);
        if (name.substring(0, 1).equals("T")) {
            name = name.substring(1);
        }
        if (mode.name().equals("DEFAULT")) {
            name = name.toUpperCase();
        }
        log.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> {}, {}", mode.name(), name);
        return name;
    }
}