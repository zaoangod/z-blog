package z.blog.bootstrap;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.jooq.impl.*;

import javax.sql.DataSource;

/**
 * JOOQ 配置
 */
@Slf4j
public class JooqConfig {

    public static DSLContext dsl = null;

    private static HikariDataSource dataSource = null;

    static {
        dslContext();
    }

    private JooqConfig() {
    }

    private static void dslContext() {
        if (dsl == null) {
            synchronized (JooqConfig.class) {
                //数据库连接池
                DataSource dataSource = getDataSource();
                //
                final ConnectionProvider connectionProvider = new DataSourceConnectionProvider(dataSource);
                //事务
                TransactionProvider transactionProvider = new DefaultTransactionProvider(connectionProvider);

                final Configuration configuration = new DefaultConfiguration()
                        .set(connectionProvider)
                        .set(transactionProvider)
                        .set(SQLDialect.SQLITE)
                        .set(new ThreadLocalTransactionProvider(connectionProvider, true));
                dsl = DSL.using(configuration);
            }
        }
    }

    private static HikariDataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new HikariDataSource();
            dataSource.setAutoCommit(true);
            //dataSource.setJdbcUrl("jdbc:sqlite:blog.db");
            //dataSource.setJdbcUrl("jdbc:sqlite:C:\\Users\\zaoangod\\workspace\\z-blog\\src\\main\\resources\\z-blog.db");
            dataSource.setJdbcUrl("jdbc:sqlite:C:\\Users\\zaoangod\\workspace\\z-blog\\blog.db");
            dataSource.setPoolName("blog-db-pool");
        }
        return dataSource;
    }
}