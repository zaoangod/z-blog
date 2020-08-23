package z.blog.mapping.tables;

import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Row7;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;

import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.AttachRecord;

public class ATTACH extends TableImpl<AttachRecord> {

    private static final long serialVersionUID = -554959915;

    /**
     * The reference instance of <code>t_attach</code>
     */
    public static final ATTACH T_ATTACH = new ATTACH();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<AttachRecord> getRecordType() {
        return AttachRecord.class;
    }

    /**
     * The column <code>t_attach.aid</code>.
     */
    public final TableField<AttachRecord, Integer> AID = createField(DSL.name("aid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>t_attach.name</code>.
     */
    public final TableField<AttachRecord, String> NAME = createField(DSL.name("name"), org.jooq.impl.SQLDataType.VARCHAR(200), this, "");

    /**
     * The column <code>t_attach.type</code>.
     */
    public final TableField<AttachRecord, String> TYPE = createField(DSL.name("type"), org.jooq.impl.SQLDataType.VARCHAR(10), this, "");

    /**
     * The column <code>t_attach.key</code>.
     */
    public final TableField<AttachRecord, String> KEY = createField(DSL.name("key"), org.jooq.impl.SQLDataType.VARCHAR(32), this, "");

    /**
     * The column <code>t_attach.create_time</code>.
     */
    public final TableField<AttachRecord, Integer> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>t_attach.url</code>.
     */
    public final TableField<AttachRecord, Integer> URL = createField(DSL.name("url"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>t_attach.status</code>.
     */
    public final TableField<AttachRecord, Integer> STATUS = createField(DSL.name("status"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * Create a <code>t_attach</code> table reference
     */
    public ATTACH() {
        this(DSL.name("t_attach"), null);
    }

    /**
     * Create an aliased <code>t_attach</code> table reference
     */
    public ATTACH(String alias) {
        this(DSL.name(alias), T_ATTACH);
    }

    /**
     * Create an aliased <code>t_attach</code> table reference
     */
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

    /**
     * Rename this table
     */
    @Override
    public ATTACH rename(String name) {
        return new ATTACH(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ATTACH rename(Name name) {
        return new ATTACH(name, null);
    }

    // -------------------------------------------------------------------------
    // Row7 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row7<Integer, String, String, String, Integer, Integer, Integer> fieldsRow() {
        return (Row7) super.fieldsRow();
    }
}
