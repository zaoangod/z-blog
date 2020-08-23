/*
 * This file is generated by jOOQ.
 */
package z.blog.mapping.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record6;
import org.jooq.Row6;
import org.jooq.impl.UpdatableRecordImpl;

import z.blog.mapping.tables.USER;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record6<Integer, String, String, String, String, Integer> {

    private static final long serialVersionUID = -269059955;

    /**
     * Setter for <code>t_user.uid</code>.
     */
    public UserRecord setUid(Integer value) {
        set(0, value);
        return this;
    }

    /**
     * Getter for <code>t_user.uid</code>.
     */
    public Integer getUid() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>t_user.username</code>.
     */
    public UserRecord setUsername(String value) {
        set(1, value);
        return this;
    }

    /**
     * Getter for <code>t_user.username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>t_user.password</code>.
     */
    public UserRecord setPassword(String value) {
        set(2, value);
        return this;
    }

    /**
     * Getter for <code>t_user.password</code>.
     */
    public String getPassword() {
        return (String) get(2);
    }

    /**
     * Setter for <code>t_user.email</code>.
     */
    public UserRecord setEmail(String value) {
        set(3, value);
        return this;
    }

    /**
     * Getter for <code>t_user.email</code>.
     */
    public String getEmail() {
        return (String) get(3);
    }

    /**
     * Setter for <code>t_user.created</code>.
     */
    public UserRecord setCreated(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>t_user.created</code>.
     */
    public String getCreated() {
        return (String) get(4);
    }

    /**
     * Setter for <code>t_user.login_time</code>.
     */
    public UserRecord setLoginTime(Integer value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>t_user.login_time</code>.
     */
    public Integer getLoginTime() {
        return (Integer) get(5);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record6 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row6<Integer, String, String, String, String, Integer> fieldsRow() {
        return (Row6) super.fieldsRow();
    }

    @Override
    public Row6<Integer, String, String, String, String, Integer> valuesRow() {
        return (Row6) super.valuesRow();
    }

    @Override
    public Field<Integer> field1() {
        return USER.T_USER.UID;
    }

    @Override
    public Field<String> field2() {
        return USER.T_USER.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return USER.T_USER.PASSWORD;
    }

    @Override
    public Field<String> field4() {
        return USER.T_USER.EMAIL;
    }

    @Override
    public Field<String> field5() {
        return USER.T_USER.CREATED;
    }

    @Override
    public Field<Integer> field6() {
        return USER.T_USER.LOGIN_TIME;
    }

    @Override
    public Integer component1() {
        return getUid();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getPassword();
    }

    @Override
    public String component4() {
        return getEmail();
    }

    @Override
    public String component5() {
        return getCreated();
    }

    @Override
    public Integer component6() {
        return getLoginTime();
    }

    @Override
    public Integer value1() {
        return getUid();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getPassword();
    }

    @Override
    public String value4() {
        return getEmail();
    }

    @Override
    public String value5() {
        return getCreated();
    }

    @Override
    public Integer value6() {
        return getLoginTime();
    }

    @Override
    public UserRecord value1(Integer value) {
        setUid(value);
        return this;
    }

    @Override
    public UserRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UserRecord value3(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UserRecord value4(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UserRecord value5(String value) {
        setCreated(value);
        return this;
    }

    @Override
    public UserRecord value6(Integer value) {
        setLoginTime(value);
        return this;
    }

    @Override
    public UserRecord values(Integer value1, String value2, String value3, String value4, String value5, Integer value6) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UserRecord
     */
    public UserRecord() {
        super(USER.T_USER);
    }

    /**
     * Create a detached, initialised UserRecord
     */
    public UserRecord(Integer uid, String username, String password, String email, String created, Integer loginTime) {
        super(USER.T_USER);

        set(0, uid);
        set(1, username);
        set(2, password);
        set(3, email);
        set(4, created);
        set(5, loginTime);
    }
}
