package z.blog.mapping.tables;

import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;
import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.UserRecord;

import java.util.Arrays;
import java.util.List;

public class USER extends TableImpl<UserRecord> {

    private static final long serialVersionUID = 1058967889;

    public static final USER T_USER = new USER();

    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    public final TableField<UserRecord, Integer> UID = createField(DSL.name("uid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    public final TableField<UserRecord, String> USERNAME = createField(DSL.name("username"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    public final TableField<UserRecord, String> PASSWORD = createField(DSL.name("password"), org.jooq.impl.SQLDataType.VARCHAR(64), this, "");

    public final TableField<UserRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    public final TableField<UserRecord, Integer> LOGIN_TIME = createField(DSL.name("login_time"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    public USER() {
        this(DSL.name("t_user"), null);
    }

    public USER(String alias) {
        this(DSL.name(alias), T_USER);
    }

    public USER(Name alias) {
        this(alias, T_USER);
    }

    private USER(Name alias, Table<UserRecord> aliased) {
        this(alias, aliased, null);
    }

    private USER(Name alias, Table<UserRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    @Override
    public Schema getSchema() {
        return DefaultSchema.DEFAULT_SCHEMA;
    }

    @Override
    public Identity<UserRecord, Integer> getIdentity() {
        return Internal.createIdentity(USER.T_USER, USER.T_USER.UID);
    }

    @Override
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Internal.createUniqueKey(USER.T_USER, "pk_t_user", new TableField[]{USER.T_USER.UID}, true);
    }

    @Override
    public List<UniqueKey<UserRecord>> getKeys() {
        return Arrays.asList(
                Internal.createUniqueKey(USER.T_USER, "pk_t_user", new TableField[]{USER.T_USER.UID}, true)
        );
    }

    @Override
    public USER as(String alias) {
        return new USER(DSL.name(alias), this);
    }

    @Override
    public USER as(Name alias) {
        return new USER(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public USER rename(String name) {
        return new USER(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public USER rename(Name name) {
        return new USER(name, null);
    }

    @Override
    public Row5<Integer, String, String, String, Integer> fieldsRow() {
        return (Row5) super.fieldsRow();
    }
}
