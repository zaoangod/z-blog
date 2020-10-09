package z.blog.mapping.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;
import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.OptionRecord;

import java.util.Arrays;
import java.util.List;

public class OPTION extends TableImpl<OptionRecord> {

    private static final long serialVersionUID = 1593863997;

    public static final OPTION T_OPTION = new OPTION();

    @Override
    public Class<OptionRecord> getRecordType() {
        return OptionRecord.class;
    }

    public final TableField<OptionRecord, String> KEY = createField(DSL.name("key"), org.jooq.impl.SQLDataType.VARCHAR(50).nullable(false), this, "");

    public final TableField<OptionRecord, String> VALUE = createField(DSL.name("value"), org.jooq.impl.SQLDataType.VARCHAR(50), this, "");

    public OPTION() {
        this(DSL.name("t_option"), null);
    }

    public OPTION(String alias) {
        this(DSL.name(alias), T_OPTION);
    }

    public OPTION(Name alias) {
        this(alias, T_OPTION);
    }

    private OPTION(Name alias, Table<OptionRecord> aliased) {
        this(alias, aliased, null);
    }

    private OPTION(Name alias, Table<OptionRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public UniqueKey<OptionRecord> getPrimaryKey() {
        return Internal.createUniqueKey(OPTION.T_OPTION, "pk_t_option", new TableField[]{OPTION.T_OPTION.KEY}, true);
    }

    @Override
    public List<UniqueKey<OptionRecord>> getKeys() {
        return Arrays.asList(
                Internal.createUniqueKey(OPTION.T_OPTION, "pk_t_option", new TableField[]{OPTION.T_OPTION.KEY}, true)
        );
    }

    @Override
    public OPTION as(String alias) {
        return new OPTION(DSL.name(alias), this);
    }

    @Override
    public OPTION as(Name alias) {
        return new OPTION(alias, this);
    }

    @Override
    public OPTION rename(String name) {
        return new OPTION(DSL.name(name), null);
    }

    @Override
    public OPTION rename(Name name) {
        return new OPTION(name, null);
    }

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }
}