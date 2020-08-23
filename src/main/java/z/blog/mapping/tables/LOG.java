/*
 * This file is generated by jOOQ.
 */
package z.blog.mapping.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;

import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.LogRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class LOG extends TableImpl<LogRecord> {

    private static final long serialVersionUID = -752825626;

    /**
     * The reference instance of <code>t_log</code>
     */
    public static final LOG T_LOG = new LOG();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LogRecord> getRecordType() {
        return LogRecord.class;
    }

    /**
     * The column <code>t_log.lid</code>.
     */
    public final TableField<LogRecord, Integer> LID = createField(DSL.name("lid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>t_log.action</code>.
     */
    public final TableField<LogRecord, String> ACTION = createField(DSL.name("action"), org.jooq.impl.SQLDataType.VARCHAR(100).nullable(false), this, "");

    /**
     * The column <code>t_log.data</code>.
     */
    public final TableField<LogRecord, String> DATA = createField(DSL.name("data"), org.jooq.impl.SQLDataType.CLOB, this, "");

    /**
     * The column <code>t_log.ip</code>.
     */
    public final TableField<LogRecord, String> IP = createField(DSL.name("ip"), org.jooq.impl.SQLDataType.VARCHAR(20), this, "");

    /**
     * The column <code>t_log.create_time</code>.
     */
    public final TableField<LogRecord, Integer> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>t_log</code> table reference
     */
    public LOG() {
        this(DSL.name("t_log"), null);
    }

    /**
     * Create an aliased <code>t_log</code> table reference
     */
    public LOG(String alias) {
        this(DSL.name(alias), T_LOG);
    }

    /**
     * Create an aliased <code>t_log</code> table reference
     */
    public LOG(Name alias) {
        this(alias, T_LOG);
    }

    private LOG(Name alias, Table<LogRecord> aliased) {
        this(alias, aliased, null);
    }

    private LOG(Name alias, Table<LogRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<LogRecord, Integer> getIdentity() {
        return Internal.createIdentity(LOG.T_LOG, LOG.T_LOG.LID);
    }

    @Override
    public UniqueKey<LogRecord> getPrimaryKey() {
        return Internal.createUniqueKey(LOG.T_LOG, "pk_t_log", new TableField[] { LOG.T_LOG.LID }, true);
    }

    @Override
    public List<UniqueKey<LogRecord>> getKeys() {
        return Arrays.<UniqueKey<LogRecord>>asList(
              Internal.createUniqueKey(LOG.T_LOG, "pk_t_log", new TableField[] { LOG.T_LOG.LID }, true)
        );
    }

    @Override
    public LOG as(String alias) {
        return new LOG(DSL.name(alias), this);
    }

    @Override
    public LOG as(Name alias) {
        return new LOG(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public LOG rename(String name) {
        return new LOG(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public LOG rename(Name name) {
        return new LOG(name, null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<Integer, String, String, String, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
