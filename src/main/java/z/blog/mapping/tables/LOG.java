package z.blog.mapping.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;
import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.LogRecord;

import java.util.Arrays;
import java.util.List;

public class LOG extends TableImpl<LogRecord> {

    private static final long serialVersionUID = 1605537734;

    public static final LOG T_LOG = new LOG();

    @Override
    public Class<LogRecord> getRecordType() {
        return LogRecord.class;
    }

    public final TableField<LogRecord, Integer> LID = createField(DSL.name("lid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    public final TableField<LogRecord, String> ACTION = createField(DSL.name("action"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    public final TableField<LogRecord, String> DATA = createField(DSL.name("data"), org.jooq.impl.SQLDataType.CLOB, this, "");

    public final TableField<LogRecord, String> IP = createField(DSL.name("ip"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    public final TableField<LogRecord, Integer> CREATE_TIME = createField(DSL.name("create_time"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public LOG() {
        this(DSL.name("t_log"), null);
    }

    public LOG(String alias) {
        this(DSL.name(alias), T_LOG);
    }

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
        return Internal.createUniqueKey(LOG.T_LOG, "pk_t_log", new TableField[]{LOG.T_LOG.LID}, true);
    }

    @Override
    public List<UniqueKey<LogRecord>> getKeys() {
        return Arrays.asList(
                Internal.createUniqueKey(LOG.T_LOG, "pk_t_log", new TableField[]{LOG.T_LOG.LID}, true)
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

    @Override
    public LOG rename(String name) {
        return new LOG(DSL.name(name), null);
    }

    @Override
    public LOG rename(Name name) {
        return new LOG(name, null);
    }

    @Override
    public Row5<Integer, String, String, String, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}