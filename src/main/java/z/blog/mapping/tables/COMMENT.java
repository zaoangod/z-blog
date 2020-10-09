package z.blog.mapping.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;
import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.CommentRecord;

import java.util.Arrays;
import java.util.List;

public class COMMENT extends TableImpl<CommentRecord> {

    private static final long serialVersionUID = -497061072;

    public static final COMMENT T_COMMENT = new COMMENT();

    @Override
    public Class<CommentRecord> getRecordType() {
        return CommentRecord.class;
    }

    public final TableField<CommentRecord, Integer> CID = createField(DSL.name("cid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    public final TableField<CommentRecord, Integer> AID = createField(DSL.name("aid"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public final TableField<CommentRecord, Integer> PARENT = createField(DSL.name("parent"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public final TableField<CommentRecord, String> AUTHOR = createField(DSL.name("author"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    public final TableField<CommentRecord, String> MAIL = createField(DSL.name("mail"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    public final TableField<CommentRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    public final TableField<CommentRecord, String> IP = createField(DSL.name("ip"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    public final TableField<CommentRecord, String> AGENT = createField(DSL.name("agent"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    public final TableField<CommentRecord, String> CONTENT = createField(DSL.name("content"), org.jooq.impl.SQLDataType.CLOB, this, "");

    public final TableField<CommentRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(16), this, "");

    public final TableField<CommentRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(16), this, "");

    public final TableField<CommentRecord, Integer> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public COMMENT() {
        this(DSL.name("t_comment"), null);
    }

    public COMMENT(String alias) {
        this(DSL.name(alias), T_COMMENT);
    }

    public COMMENT(Name alias) {
        this(alias, T_COMMENT);
    }

    private COMMENT(Name alias, Table<CommentRecord> aliased) {
        this(alias, aliased, null);
    }

    private COMMENT(Name alias, Table<CommentRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<CommentRecord, Integer> getIdentity() {
        return Internal.createIdentity(COMMENT.T_COMMENT, COMMENT.T_COMMENT.CID);
    }

    @Override
    public UniqueKey<CommentRecord> getPrimaryKey() {
        return Internal.createUniqueKey(COMMENT.T_COMMENT, "pk_t_comment", new TableField[]{COMMENT.T_COMMENT.CID}, true);
    }

    @Override
    public List<UniqueKey<CommentRecord>> getKeys() {
        return Arrays.asList(
                Internal.createUniqueKey(COMMENT.T_COMMENT, "pk_t_comment", new TableField[]{COMMENT.T_COMMENT.CID}, true)
        );
    }

    @Override
    public COMMENT as(String alias) {
        return new COMMENT(DSL.name(alias), this);
    }

    @Override
    public COMMENT as(Name alias) {
        return new COMMENT(alias, this);
    }

    @Override
    public COMMENT rename(String name) {
        return new COMMENT(DSL.name(name), null);
    }

    @Override
    public COMMENT rename(Name name) {
        return new COMMENT(name, null);
    }

    @Override
    public Row12<Integer, Integer, Integer, String, String, String, String, String, String, String, String, Integer> fieldsRow() {
        return (Row12) super.fieldsRow();
    }
}