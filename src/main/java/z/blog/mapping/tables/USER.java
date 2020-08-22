/*
 * This file is generated by jOOQ.
 */
package z.blog.mapping.tables;


import java.util.Arrays;
import java.util.List;

import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Row10;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;
import org.jooq.impl.TableImpl;

import z.blog.mapping.DefaultSchema;
import z.blog.mapping.tables.records.UserRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class USER extends TableImpl<UserRecord> {

    private static final long serialVersionUID = -694680724;

    /**
     * The reference instance of <code>t_user</code>
     */
    public static final USER T_USER = new USER();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UserRecord> getRecordType() {
        return UserRecord.class;
    }

    /**
     * The column <code>t_user.uid</code>.
     */
    public final TableField<UserRecord, Integer> UID = createField(DSL.name("uid"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>t_user.username</code>.
     */
    public final TableField<UserRecord, String> USERNAME = createField(DSL.name("username"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>t_user.password</code>.
     */
    public final TableField<UserRecord, String> PASSWORD = createField(DSL.name("password"), org.jooq.impl.SQLDataType.VARCHAR(64).nullable(false), this, "");

    /**
     * The column <code>t_user.email</code>.
     */
    public final TableField<UserRecord, String> EMAIL = createField(DSL.name("email"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>t_user.home_url</code>.
     */
    public final TableField<UserRecord, String> HOME_URL = createField(DSL.name("home_url"), org.jooq.impl.SQLDataType.VARCHAR(255), this, "");

    /**
     * The column <code>t_user.screen_name</code>.
     */
    public final TableField<UserRecord, String> SCREEN_NAME = createField(DSL.name("screen_name"), org.jooq.impl.SQLDataType.VARCHAR(100), this, "");

    /**
     * The column <code>t_user.created</code>.
     */
    public final TableField<UserRecord, Integer> CREATED = createField(DSL.name("created"), org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>t_user.activated</code>.
     */
    public final TableField<UserRecord, Integer> ACTIVATED = createField(DSL.name("activated"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>t_user.logged</code>.
     */
    public final TableField<UserRecord, Integer> LOGGED = createField(DSL.name("logged"), org.jooq.impl.SQLDataType.INTEGER, this, "");

    /**
     * The column <code>t_user.group_name</code>.
     */
    public final TableField<UserRecord, String> GROUP_NAME = createField(DSL.name("group_name"), org.jooq.impl.SQLDataType.VARCHAR(16), this, "");

    /**
     * Create a <code>t_user</code> table reference
     */
    public USER() {
        this(DSL.name("t_user"), null);
    }

    /**
     * Create an aliased <code>t_user</code> table reference
     */
    public USER(String alias) {
        this(DSL.name(alias), T_USER);
    }

    /**
     * Create an aliased <code>t_user</code> table reference
     */
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
    public UniqueKey<UserRecord> getPrimaryKey() {
        return Internal.createUniqueKey(USER.T_USER, "pk_t_user", new TableField[] { USER.T_USER.UID }, true);
    }

    @Override
    public List<UniqueKey<UserRecord>> getKeys() {
        return Arrays.<UniqueKey<UserRecord>>asList(
              Internal.createUniqueKey(USER.T_USER, "pk_t_user", new TableField[] { USER.T_USER.UID }, true)
            , Internal.createUniqueKey(USER.T_USER, "sqlite_autoindex_t_user_1", new TableField[] { USER.T_USER.UID }, true)
            , Internal.createUniqueKey(USER.T_USER, "sqlite_autoindex_t_user_2", new TableField[] { USER.T_USER.USERNAME }, true)
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

    // -------------------------------------------------------------------------
    // Row10 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, String, String, String, String, String, Integer, Integer, Integer, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }
}