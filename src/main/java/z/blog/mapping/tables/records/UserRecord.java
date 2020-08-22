/*
 * This file is generated by jOOQ.
 */
package z.blog.mapping.tables.records;


import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Row10;
import org.jooq.impl.UpdatableRecordImpl;

import z.blog.mapping.tables.USER;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UserRecord extends UpdatableRecordImpl<UserRecord> implements Record10<Integer, String, String, String, String, String, Integer, Integer, Integer, String> {

    private static final long serialVersionUID = 983054168;

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
     * Setter for <code>t_user.home_url</code>.
     */
    public UserRecord setHomeUrl(String value) {
        set(4, value);
        return this;
    }

    /**
     * Getter for <code>t_user.home_url</code>.
     */
    public String getHomeUrl() {
        return (String) get(4);
    }

    /**
     * Setter for <code>t_user.screen_name</code>.
     */
    public UserRecord setScreenName(String value) {
        set(5, value);
        return this;
    }

    /**
     * Getter for <code>t_user.screen_name</code>.
     */
    public String getScreenName() {
        return (String) get(5);
    }

    /**
     * Setter for <code>t_user.created</code>.
     */
    public UserRecord setCreated(Integer value) {
        set(6, value);
        return this;
    }

    /**
     * Getter for <code>t_user.created</code>.
     */
    public Integer getCreated() {
        return (Integer) get(6);
    }

    /**
     * Setter for <code>t_user.activated</code>.
     */
    public UserRecord setActivated(Integer value) {
        set(7, value);
        return this;
    }

    /**
     * Getter for <code>t_user.activated</code>.
     */
    public Integer getActivated() {
        return (Integer) get(7);
    }

    /**
     * Setter for <code>t_user.logged</code>.
     */
    public UserRecord setLogged(Integer value) {
        set(8, value);
        return this;
    }

    /**
     * Getter for <code>t_user.logged</code>.
     */
    public Integer getLogged() {
        return (Integer) get(8);
    }

    /**
     * Setter for <code>t_user.group_name</code>.
     */
    public UserRecord setGroupName(String value) {
        set(9, value);
        return this;
    }

    /**
     * Getter for <code>t_user.group_name</code>.
     */
    public String getGroupName() {
        return (String) get(9);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record10 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row10<Integer, String, String, String, String, String, Integer, Integer, Integer, String> fieldsRow() {
        return (Row10) super.fieldsRow();
    }

    @Override
    public Row10<Integer, String, String, String, String, String, Integer, Integer, Integer, String> valuesRow() {
        return (Row10) super.valuesRow();
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
        return USER.T_USER.HOME_URL;
    }

    @Override
    public Field<String> field6() {
        return USER.T_USER.SCREEN_NAME;
    }

    @Override
    public Field<Integer> field7() {
        return USER.T_USER.CREATED;
    }

    @Override
    public Field<Integer> field8() {
        return USER.T_USER.ACTIVATED;
    }

    @Override
    public Field<Integer> field9() {
        return USER.T_USER.LOGGED;
    }

    @Override
    public Field<String> field10() {
        return USER.T_USER.GROUP_NAME;
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
        return getHomeUrl();
    }

    @Override
    public String component6() {
        return getScreenName();
    }

    @Override
    public Integer component7() {
        return getCreated();
    }

    @Override
    public Integer component8() {
        return getActivated();
    }

    @Override
    public Integer component9() {
        return getLogged();
    }

    @Override
    public String component10() {
        return getGroupName();
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
        return getHomeUrl();
    }

    @Override
    public String value6() {
        return getScreenName();
    }

    @Override
    public Integer value7() {
        return getCreated();
    }

    @Override
    public Integer value8() {
        return getActivated();
    }

    @Override
    public Integer value9() {
        return getLogged();
    }

    @Override
    public String value10() {
        return getGroupName();
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
        setHomeUrl(value);
        return this;
    }

    @Override
    public UserRecord value6(String value) {
        setScreenName(value);
        return this;
    }

    @Override
    public UserRecord value7(Integer value) {
        setCreated(value);
        return this;
    }

    @Override
    public UserRecord value8(Integer value) {
        setActivated(value);
        return this;
    }

    @Override
    public UserRecord value9(Integer value) {
        setLogged(value);
        return this;
    }

    @Override
    public UserRecord value10(String value) {
        setGroupName(value);
        return this;
    }

    @Override
    public UserRecord values(Integer value1, String value2, String value3, String value4, String value5, String value6, Integer value7, Integer value8, Integer value9, String value10) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
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
    public UserRecord(Integer uid, String username, String password, String email, String homeUrl, String screenName, Integer created, Integer activated, Integer logged, String groupName) {
        super(USER.T_USER);

        set(0, uid);
        set(1, username);
        set(2, password);
        set(3, email);
        set(4, homeUrl);
        set(5, screenName);
        set(6, created);
        set(7, activated);
        set(8, logged);
        set(9, groupName);
    }
}