package z.blog.mapping.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;
import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.AttachRecord;

import java.util.Arrays;
import java.util.List;

public class ATTACH extends TableImpl<AttachRecord> {

    private static final long serialVersionUID = -2128405753;

    public static final ATTACH T_ATTACH = new ATTACH();

    @Override
    public Class<AttachRecord> getRecordType() {
        return AttachRecord.class;
    }

    public final TableField<AttachRecord, Integer> AID = createField(DSL.name("aid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    public final TableField<AttachRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    public final TableField<AttachRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    public final TableField<AttachRecord, String> KEY = createField(DSL.name("key"), org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    public final TableField<AttachRecord, Integer> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public final TableField<AttachRecord, String> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    public final TableField<AttachRecord, String> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    public ATTACH() {
        this(DSL.name("t_attach"), null);
    }

    public ATTACH(String alias) {
        this(DSL.name(alias), T_ATTACH);
    }

    public ATTACH(Name alias) {
        this(alias, T_ATTACH);
    }

    private ATTACH(Name alias, Table<AttachRecord> aliased) {
        this(alias, aliased, null);
    }

    private ATTACH(Name alias, Table<AttachRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<AttachRecord, Integer> getIdentity() {
        return Internal.createIdentity(ATTACH.T_ATTACH, ATTACH.T_ATTACH.AID);
    }

    @Override
    public UniqueKey<AttachRecord> getPrimaryKey() {
        return Internal.createUniqueKey(ATTACH.T_ATTACH, "pk_t_attach", new TableField[]{ATTACH.T_ATTACH.AID}, true);
    }

    @Override
    public List<UniqueKey<AttachRecord>> getKeys() {
        return Arrays.asList(
                Internal.createUniqueKey(ATTACH.T_ATTACH, "pk_t_attach", new TableField[]{ATTACH.T_ATTACH.AID}, true)
        );
    }

    @Override
    public ATTACH as(String alias) {
        return new ATTACH(DSL.name(alias), this);
    }

    @Override
    public ATTACH as(Name alias) {
        return new ATTACH(alias, this);
    }

    @Override
    public ATTACH rename(String name) {
        return new ATTACH(DSL.name(name), null);
    }

    @Override
    public ATTACH rename(Name name) {
        return new ATTACH(name, null);
    }

    @Override
    public Row7<Integer, String, String, String, Integer, String, String> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}