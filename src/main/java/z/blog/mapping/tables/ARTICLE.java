/*
 * This file is generated by jOOQ.
 */
package z.blog.mapping.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Row16;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;

import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.ArticleRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class ARTICLE extends TableImpl<ArticleRecord> {

    private static final long serialVersionUID = 845780391;

    /**
     * The reference instance of <code>t_article</code>
     */
    public static final ARTICLE T_ARTICLE = new ARTICLE();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ArticleRecord> getRecordType() {
        return ArticleRecord.class;
    }

    /**
     * The column <code>t_article.aid</code>.
     */
    public final TableField<ArticleRecord, Integer> AID = createField(DSL.name("aid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>t_article.title</code>.
     */
    public final TableField<ArticleRecord, String> TITLE = createField(DSL.name("title"), org.jooq.impl.SQLDataType.VARCHAR(200).nullable(false), this, "");

    /**
     * The column <code>t_article.flag</code>.
     */
    public final TableField<ArticleRecord, String> FLAG = createField(DSL.name("flag"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>t_article.content</code>.
     */
    public final TableField<ArticleRecord, String> CONTENT = createField(DSL.name("content"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>t_article.author_id</code>.
     */
    public final TableField<ArticleRecord, Integer> AUTHOR_ID = createField(DSL.name("author_id"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>t_article.type</code>.
     */
    public final TableField<ArticleRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>t_article.format</code>.
     */
    public final TableField<ArticleRecord, String> FORMAT = createField(DSL.name("format"), org.jooq.impl.SQLDataType.VARCHAR(10).defaultValue(org.jooq.impl.DSL.field("'markdown'", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>t_article.tag</code>.
     */
    public final TableField<ArticleRecord, String> TAG = createField(DSL.name("tag"), org.jooq.impl.SQLDataType.VARCHAR(200).defaultValue(org.jooq.impl.DSL.field("''", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>t_article.category</code>.
     */
    public final TableField<ArticleRecord, String> CATEGORY = createField(DSL.name("category"), org.jooq.impl.SQLDataType.VARCHAR(200).defaultValue(org.jooq.impl.DSL.field("''", org.jooq.impl.SQLDataType.VARCHAR)), this, "");

    /**
     * The column <code>t_article.history</code>.
     */
    public final TableField<ArticleRecord, Integer> HISTORY = createField(DSL.name("history"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>t_article.comment</code>.
     */
    public final TableField<ArticleRecord, Integer> COMMENT = createField(DSL.name("comment"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>t_article.allow_comment</code>.
     */
    public final TableField<ArticleRecord, Integer> ALLOW_COMMENT = createField(DSL.name("allow_comment"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("1", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>t_article.created</code>.
     */
    public final TableField<ArticleRecord, Integer> CREATED = createField(DSL.name("created"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>t_article.modified</code>.
     */
    public final TableField<ArticleRecord, Integer> MODIFIED = createField(DSL.name("modified"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>t_article.status</code>.
     */
    public final TableField<ArticleRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(16), this, "");

    /**
     * The column <code>t_article.sort</code>.
     */
    public final TableField<ArticleRecord, Integer> SORT = createField(DSL.name("sort"), org.jooq.impl.SQLDataType.INTEGER.defaultValue(org.jooq.impl.DSL.field("0", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * Create a <code>t_article</code> table reference
     */
    public ARTICLE() {
        this(DSL.name("t_article"), null);
    }

    /**
     * Create an aliased <code>t_article</code> table reference
     */
    public ARTICLE(String alias) {
        this(DSL.name(alias), T_ARTICLE);
    }

    /**
     * Create an aliased <code>t_article</code> table reference
     */
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
        return Internal.createUniqueKey(ARTICLE.T_ARTICLE, "pk_t_article", new TableField[] { ARTICLE.T_ARTICLE.AID }, true);
    }

    @Override
    public List<UniqueKey<ArticleRecord>> getKeys() {
        return Arrays.<UniqueKey<ArticleRecord>>asList(
              Internal.createUniqueKey(ARTICLE.T_ARTICLE, "pk_t_article", new TableField[] { ARTICLE.T_ARTICLE.AID }, true)
            , Internal.createUniqueKey(ARTICLE.T_ARTICLE, "sqlite_autoindex_t_article_1", new TableField[] { ARTICLE.T_ARTICLE.AID }, true)
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

    /**
     * Rename this table
     */
    @Override
    public ARTICLE rename(String name) {
        return new ARTICLE(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ARTICLE rename(Name name) {
        return new ARTICLE(name, null);
    }

    // -------------------------------------------------------------------------
    // Row16 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row16<Integer, String, String, String, Integer, String, String, String, String, Integer, Integer, Integer, Integer, Integer, String, Integer> fieldsRow() {
        return (Row16) super.fieldsRow();
    }
}
