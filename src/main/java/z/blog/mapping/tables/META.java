package z.blog.mapping.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;
import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.MetaRecord;

import java.util.Arrays;
import java.util.List;

public class META extends TableImpl<MetaRecord> {

    private static final long serialVersionUID = 358083536;

    public static final META T_META = new META();

    @Override
    public Class<MetaRecord> getRecordType() {
        return MetaRecord.class;
    }

    public final TableField<MetaRecord, Integer> MID = createField(DSL.name("mid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    public final TableField<MetaRecord, String> TITLE = createField(DSL.name("title"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    public final TableField<MetaRecord, String> FLAG = createField(DSL.name("flag"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    public final TableField<MetaRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    public final TableField<MetaRecord, String> DESCRIPTION = createField(DSL.name("description"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    public final TableField<MetaRecord, Integer> COUNT = createField(DSL.name("count"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public META() {
        this(DSL.name("t_meta"), null);
    }

    public META(String alias) {
        this(DSL.name(alias), T_META);
    }

    public META(Name alias) {
        this(alias, T_META);
    }

    private META(Name alias, Table<MetaRecord> aliased) {
        this(alias, aliased, null);
    }

    private META(Name alias, Table<MetaRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<MetaRecord, Integer> getIdentity() {
        return Internal.createIdentity(META.T_META, META.T_META.MID);
    }

    @Override
    public UniqueKey<MetaRecord> getPrimaryKey() {
        return Internal.createUniqueKey(META.T_META, "pk_t_meta", new TableField[]{META.T_META.MID}, true);
    }

    @Override
    public List<UniqueKey<MetaRecord>> getKeys() {
        return Arrays.asList(
                Internal.createUniqueKey(META.T_META, "pk_t_meta", new TableField[]{META.T_META.MID}, true)
        );
    }

    @Override
    public META as(String alias) {
        return new META(DSL.name(alias), this);
    }

    @Override
    public META as(Name alias) {
        return new META(alias, this);
    }

    @Override
    public META rename(String name) {
        return new META(DSL.name(name), null);
    }

    @Override
    public META rename(Name name) {
        return new META(name, null);
    }

    @Override
    public Row6<Integer, String, String, String, String, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }
}