package z.blog.mapping;

import org.jooq.Catalog;
import org.jooq.Table;
import org.jooq.impl.SchemaImpl;
import z.blog.mapping.tables.*;

import java.util.Arrays;
import java.util.List;

public class DefaultSchema extends SchemaImpl {

    private static final long serialVersionUID = 1911622756;

    public static final DefaultSchema DEFAULT_SCHEMA = new DefaultSchema();

    private DefaultSchema() {
        super("", null);
    }

    @Override
    public Catalog getCatalog() {
        return DefaultCatalog.DEFAULT_CATALOG;
    }

    @Override
    public final List<Table<?>> getTables() {
        return Arrays.asList(
                ARTICLE.T_ARTICLE,
                ATTACH.T_ATTACH,
                COMMENT.T_COMMENT,
                LOG.T_LOG,
                META.T_META,
                OPTION.T_OPTION,
                RELATIONSHIP.T_RELATIONSHIP,
                USER.T_USER);
    }
}