package z.blog.mapping;

import java.util.Collections;
import java.util.List;

import org.jooq.Schema;
import org.jooq.impl.CatalogImpl;

public class DefaultCatalog extends CatalogImpl {

    private static final long serialVersionUID = 563652619;

    /**
     * The reference instance of <code>DEFAULT_CATALOG</code>
     */
    public static final DefaultCatalog DEFAULT_CATALOG = new DefaultCatalog();

    /**
     * The schema <code>DEFAULT_SCHEMA</code>.
     */
    public final DefaultSchema DEFAULT_SCHEMA = DefaultSchema.DEFAULT_SCHEMA;

    /**
     * No further instances allowed
     */
    private DefaultCatalog() {
        super("");
    }

    @Override
    public final List<Schema> getSchemas() {
        return Collections.singletonList(DefaultSchema.DEFAULT_SCHEMA);
    }
}
