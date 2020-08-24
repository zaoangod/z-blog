package z.blog.bootstrap;

import lombok.extern.slf4j.Slf4j;
import z.blog.model.entity.Option;

import java.util.List;

//import static z.blog.Application.CACHE;
//import static z.blog.Application.siteService;

@Slf4j
public class Bootstrap {

    /*public static void init() {
        JooqConfig.init();
        initCache();
    }*/

    private static void initDataBate() {
        //创建文章表
        String createArticle = "create table t_article\n" +
                "(\n" +
                "    aid           integer primary key autoincrement not null unique,\n" +
                "    title         varchar(200)                      not null,\n" +
                "    flag          varchar(20),\n" +
                "    content       text,\n" +
                "    author_id     integer      default 0,\n" +
                "    type          varchar(10),\n" +
                "    format        varchar(10)  default 'markdown',\n" +
                "    tag           varchar(200) default '',\n" +
                "    category      varchar(200) default '',\n" +
                "    history       integer(10)  default 0,\n" +
                "    comment       integer(10)  default 0,\n" +
                "    allow_comment integer(2)   default 1,\n" +
                "    created       integer(10)  default 0,\n" +
                "    modified      integer(10)  default 0,\n" +
                "    status        varchar(10),\n" +
                "    sort          integer(10)  default 0\n" +
                ");";
        log.info("-> execute sql: \n{}", createArticle);
        //DSL.using(SQLDialect.SQLITE).execute(createArticle);

        String createAttach = "create table t_attach\n" +
                "(\n" +
                "    aid     integer      not null primary key autoincrement,\n" +
                "    name    varchar(100) not null,\n" +
                "    type    varchar(50),\n" +
                "    key     varchar(100),\n" +
                "    created integer(10),\n" +
                "    url     varchar(200)\n" +
                ");";
        log.info("-> execute sql: \n{}", createAttach);
        //DSL.using(SQLDialect.SQLITE).execute(createAttach);

    }

    /**
     * 初始化缓存数据
     */
    /*private static void initCache() {
        List<Option> list = siteService.getOption(null);
        list.forEach(i -> CACHE.put(i.getName(), i.getValue()));
    }*/
}