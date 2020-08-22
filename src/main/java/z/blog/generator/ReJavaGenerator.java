package z.blog.generator;

import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.jooq.codegen.GeneratorStrategy;
import org.jooq.codegen.JavaGenerator;
import org.jooq.codegen.JavaWriter;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;
import org.jooq.meta.*;
import org.jooq.tools.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static org.jooq.tools.StringUtils.defaultString;

@Slf4j
public class ReJavaGenerator extends JavaGenerator {

    /*@Override
    protected void generateTable(SchemaDefinition schema, TableDefinition table) {
        log.info("==============================================> {}, {}", table.getOutputName(), table.getName());

        JavaWriter out = newJavaWriter(getFile(table));
        generateTable(table, out);
        closeJavaWriter(out);
    }

    @Override
    protected void generateRecordClassFooter(TableDefinition table, JavaWriter out) {
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@>");
        log.info("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@>");
        out.println();
        out.tab(1).println("public String toString() {");
        out.tab(2).println("return \"MyRecord[\" + valuesRow() + \"]\";");
        out.tab(1).println("}");
    }*/
}