package z.blog.mapping.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;
import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.ArticleRecord;

import java.util.Arrays;
import java.util.List;

public class ARTICLE extends TableImpl<ArticleRecord> {

    private static final long serialVersionUID = 1922514385;

    public static final ARTICLE T_ARTICLE = new ARTICLE();

    @Override
    public Class<ArticleRecord> getRecordType() {
        return ArticleRecord.class;
    }

    public final TableField<ArticleRecord, Integer> AID = createField(DSL.name("aid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    public final TableField<ArticleRecord, String> TITLE = createField(DSL.name("title"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    public final TableField<ArticleRecord, String> FLAG = createField(DSL.name("flag"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    public final TableField<ArticleRecord, String> CONTENT = createField(DSL.name("content"), org.jooq.impl.SQLDataType.CLOB, this, "");

    public final TableField<ArticleRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    public final TableField<ArticleRecord, String> FORMAT = createField(DSL.name("format"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    public final TableField<ArticleRecord, String> TAG = createField(DSL.name("tag"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    public final TableField<ArticleRecord, String> CATEGORY = createField(DSL.name("category"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    public final TableField<ArticleRecord, Integer> HISTORY = createField(DSL.name("history"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public final TableField<ArticleRecord, Integer> COMMENT = createField(DSL.name("comment"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public final TableField<ArticleRecord, Integer> ALLOW_COMMENT = createField(DSL.name("allow_comment"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public final TableField<ArticleRecord, Integer> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public final TableField<ArticleRecord, Integer> UPDATE_TIME = createField(DSL.name("update_time"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public final TableField<ArticleRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    public final TableField<ArticleRecord, Integer> SORT = createField(DSL.name("sort"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public ARTICLE() {
        this(DSL.name("t_article"), null);
    }

    public ARTICLE(String alias) {
        this(DSL.name(alias), T_ARTICLE);
    }

    public ARTICLE(Name alias) {
        this(alias, T_ARTICLE);
    }

    private ARTICLE(Name alias, Table<ArticleRecord> aliased) {
        this(alias, aliased, null);
    }

    private ARTICLE(Name alias, Table<ArticleRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<ArticleRecord, Integer> getIdentity() {
        return Internal.createIdentity(ARTICLE.T_ARTICLE, ARTICLE.T_ARTICLE.AID);
    }

    @Override
    public UniqueKey<ArticleRecord> getPrimaryKey() {
        return Internal.createUniqueKey(ARTICLE.T_ARTICLE, "pk_t_article", new TableField[]{ARTICLE.T_ARTICLE.AID}, true);
    }

    @Override
    public List<UniqueKey<ArticleRecord>> getKeys() {
        return Arrays.asList(
                Internal.createUniqueKey(ARTICLE.T_ARTICLE, "pk_t_article", new TableField[]{ARTICLE.T_ARTICLE.AID}, true)
        );
    }

    @Override
    public ARTICLE as(String alias) {
        return new ARTICLE(DSL.name(alias), this);
    }

    @Override
    public ARTICLE as(Name alias) {
        return new ARTICLE(alias, this);
    }

    @Override
    public ARTICLE rename(String name) {
        return new ARTICLE(DSL.name(name), null);
    }

    @Override
    public ARTICLE rename(Name name) {
        return new ARTICLE(name, null);
    }

    @Override
    public Row15<Integer, String, String, String, String, String, String, String, Integer, Integer, Integer, Integer, Integer, String, Integer> fieldsRow() {
        return (Row15) super.fieldsRow();
    }
}