package z.blog.mapping;

import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;

import java.util.Collections;
import java.util.List;

public class DefaultCatalog extends CatalogImpl {

    private static final long serialVersionUID = 563652619;

    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();

    private DefaultCatalog() {
        super("");
    }

    @Override
    public final List<Schema> getSchemas() {
        return Collections.singletonList(DefaultSchema.DEFAULT_SCHEMA);
    }
}