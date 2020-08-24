package z.blog.generator;

import lombok.extern.slf4j.Slf4j;
import org.jooq.codegen.GenerationTool;
import org.jooq.meta.jaxb.*;

@Slf4j
public class CodeGenerator {
    public static void main(String[] args) throws Exception {
        Configuration r = new Configuration()
                .withJdbc(new Jdbc()
                        .withDriver("org.sqlite.JDBC")
                        //.withUrl("jdbc:sqlite:C:\\Users\\zaoangod\\workspace\\z-blog\\src\\main\\resources\\z-blog.db")
                        .withUrl("jdbc:sqlite:D:\\workspace\\IDEA\\z-blog\\blog.db")
                        .withUser(null)
                        .withPassword(null)
                        .withAutoCommit(true)
                )
                .withGenerator(new Generator()
                        //.withName("...")
                        .withName("z.blog.generator.ReJavaGenerator")
                        .withStrategy(
                                new Strategy().withName("z.blog.generator.AsInDatabaseStrategy")
                        )
                        .withDatabase(new Database()
                                .withName("org.jooq.meta.sqlite.SQLiteDatabase")
                                .withIncludes(".*")
                                .withExcludes("sqlite_sequence|sqlite_master")
                        )
                        .withTarget(new Target()
                                .withPackageName("z.blog.mapping")
                                .withDirectory("src/main/java")
                                .withEncoding("UTF-8")
                        )
                        .withGenerate(new Generate()
                                        //代码中生成数据库index
                                        .withIndexes(false)
                                        //代码中生成数据库主键
                                        .withPrimaryKeyTypes(false)
                                        //代码中生成数据库key
                                        .withKeys(false)
                                        //
                                        .withPrimaryKeyTypes(false)
                                        //生成Dao
                                        .withDaos(false)
                                        //
                                        .withPojos(false)
                                        //为 Records, POJOs, Interfaces 生成流式 setters
                                        .withFluentSetters(true)
                                //
                                //.withTables(Boolean.FALSE)
                        )
                );
        //
        GenerationTool.generate(r);
    }
}